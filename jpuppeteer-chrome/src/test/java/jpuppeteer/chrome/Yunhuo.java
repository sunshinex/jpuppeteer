package jpuppeteer.chrome;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.vip.pricing.helper.YHYXHelper;
import com.vip.pricing.helper.entity.YHYXSign;
import lombok.Data;
import org.apache.http.*;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.script.ScriptException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class Yunhuo {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    private static final int ORGANIZATION_ID = 967415;

    private static final int USER_ID = 28917137;

    private static final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIyODkxNzEzNyIsInN1YiI6IuWMv-WQjeeUqOaItyIsImlhdCI6MTYwNjg3ODc5Nn0.znlosnqfsDweLspsvxxkYkaM-LwUKCJVubY5r5e5k2s";

    private static final int PAGE_SIZE = 20;

    private static JSONObject request(HttpUriRequest request) throws IOException {
        CloseableHttpResponse response = httpClient.execute(request);
        try {
            StatusLine status = response.getStatusLine();
            if (status.getStatusCode() != HttpStatus.SC_OK) {
                throw new HttpResponseException(status.getStatusCode(), status.getReasonPhrase());
            }
            String body = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            JSONObject json = JSON.parseObject(body);
            if (json.getIntValue("resultCode") != 0) {
                throw new RuntimeException(json.getString("resultMsg") + "("+json.getString("resultCode")+")");
            }
            return json.getJSONObject("resultData");
        } finally {
            HttpClientUtils.closeQuietly(response);
        }
    }

    private static JSONObject callApi(String url, JSONObject data) throws IOException {
        HttpPost request = new HttpPost(url);
        List<NameValuePair> params = new ArrayList<>();
        for(Map.Entry<String, Object> entry : data.entrySet()) {
            params.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
        }
        params.add(new BasicNameValuePair("data", data.toJSONString()));
        request.setEntity(EntityBuilder.create()
                .setContentType(ContentType.APPLICATION_FORM_URLENCODED)
                .setContentEncoding(StandardCharsets.UTF_8.name())
                .setParameters(params)
                .build());
        request.setHeader("X-AUTH-TOKEN", TOKEN);
        request.setHeader(HttpHeaders.REFERER, "https://servicewechat.com/wxc4ac84a6ba2fd2d5/601/page-frame.html");
        request.setHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate");
        request.setHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36 MicroMessenger/7.0.9.501 NetType/WIFI MiniProgramEnv/Windows WindowsWechat");
        return request(request);
    }

    private static JSONObject callGateway(String api, JSONObject param) throws IOException, ScriptException, NoSuchMethodException {
        HttpPost request = new HttpPost("https://inspire-gateway-pro.yunhuotong.net/" + api);
        YHYXSign sign = YHYXHelper.signature(api, param);
        JSONObject entity = new JSONObject();
        entity.put("api", sign.api);
        entity.put("caller", sign.caller);
        entity.put("requestId", sign.requestId);
        entity.put("time", sign.time);
        entity.put("sign", sign.sign);
        entity.put("param", param);
        request.setEntity(EntityBuilder.create()
                .setContentType(ContentType.APPLICATION_JSON)
                .setContentEncoding(StandardCharsets.UTF_8.name())
                .setText(JSON.toJSONString(entity))
                .build());
        request.setHeader(HttpHeaders.REFERER, "https://servicewechat.com/wxc4ac84a6ba2fd2d5/601/page-frame.html");
        request.setHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate");
        request.setHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36 MicroMessenger/7.0.9.501 NetType/WIFI MiniProgramEnv/Windows WindowsWechat");
        return request(request);
    }

    private static JSONObject newParams() {
        JSONObject params = new JSONObject();
        params.put("groupId", 2);
        params.put("userId", USER_ID);
        params.put("sortField", 1);
        params.put("versionCode", 54);
        params.put("timeStamp", System.currentTimeMillis());
        return params;
    }

    private static JSONObject cache(String tag, Callable<JSONObject> loading) throws Exception {
        File cache = new File("D:\\tmp\\yunhuo\\" + tag);
        if (!cache.exists()) {
            synchronized (tag) {
                if (!cache.exists()) {
                    JSONObject result = loading.call();
                    FileWriter writer = new FileWriter(cache);
                    String str = JSON.toJSONString(result);
                    writer.write(str);
                    writer.close();
                    return result;
                }
            }
        }
        byte[] b = Files.readAllBytes(Paths.get(cache.getAbsolutePath()));
        return JSON.parseObject(new String(b, StandardCharsets.UTF_8));
    }

    private static List<Category> categoryList() throws IOException {
        String url = "https://yhtplus.yunhuotong.net/yhtplus/weiXinUser/getOrganizationHomeCategoryAndTitle.action";
        JSONObject result = callApi(url, newParams());
        return result.getJSONArray("brandCategoryClassifyList").toJavaList(Category.class);
    }

    private static List<Activity> activityList(Integer categoryId) throws Exception {
        String tag = "category-" + categoryId + ".cache";
        return cache(
                tag,
                () -> {
                    String url = "https://yhtplus.yunhuotong.net/yhtplus/goodsGroup/getGoodsGroupByBrandCategory.action";
                    JSONObject params = newParams();
                    params.put("organizationId", ORGANIZATION_ID);
                    params.put("brandCategoryClassifyId", categoryId);
                    return callApi(url, params);
                })
                .getJSONArray("goodsGroupBcategoryRedisList")
                .toJavaList(Activity.class);
    }

    private static ActivityDetail activityDetail(Integer activityId) throws Exception {
        String tag = "activity-" + activityId + ".cache";
        return cache(
                tag,
                () -> {
                    String api = "weeget-bullet-goods-rest/goodsGroup/getGoodsGroupByGoodsGroupId";
                    JSONObject param = newParams();
                    param.put("inviteUserId", "");
                    param.put("goodsGroupId", activityId);
                    param.put("organizationId", ORGANIZATION_ID);
                    return callGateway(api, param);
                })
                .getObject("goodsGroup", ActivityDetail.class);
    }

    private static List<Goods> goodsList(Integer activityId, int page) throws Exception {
        String tag = "list-" + activityId + "-" + page + ".cache";
        JSONObject result = cache(
                tag,
                () -> {
                    String api = "weeget-bullet-goods-rest/goods/getOrganizationGoodsList";
                    JSONObject param = newParams();
                    param.put("goodsGroupId", activityId);
                    param.put("length", PAGE_SIZE);
                    param.put("startIndex", page * PAGE_SIZE);
                    param.put("organizationId", ORGANIZATION_ID);
                    return callGateway(api, param);
                });
        JSONArray goodsList = result.getJSONArray("goodsList");
        if (goodsList == null) {
            return null;
        }
        return goodsList.toJavaList(Goods.class);
    }

    public static void main(String[] args) throws Exception {
        List<Category> categories = categoryList();
        FileWriter brands = new FileWriter("D:\\tmp\\yunhuo\\brands.csv");
        FileWriter goods = new FileWriter("D:\\tmp\\yunhuo\\goods.csv");
        brands.write("品牌ID,品牌分类,品牌名称,上线时间,下线时间\r\n");
        goods.write("品牌ID,品牌名称,上线时间,下线时间,商品ID,货号,商品名称,商品主图,供货价,商城价,最低价,市场价\r\n");
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        for(Category category : categories) {
            List<Activity> activities = activityList(category.id);
            for(Activity activity : activities) {
                ActivityDetail detail = activityDetail(activity.id);
                brands.write(String.valueOf(activity.id));
                brands.write(",");
                brands.write(category.title);
                brands.write(",\"");
                brands.write(activity.name);
                brands.write("\",");
                brands.write(sdf.format(detail.saleStartTime));
                brands.write(",");
                brands.write(sdf.format(detail.saleEndTime));
                brands.write("\r\n");
                brands.flush();
                int page = 0;
                while (true) {
                    System.out.println("处理活动：" + activity.name + "("+activity.id+")，第" + page + "页");
                    List<Goods> goodsList = goodsList(activity.id, page);
                    if (goodsList == null) {
                        break;
                    }
                    for(Goods g : goodsList) {
                        goods.write(String.valueOf(activity.id));
                        goods.write(",\"");
                        goods.write(String.valueOf(activity.name));
                        goods.write("\",");
                        goods.write(sdf.format(detail.saleStartTime));
                        goods.write(",");
                        goods.write(sdf.format(detail.saleEndTime));
                        goods.write(",");
                        goods.write(String.valueOf(g.goodsId));
                        goods.write(",");
                        goods.write(String.valueOf(g.goodsNumber));
                        goods.write(",\"");
                        goods.write(String.valueOf(g.goodsName));
                        goods.write("\",\"");
                        goods.write("https://imagecos.yunhuotong.net/yhtplusFile/" + String.valueOf(g.goodsDefaultImage) + ".jpg");
                        goods.write("\",");
                        goods.write(String.valueOf(g.supplyPrice));
                        goods.write(",");
                        goods.write(String.valueOf(g.dailyPrice));
                        goods.write(",");
                        goods.write(String.valueOf(g.lowestPrice));
                        goods.write(",");
                        goods.write(String.valueOf(g.marketPrice));
                        goods.write("\r\n");
                        goods.flush();
                    }
                    if (goodsList.size() < PAGE_SIZE) {
                        break;
                    }
                    page++;
                }
            }
        }
        goods.close();
        brands.close();
    }

    @Data
    static class Category {

        @JSONField(name = "firstClassify")
        private String title;

        private Integer id;

    }

    @Data
    static class Activity {

        @JSONField(name = "groupName")
        private String name;

        @JSONField(name = "goodsGroupId")
        private Integer id;

    }

    @Data
    static class ActivityDetail extends Activity {

        private Date saleStartTime;

        private Date saleEndTime;

    }

    @Data
    static class Goods {

        private Integer goodsId;

        private String goodsName;

        private String goodsNumber;

        private String goodsDefaultImage;

        private BigDecimal supplyPrice;

        private BigDecimal dailyPrice;

        private BigDecimal lowestPrice;

        private BigDecimal marketPrice;

    }
}

# jpuppeteer
java版本的puppeteer

# <font color=#ff0000>warning</font>
<font color=#ff0000>整个模型为单线程，请不要在future listener或者event listener中放置任何的阻塞代码，请用线程池执行阻塞代码</font>

# 启动浏览器
```Java
Browser browser = new ChromeLauncher("D:\\workspace\\win32-x64\\chrome.exe").launch(args);
```

# 默认上下文
```Java
BrowserContext context = browser.defaultContext();
```

# 创建上下文
```Java
Future<BrowserContext> future = browser.createContext();
```

# 创建页面
```Java
Future<Page> future = context.newPage();
```

# 查找节点
```Java
Future<Element> future = page.querySelector("body");
```

# 事件监听
```Java
page.addListener(new AbstractListener<PageLoaded>() {
    @Override
    public void accept(PageLoaded loadEvent) {
        System.out.println("page loaded, duration=" + loadEvent.timestamp());
    }
});
```

# DEMO
```Java
Browser browser = new ChromeLauncher("D:\\workspace\\win32-x64\\chrome.exe").launch();
Page page = browser.defaultContext().newPage().get();
page.addListener(new AbstractListener<LoadedEvent>() {
    @Override
    public void accept(LoadedEvent event) {
        SeriesFuture
            .wrap(page.querySelector("#kw"))
            .async(o -> o.input("test"))
            .async(o -> page.querySelector("#su"))
            .async(o -> {
                Element el = (Element) o;
                return el.click();
            })
            .addListener(f -> {
                if (f.cause() != null) {
                    f.cause().printStackTrace();
                } else {
                    System.out.println("OK");
                }
            });
    }
});
page.navigate("https://www.baidu.com/");
```
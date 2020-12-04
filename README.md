# jpuppeteer
java版本的puppeteer

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
page.addListener(new AbstractListener<PageLoaded>() {
    @Override
    public void accept(PageLoaded loadEvent) {
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
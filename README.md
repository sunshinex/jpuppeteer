# jpuppeteer
java版本的puppeteer

# 启动浏览器
```Java
ChromeBrowser browser = new ChromeLauncher("D:\\workspace\\win32-x64\\chrome.exe").launch(args);
```

# 默认上下文
```Java
ChromeContext context = browser.defaultContext();
```

# 创建上下文
```Java
ChromeContext context = browser.createContext();
```

# 创建页面
```Java
ChromePage page = context.newPage();
```

# 查找节点
```Java
ChromeElement element = page.querySelector("selector");
```

# 事件监听
```Java
page.addListener(new AbstractListener<PageLoaded>() {
    @Override
    public void accept(PageLoaded loadEvent) {
        System.out.println("page loaded, duration=" + loadEvent.duration());
    }
});
```

# DEMO
```Java
ChromeBrowser browser = new ChromeLauncher("D:\\workspace\\win32-x64\\chrome.exe").launch();
ChromePage page = browser.defaultContext().newPage();
page.addListener(new AbstractListener<PageLoaded>() {
    @Override
    public void accept(PageLoaded loadEvent) {
        try {
            Element kw = page.waitSelector("#kw", 5, TimeUnit.SECONDS);
            kw.input("test");
            page.querySelector("#su").click();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
});
page.navigate("https://www.baidu.com/");
```
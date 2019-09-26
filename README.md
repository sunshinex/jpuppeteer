# jpuppeteer
java puppeteer use chrome devtools protocol

#usage
Browser browser = new ChromeLauncher(new File("D:\\workspace\\win32-x64\\chrome.exe")).launch(args);
Page<CallArgument> page = browser.defaultContext().newPage();


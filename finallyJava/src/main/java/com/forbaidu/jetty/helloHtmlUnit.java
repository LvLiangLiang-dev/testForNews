package com.forbaidu.jetty;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


/**
 * Created by zhouhaiming on 2017-4-14 11:54
 * Email: dg_chow@163.com
 */
 class HelloHtmlUnit {
    public static void main(String[] args) throws Exception {
//        String str;
//        //创建一个webclient
//        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);
//        // 启动JS
//        webClient.getOptions().setJavaScriptEnabled(true);
//        //忽略ssl认证
//        webClient.getOptions().setUseInsecureSSL(true);
//        //禁用Css，可避免自动二次请求CSS进行渲染
//        webClient.getOptions().setCssEnabled(false);
//        //运行错误时，不抛出异常
//        webClient.getOptions().setThrowExceptionOnScriptError(false);
//        // 设置Ajax异步
//        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
//        //设置代理
//        ProxyConfig proxyConfig = webClient.getOptions().getProxyConfig();
//        proxyConfig.setProxyHost("192.168.17.47");
//        proxyConfig.setProxyPort(8888);
//        CredentialsProvider creds = new BasicCredentialsProvider();
//        creds.setCredentials(
//                new AuthScope("192.168.17.47", 8888),
//                new UsernamePasswordCredentials("", ""));
//        webClient.setCredentialsProvider(creds);

//        protected WebClient modifyWebClient(WebClient client)
//        {
//        DefaultCredentialsProvider creds = new DefaultCredentialsProvider();
//        creds.addCredentials("用户名", "密码");
//        client.setCredentialsProvider(creds);
//        return client;
//        }
//        };
//
//        //获取页面
//        HtmlPage page = webClient.getPage("http://10.154.65.15/Login.aspx");
//        //获取页面的TITLE
//        str = page.getTitleText();
//        System.out.println(str);
//        //获取页面的XML代码
//        str = page.asXml();
//        System.out.println(str);
//        //获取页面的文本
//        str = page.asText();
//        System.out.println(str);
//        //关闭webclient
//        webClient.close();
        HelloHtmlUnit HelloHtmlUnit = new HelloHtmlUnit();
        HelloHtmlUnit.homePage_proxy();
    }

    public void homePage_proxy() throws Exception {
        try {
            final WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_8, "192.168.17.47", 8888);
            // 启动JS
            webClient.getOptions().setJavaScriptEnabled(true); // 1 启动JS
            webClient.getOptions().setCssEnabled(true);    // 2 禁用Css，可避免自动二次请求CSS进行渲染
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
            webClient.getOptions().setThrowExceptionOnScriptError(false);   // 4 js运行错误时，是否抛出异常
            webClient.setAjaxController(new NicelyResynchronizingAjaxController());
            webClient.setJavaScriptTimeout(5000);
            webClient.getOptions().setTimeout(50000);            // 5 设置超时
            webClient.getOptions().setRedirectEnabled(true); // 3 启动客户端重定向
            //set proxy username and password
            final DefaultCredentialsProvider credentialsProvider = (DefaultCredentialsProvider) webClient.getCredentialsProvider();
            credentialsProvider.addCredentials("username", "password");

            final HtmlPage page = webClient.getPage("http://10.154.65.15/Login.aspx");
            //获取页面的TITLE
            String str = page.getTitleText();
            System.out.println(str);
            //获取页面的XML代码
            str = page.asXml();
            System.out.println(str);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


//    Proxy proxy = new Proxy();
////设置代理服务器地址
//        proxy.setHttpProxy("代理服务器地址:端口号");
//                DesiredCapabilities capabilities = DesiredCapabilities.htmlUnit();
//                capabilities.setCapability(CapabilityType.PROXY, proxy);
//                WebDriver driver = new HtmlUnitDriver(capabilities)
//                {
//@Override
//protected WebClient modifyWebClient(WebClient client)
//        {
//        DefaultCredentialsProvider creds = new DefaultCredentialsProvider();
//        creds.addCredentials("用户名", "密码");
//        client.setCredentialsProvider(creds);
//        return client;
//        }
//        };
//        driver.get("http://www.baidu.com");
//        System.out.println("[" + driver.getTitle() + "]");

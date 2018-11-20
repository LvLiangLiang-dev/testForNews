package com.forbaidu.jetty;

import com.google.gson.Gson;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: 周海明
 * Date: 2017/3/6
 * Time: 15:21
 * 获取json字符串请求 文件下载
 */
public class PostFileDownload extends HttpServlet {

    private String enc = "utf-8";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 读取请求内容
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        // 将资料解码
        String reqBody = sb.toString();
        Gson gson = new Gson();
        FileBean fileBean = gson.fromJson(reqBody, FileBean.class);
        response.getWriter().print(fileBean.toString());

        File file = new File("E:\\Serv-U.zip");
        if (file.exists()) {
            int fileLength = (int) file.length();
            String filename = URLEncoder.encode(fileBean.getFileName(), enc);//filename="Serv-U.zip"
            response.reset();
            response.addHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
            response.setContentLength(fileLength);//设置内容长度
            response.setCharacterEncoding("utf-8");//设置响应的编码为“utf-8”
            response.setContentType("application/octet-stream");//设置内容类型 。  .*（ 二进制流，不知道下载文件类型）
            FileInputStream inputStream = new FileInputStream(file);
            ServletOutputStream outputStream = response.getOutputStream();
            byte[] buf = new byte[2048];
            int readLength;
            while ((readLength = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, readLength);
            }
            inputStream.close();
            outputStream.flush();
            outputStream.close();
        }
    }
}


class FileBean {
    String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}


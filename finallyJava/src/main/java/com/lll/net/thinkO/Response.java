package com.lll.net.thinkO;
/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time��2017��4��27�� ����3:12:45
* class illustration:
*/

import java.io.OutputStream;
import java.io.IOException;
import java.io.FileInputStream;

public class Response {
	private static final int BUFFER_SIZE = 1024;
    Request request;
    OutputStream output;

    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n" + "Content-Type: text/html\r\n"
                        + "Content-Length: 23\r\n" + "\r\n" + "<h1>File Not Found</h1>";
                String message="<h1>Welcome ThinkO</h1>";
                output.write(message.getBytes());
            }catch (Exception e) {
            // thrown if cannot instantiate a File object
            System.out.println(e.toString());
        } finally {
            if (fis != null)
                fis.close();
        }
    }
}
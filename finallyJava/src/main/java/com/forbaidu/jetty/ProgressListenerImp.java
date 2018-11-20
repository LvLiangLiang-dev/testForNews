package com.forbaidu.jetty;

import org.apache.commons.fileupload.ProgressListener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: 周海明
 * Date: 2017/3/7
 * Time: 14:34
 */
public class ProgressListenerImp implements ProgressListener {

    private HttpSession session;

    public ProgressListenerImp(HttpServletRequest req) {
        session = req.getSession();
        FileUploadStatus status = new FileUploadStatus();
        session.setAttribute("status", status);
    }

    @Override
    public void update(long pBytesRead, long pContentLength, int arg2) {
        System.out.println("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead);
        /**
         * 文件大小为：14608,当前已处理：4096
         文件大小为：14608,当前已处理：7367
         文件大小为：14608,当前已处理：11419
         文件大小为：14608,当前已处理：14608
         */

        FileUploadStatus status = (FileUploadStatus) session.getAttribute("status");
        status.setpBytesRead(pBytesRead);
        status.setpContentLength(pContentLength);
        status.setpItems(arg2);

    }
}

package com.me.utils.http;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 针对各浏览器，http中ContentDisposition响应头的处理
 */
public class ContentDispositionUtils {

    /**
     * 针对各浏览器处理响应头，保证文件名不乱码
     * @param request
     * @param fileName 需要处理的文件名
     * @return 处理好的文件名
     * @author lixuetao
     * date 2018-08-28
     **/
    public static String handler(HttpServletRequest request, String fileName) throws UnsupportedEncodingException {
        String userAgent = request.getHeader("User-Agent");

        String rtn = "filename=\"" + URLEncoder.encode(fileName, "UTF8") + "\""; //默认为IE的处理方式
        if (userAgent != null) {
            userAgent = userAgent.toLowerCase();

            //chrome浏览器，FireFox浏览器，可以使用MimeUtility或filename*或ISO编码的中文输出
            if (userAgent.indexOf("mozilla") != -1) {
                if (userAgent.indexOf("firefox") != -1) {
                    rtn = "filename*=\"UTF-8''" + URLEncoder.encode(fileName, "UTF8") + "\"";
                } else {
                    rtn = "filename*=\"UTF-8''" + URLEncoder.encode(fileName, "UTF8");
                }
            } else if (userAgent.indexOf("opera") != -1) {
                // Opera浏览器只能采用filename*
                if (userAgent.indexOf("firefox") != -1) {
                    rtn = "filename*=\"UTF-8''" + URLEncoder.encode(fileName, "UTF8") + "\"";
                } else {
                    rtn = "filename*=\"UTF-8''" + URLEncoder.encode(fileName, "UTF8");
                }

            } else if (userAgent.indexOf("safari") != -1) {
                // Safari浏览器，只能采用ISO编码的中文输出
                rtn = "filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO8859-1") + "\"";
            }
        }
        rtn = rtn.replaceAll("\\+", " ");

        return rtn;
    }

}

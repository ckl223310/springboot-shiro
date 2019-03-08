package com.me.utils.http.post;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Xss使用的post流，将post请求封装
 */
public class PostServletInputStream extends ServletInputStream {

    /**
     * 输入流
     */
    private InputStream inputStream;
    /**
     * 解析json之后的文本
     */
    private String body;

    public PostServletInputStream(String body) throws IOException {
        this.body = body;
        inputStream = null;
    }


    /**
     * 接受的请求流
     *
     * @return
     * @throws IOException
     */
    private InputStream acquireInputStream() throws IOException {
        if (inputStream == null) {
            inputStream = new ByteArrayInputStream(body.getBytes()); //通过解析之后传入的文本生成inputStream以便后面control调用
        }

        return inputStream;
    }

    /**
     * 关闭流
     *
     * @throws IOException
     */
    public void close() throws IOException {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            throw e;
        } finally {
            inputStream = null;
        }
    }


    /**
     * 读取请求流
     *
     * @return
     * @throws IOException
     */
    public int read() throws IOException {
        return acquireInputStream().read();
    }

    /**
     * markSupported
     *
     * @return
     */
    public boolean markSupported() {
        return false;
    }

    /**
     * mark
     *
     * @param i
     */
    public synchronized void mark(int i) {
        throw new UnsupportedOperationException("mark not supported");
    }


    /**
     * reset
     *
     * @throws IOException
     */
    public synchronized void reset() throws IOException {
        throw new IOException(new UnsupportedOperationException("reset not supported"));
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setReadListener(ReadListener readListener) {

    }
}

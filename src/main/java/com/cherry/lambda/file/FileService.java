package com.cherry.lambda.file;

import java.io.*;

/**
 * 文件服务类
 */
public class FileService {

    /**
     * 通过url读取本地文件内容，调用函数式接口处理
     * @param url
     * @param fileCustomer
     */
    public void fileHandle(String url, FileCustomer fileCustomer) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(url)));

        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line +'\n');
        }

        fileCustomer.fileHandler(stringBuilder.toString());

    }


}

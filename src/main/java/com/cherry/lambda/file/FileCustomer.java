package com.cherry.lambda.file;

/**
 * 文件处理函数式接口
 */
@FunctionalInterface
public interface FileCustomer {

    /**
     * 函数式接口抽象方法
     * @param fileContent -文件内容字符串
     */
    void fileHandler(String fileContent);

}

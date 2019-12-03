package com.cherry.lambda.file;

import org.junit.Test;

import java.io.IOException;

public class FileServiceTest {

    @Test
    public void testFileService() throws IOException {

        FileService fileService = new FileService();

        fileService.fileHandle("E:\\src\\git\\996\\src\\main\\java" +
                "\\com\\cherry\\lambda\\file\\FileService.java",
                fileContent -> System.out.println(fileContent));


    }

}

package com.cherry.lambda.file;

import java.util.function.Consumer;

/**
 * 测试方法引用的几种方式
 */
public class LambdaTest {

    public static void main(String[] args){


        /**
         * (args) ->object.instanceMethod(args);
         * object::instanceMethod;
         */
        StringBuilder stringBuilder = new StringBuilder();
        Consumer<String>
                consumer = (String str) -> stringBuilder.append(str);

        Consumer<String>
                consumer1 = stringBuilder::append;

    }

}

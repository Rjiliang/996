package com.cherry.lambda.cart;


import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.function.BinaryOperator;

public class Test {

    @org.junit.Test
    public void testLambda() {
        BinaryOperator<Long> functionAdd = (x,y)-> {
            System.out.println("test");
            return x+y;
        };

        Long result = functionAdd.apply(1L,2L);
    }

    @org.junit.Test
    public void testLambda2() {
        BinaryOperator<Long> functionAdd = (Long x,Long y)-> x+y;

        Long result = functionAdd.apply(1L,2L);
    }


}

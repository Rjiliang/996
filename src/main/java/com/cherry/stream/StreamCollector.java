package com.cherry.stream;

import com.alibaba.fastjson.JSON;
import com.cherry.lambda.cart.CartService;
import com.cherry.lambda.cart.Sku;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 常见预定义收集器的使用
 */
public class StreamCollector {

    /**
     * 集合收集器
     */
    @Test
    public void toList() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        List<Sku> skuList = cartSkuList.stream()
                .filter(sku -> sku.getSkuPrice() > 10)
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(skuList,true));
    }

    /**
     * 分组
     */
    @Test
    public void group() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        Map<Enum, List<Sku>> collect = cartSkuList
                .stream()
                .collect(Collectors.groupingBy(sku -> sku.getSkuCategory()));

        System.out.println(JSON.toJSONString(collect,true));
    }

    /**
     * 分区
     */
    @Test
    public void partition() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        Map<Boolean, List<Sku>> collect = cartSkuList
                .stream()
                .collect(Collectors.partitioningBy(sku -> sku.getSkuPrice() > 20));
        System.out.println(JSON.toJSONString(collect,true));
    }


}
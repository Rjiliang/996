package com.cherry.lambda.stream;

import com.alibaba.fastjson.JSON;
import com.cherry.lambda.cart.CartService;
import com.cherry.lambda.cart.Sku;
import com.cherry.lambda.cart.SkuCategoryEnum;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/***
 * 对比：原始集合操作与Stream集合操作
 */
public class StreamTest {

    /***
     *  1 查看购物车的商品
     *  2 图书类去除
     *  3 其余商品买两件最贵的
     *  4 只需要两件商品的名称和总价
     */
    @Test
    public void oldCartHandle() {
        //传统的for循环...
    }


    /**
     * 以流的方式实现
     */
    @Test
    public void streamCartHandle(){

        AtomicReference<Double> money = new AtomicReference<>(Double.valueOf(0.0));

        List<String> collect = CartService.getCartSkuList()
                .stream()
                /**
                 * 查看购物车中所有商品
                 */
                .peek(sku -> System.out.println(JSON.toJSONString(sku, true)))
                /**
                 * 过滤图书类型的商品
                 */
                .filter(sku -> !SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                /**
                 * 价格排序（默认从小到大，reversed进行反转）
                 */
                .sorted(Comparator.comparing(Sku::getSkuPrice).reversed())
                /**
                 * 获取top2
                 */
                .limit(2)
                /**
                 * 计算总价
                 */
                .peek(sku -> money.set(money.get() + sku.getSkuPrice()))
                /**
                 * 收集top2的商品名称
                 */
                .map(sku -> sku.getSkuName())
                .collect(Collectors.toList());

        System.out.println(collect);
        System.out.println("总价："+money.get());

    }

}

package com.cherry.lambda.cart;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class Version3Test {

    @Test
    public void testFilterSkus() {
        List<Sku> cartSkuList =
                CartService.getCartSkuList();
        List<Sku> skus = CartService.filterSkus(cartSkuList, new SkuPredicate() {
            @Override
            public boolean test(Sku sku) {
                return sku.getSkuCategory().equals(SkuCategoryEnum.BOOKS);
            }
        });

        System.out.println(JSON.toJSONString(skus,true));

    }

    /**
     * 引入lambda表达式
     */
    @Test
    public void testFilterSkus2() {
        List<Sku> cartSkuList =
                CartService.getCartSkuList();
        List<Sku> skus = CartService.filterSkus(cartSkuList, (Sku sku) -> sku.getSkuCategory().equals(SkuCategoryEnum.BOOKS));

        System.out.println(JSON.toJSONString(skus,true));

    }

}

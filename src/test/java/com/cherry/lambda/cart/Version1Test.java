package com.cherry.lambda.cart;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class Version1Test {

    @Test
    public void testFilterElectronicsSkus() {
        List<Sku> cartSkuList =
                CartService.getCartSkuList();
        List<Sku> skus = CartService.filterElectronicsSkus(cartSkuList);

        System.out.println(JSON.toJSONString(skus,true));

    }

}

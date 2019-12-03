package com.cherry.lambda.cart;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class Version2Test {

    @Test
    public void testFilterElectronicsSkus() {
        List<Sku> cartSkuList =
                CartService.getCartSkuList();
        List<Sku> skus = CartService.filterSkusCategory(cartSkuList,SkuCategoryEnum.BOOKS);

        System.out.println(JSON.toJSONString(skus,true));

    }

}

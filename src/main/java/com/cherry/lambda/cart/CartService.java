package com.cherry.lambda.cart;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车服务类
 */
public class CartService {


    /**
     * 所有商品信息
     */
    private static List<Sku> cartSkuList = new ArrayList<Sku>(){
        {
            add(new Sku(1,"java编程思想",20.0,1,20.0,SkuCategoryEnum.BOOKS));
            add(new Sku(1,"鼠标",20.0,1,20.0,SkuCategoryEnum.ELECTRONICS));
            add(new Sku(1,"皮大衣",20.0,1,20.0,SkuCategoryEnum.CLOTHING));
        }
    };

    /**
     * 获取所有商品信息
     * @return
     */
    public static List<Sku> getCartSkuList() {
        return cartSkuList;
    }

    /**
     * Version 1.0.0
     * 找出购物车中所有电子产品
     * @param cartSkuList
     * @return
     */
    public static List<Sku> filterElectronicsSkus(List<Sku> cartSkuList) {

        ArrayList<Sku> result = new ArrayList<Sku>();
        for (Sku sku : cartSkuList) {
            //商品类型 = 电子类
            if (SkuCategoryEnum.ELECTRONICS.equals(sku.getSkuCategory())) {
                result.add(sku);
            }
        }
        return  result;
    }

    /**
     * Version 2.0.0
     * 根据传入得商品类型找出，具体得商品
     * @param cartSkuList
     * @param skuCategoryEnum
     * @return
     */
    public static List<Sku> filterSkusCategory(List<Sku> cartSkuList,SkuCategoryEnum skuCategoryEnum) {

        ArrayList<Sku> result = new ArrayList<Sku>();
        for (Sku sku : cartSkuList) {
            if (skuCategoryEnum.equals(sku.getSkuCategory())) {
                result.add(sku);
            }
        }
        return  result;
    }


    /**
     * Version 3.0.0
     * 将判断条件抽离
     * @param cartSkuList
     * @param skuPredicate
     * @return
     */
    public static List<Sku> filterSkus(List<Sku> cartSkuList,SkuPredicate skuPredicate) {

        ArrayList<Sku> result = new ArrayList<Sku>();
        for (Sku sku : cartSkuList) {
            //商品类型 = 电子类
            if (skuPredicate.test(sku)) {
                result.add(sku);
            }
        }
        return  result;
    }

}

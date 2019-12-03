package com.cherry.lambda.cart;

/**
 * Sku 选择谓词标准
 */
public interface SkuPredicate {

    boolean test(Sku sku);

}


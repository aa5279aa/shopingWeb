package com.lxl.servlet.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangleiliu on 2017/5/25.
 * ¥Ú’€–≈œ¢
 */
public class DiscountModel {

    public static final int IMAGE_MODEL_TYPE_SHOP = 1;
    public static final int IMAGE_MODEL_TYPE_TRADING = 2;

    public int mShopId;
    public String mDiscountStartTime;
    public String mDiscountEndTime;
    public String mDiscountDesc;
    public List<Double> mDiscountList = new ArrayList<>();
}

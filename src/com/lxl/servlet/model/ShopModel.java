package com.lxl.servlet.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangleiliu on 2017/5/3.
 */
public class ShopModel {
    public static int SHOP_MODEL_PAYMENT_ZFB = 1;//支付宝
    public static int SHOP_MODEL_PAYMENT_WX = 2;//微信
    public static int SHOP_MODEL_PAYMENT_YL = 3;//银联

    public int mTradingId;
    public int mShopId;
    public String mShopName;
    public int mSaleType;//销售类型
    public String mLocation;//位置
    public int mPaymentmethod;//
    public String mDesc;
    public List<ImageModel> mImageList = new ArrayList<>();

    public DiscountModel discountModel = new DiscountModel();//打折信息描述
    public List<LabelModel> labelModelList = new ArrayList<>();//L
}

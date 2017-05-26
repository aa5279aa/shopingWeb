package com.lxl.servlet.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangleiliu on 2017/5/3.
 */
public class ShopModel {
    public static int SHOP_MODEL_PAYMENT_ZFB = 1;//֧����
    public static int SHOP_MODEL_PAYMENT_WX = 2;//΢��
    public static int SHOP_MODEL_PAYMENT_YL = 3;//����

    public int mTradingId;
    public int mShopId;
    public String mShopName;
    public int mSaleType;//��������
    public String mLocation;//λ��
    public int mPaymentmethod;//
    public String mDesc;
    public List<ImageModel> mImageList = new ArrayList<>();

    public DiscountModel discountModel = new DiscountModel();//������Ϣ����
    public List<LabelModel> labelModelList = new ArrayList<>();//L
}

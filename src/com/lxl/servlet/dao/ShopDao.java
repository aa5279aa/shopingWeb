package com.lxl.servlet.dao;

import com.lxl.servlet.model.*;

/**
 * Created by xiangleiliu on 2017/5/25.
 */
public interface ShopDao {

    //�̵�
    public boolean insertShopModel(ShopModel shopModel);

    public boolean updateShopModel(ShopModel shopModel);//��shopModel�е�mShopIdΪ׼����

    public boolean deleteShopModel(int shopId);

    public ShopModel selectShopModel(int shopId);


    //����
    public boolean insertTradingModel(TradingModel tradingModel);

    public boolean updateTradingModel(ShopModel tradingModel);//tradingModel�е�tradingidΪ׼

    public boolean deleteTradingModel(int tradingId);

    public TradingModel selectTradingModel(int tradingId);

    //ͼƬ
    public boolean insertImageModel(ImageModel imageModel);

    public boolean updateImageModel(ImageModel imageModel);//��ImageModel�е�mImgIdΪ׼����

    public boolean deleteImageModel(int imgId);

    public ImageModel selectImageModel(int imgId);

    //������Ϣ
    public boolean insertDiscountModel(DiscountModel discountModel);

    public boolean updateDiscountModel(DiscountModel discountModel);//��ImageModel�е�mImgIdΪ׼����

    public boolean deleteDiscountModel(int imgId);

    public DiscountModel selectDiscountModel(int imgId);

    //��ǩ��Ϣ
    public boolean insertLabelModel(LabelModel labelModel);

    public boolean updateLabelModel(LabelModel labelModel);//��ImageModel�е�mImgIdΪ׼����

    public boolean deleteLabelModel(int labelId);

    public LabelModel selectLabelModel(int labelId);


}

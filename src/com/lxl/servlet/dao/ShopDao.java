package com.lxl.servlet.dao;

import com.lxl.servlet.model.*;

import java.util.List;

/**
 * Created by xiangleiliu on 2017/5/25.
 */
public interface ShopDao {

    //商店
    public boolean insertShopModel(ShopModel shopModel);

    public boolean updateShopModel(ShopModel shopModel);//以shopModel中的mShopId为准更新

    public boolean deleteShopModel(int shopId);

    public ShopModel selectShopModel(int shopId);


    //商区
    public boolean insertTradingModel(TradingModel tradingModel);

    public boolean updateTradingModel(ShopModel tradingModel);//tradingModel中的tradingid为准

    public boolean deleteTradingModel(int tradingId);

    public TradingModel selectTradingModel(int tradingId);

    public List<TradingModel> selectAllTradingModel();

    //图片
    public boolean insertImageModel(ImageModel imageModel);

    public boolean updateImageModel(ImageModel imageModel);//以ImageModel中的mImgId为准更新

    public boolean deleteImageModel(int imgId);

    public ImageModel selectImageModel(int imgId);

    //打折信息
    public boolean insertDiscountModel(DiscountModel discountModel);

    public boolean updateDiscountModel(DiscountModel discountModel);//以ImageModel中的mImgId为准更新

    public boolean deleteDiscountModel(int imgId);

    public DiscountModel selectDiscountModel(int imgId);

    //标签信息
    public boolean insertLabelModel(LabelModel labelModel);

    public boolean updateLabelModel(LabelModel labelModel);//以ImageModel中的mImgId为准更新

    public boolean deleteLabelModel(int labelId);

    public LabelModel selectLabelModel(int labelId);


}

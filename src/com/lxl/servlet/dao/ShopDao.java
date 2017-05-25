package com.lxl.servlet.dao;

import com.lxl.servlet.model.ShopModel;
import com.lxl.servlet.model.TradingModel;

/**
 * Created by xiangleiliu on 2017/5/25.
 */
public interface ShopDao {

    //商店
    public void insertShopModel(ShopModel shopModel);

    public void updateShopModel(ShopModel shopModel);//以shopModel中的mShopId为准更新

    public void deleteShopModel(int shopId);

    public ShopModel selectShopModel(int shopId);


    //商区
    public void insertTradingModel(TradingModel tradingModel);

    public void updateTradingModel(ShopModel tradingModel);//以shopModel中的mShopId为准更新

    public void deleteTradingModel(int tradingId);

    public ShopModel selectTradingModel(int tradingId);

    //打折信息


    //图片
    public void insertTradingModel(TradingModel tradingModel);

    public void updateTradingModel(ShopModel tradingModel);//以shopModel中的mShopId为准更新

    public void deleteTradingModel(int tradingId);

    public ShopModel selectTradingModel(int tradingId);



}

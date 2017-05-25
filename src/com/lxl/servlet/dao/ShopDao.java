package com.lxl.servlet.dao;

import com.lxl.servlet.model.ShopModel;
import com.lxl.servlet.model.TradingModel;

/**
 * Created by xiangleiliu on 2017/5/25.
 */
public interface ShopDao {

    //�̵�
    public void insertShopModel(ShopModel shopModel);

    public void updateShopModel(ShopModel shopModel);//��shopModel�е�mShopIdΪ׼����

    public void deleteShopModel(int shopId);

    public ShopModel selectShopModel(int shopId);


    //����
    public void insertTradingModel(TradingModel tradingModel);

    public void updateTradingModel(ShopModel tradingModel);//��shopModel�е�mShopIdΪ׼����

    public void deleteTradingModel(int tradingId);

    public ShopModel selectTradingModel(int tradingId);

    //������Ϣ


    //ͼƬ
    public void insertTradingModel(TradingModel tradingModel);

    public void updateTradingModel(ShopModel tradingModel);//��shopModel�е�mShopIdΪ׼����

    public void deleteTradingModel(int tradingId);

    public ShopModel selectTradingModel(int tradingId);



}

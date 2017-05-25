package com.lxl.servlet.dao;

import com.lxl.servlet.model.ShopModel;
import com.lxl.servlet.model.TradingModel;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by xiangleiliu on 2017/5/4.
 */
public class ShopDaoImpl {
    Connection conn;

    public ShopDaoImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tradingdb";
            String user = "root";
            String password = "lxl301lxl";
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean insertOneShopModel(ShopModel shopModel) {
        String sql = "insert into shop (tradingid,shopname,saletype,address,paymentmethod,describes,imageurl) values (?,?,?,?,?,?,?)";
        PreparedStatement preStmt = null;
        try {
            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, shopModel.mTradingId);
            preStmt.setString(2, shopModel.mShopName);
            preStmt.setInt(3, shopModel.mSaleType);
            preStmt.setString(4, shopModel.mAddress);
            preStmt.setInt(5, shopModel.mPaymentmethod);
            preStmt.setString(6, shopModel.mDescibes);
            preStmt.setString(7, shopModel.mImagePath + File.separator + shopModel.mImageName);
            int i = preStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (preStmt != null) {
                try {
                    preStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    public boolean insertOneTradingModel(TradingModel tradingModel) {
        String sql = "insert into trading (tradingid,cityid,tradingname,address,latitude,longitude,describes,imageurl) values (?,?,?,?,?,?,?,?)";
        PreparedStatement preStmt = null;
        try {
            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, tradingModel.mShopId);
            preStmt.setInt(2, tradingModel.mCityTd);
            preStmt.setString(3, tradingModel.mShopName);
            preStmt.setString(4, tradingModel.mAddress);
            preStmt.setDouble(5, tradingModel.mLat);
            preStmt.setDouble(6, tradingModel.mLong);
            preStmt.setString(7, tradingModel.mDesc);
            preStmt.setString(8, tradingModel.mImg);
            int i = preStmt.executeUpdate();
            System.out.println("i:" + i);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (preStmt != null) {
                try {
                    preStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}

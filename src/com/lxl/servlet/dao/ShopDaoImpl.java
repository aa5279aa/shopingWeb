package com.lxl.servlet.dao;

import com.lxl.servlet.model.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by xiangleiliu on 2017/5/4.
 */
public class ShopDaoImpl implements ShopDao {
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

    @Override
    public boolean insertShopModel(ShopModel shopModel) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE shop SET ");
        sql.append(" tradingid =" + shopModel.mTradingId);
        sql.append(" shopname =" + shopModel.mShopName);
        sql.append(" saletype =" + shopModel.mSaleType);
        sql.append(" location =" + shopModel.mLocation);
        sql.append(" paymentmethod =" + shopModel.mPaymentmethod);
        sql.append(" describes =" + shopModel.mDesc);

        sql.append(" where shopid = " + shopModel.mShopId);
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            return stmt.executeUpdate(sql.toString()) > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean updateShopModel(ShopModel shopModel) {

        return false;
    }

    @Override
    public boolean deleteShopModel(int shopId) {
        String sql = "delete from shop where shopid =" + shopId;
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            return stmt.executeUpdate(sql) > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public ShopModel selectShopModel(int shopId) {
        String sql = "select * from trading where shopid = " + shopId;
        PreparedStatement preStmt = null;
        try {
            preStmt = conn.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery();
            while (rs.next()) {
                int shopid = rs.getInt("shopid");
                int tradingid = rs.getInt("tradingid");
                String shopname = rs.getString("shopname");
                int saletype = rs.getInt("saletype");
                String location = rs.getString("location");
                int paymentmethod = rs.getInt("paymentmethod");
                String describes = rs.getString("describes");
                Timestamp createtime = rs.getTimestamp("createtime");
                ShopModel shopModel = new ShopModel();

                shopModel.mShopId = shopId;
                shopModel.mTradingId = tradingid;
                shopModel.mShopName = shopname;
                shopModel.mSaleType = saletype;
                shopModel.mLocation = location;
                shopModel.mPaymentmethod = paymentmethod;
                shopModel.mDesc = describes;
                shopModel.mCreateTime = createtime.getTime();
                return shopModel;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preStmt != null) {
                try {
                    preStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public boolean insertTradingModel(TradingModel tradingModel) {
        String sql = "insert into trading (cityid,tradingname,address,latitude,longitude,describes) values (?,?,?,?,?,?)";
        PreparedStatement preStmt = null;
        try {
            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, tradingModel.mCityTd);
            preStmt.setString(2, tradingModel.mTradingName);
            preStmt.setString(3, tradingModel.mAddress);
            preStmt.setDouble(4, tradingModel.mLat);
            preStmt.setDouble(5, tradingModel.mLong);
            preStmt.setString(6, tradingModel.mDesc);
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

    @Override
    public boolean updateTradingModel(ShopModel tradingModel) {

        return false;
    }

    @Override
    public boolean deleteTradingModel(int tradingId) {

        return false;
    }

    @Override
    public TradingModel selectTradingModel(int tradingId) {
        return null;
    }

    @Override
    public List<TradingModel> selectAllTradingModel() {
        List<TradingModel> list = new ArrayList<>();
        String sql = "select * from trading;";
        PreparedStatement preStmt = null;
        try {
            preStmt = conn.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery();
            while (rs.next()) {
                int tradingid = rs.getInt("tradingid");
                int cityid = rs.getInt("cityid");
                String tradingname = rs.getString("tradingname");
                String address = rs.getString("address");
                double latidude = rs.getDouble("latitude");
                double longitude = rs.getDouble("longitude");
                String describes = rs.getString("describes");
                Timestamp createtime = rs.getTimestamp("createtime");
                TradingModel tradingModel = new TradingModel();
                tradingModel.mTradingId = tradingid;
                tradingModel.mTradingId = cityid;
                tradingModel.mTradingName = tradingname;
                tradingModel.mAddress = address;
                tradingModel.mLat = latidude;
                tradingModel.mLong = longitude;
                tradingModel.mDesc = describes;
                tradingModel.mCreateTime = createtime;
                list.add(tradingModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preStmt != null) {
                try {
                    preStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public boolean insertImageModel(ImageModel imageModel) {

        return false;
    }

    @Override
    public boolean updateImageModel(ImageModel imageModel) {

        return false;
    }

    @Override
    public boolean deleteImageModel(int imgId) {

        return false;
    }

    @Override
    public ImageModel selectImageModel(int imgId) {
        return null;
    }

    @Override
    public boolean insertDiscountModel(DiscountModel discountModel) {

        return false;
    }

    @Override
    public boolean updateDiscountModel(DiscountModel discountModel) {

        return false;
    }

    @Override
    public boolean deleteDiscountModel(int imgId) {

        return false;
    }

    @Override
    public DiscountModel selectDiscountModel(int imgId) {
        return null;
    }

    @Override
    public boolean insertLabelModel(LabelModel labelModel) {
        return false;
    }

    @Override
    public boolean updateLabelModel(LabelModel labelModel) {

        return false;
    }

    @Override
    public boolean deleteLabelModel(int labelId) {

        return false;
    }

    @Override
    public LabelModel selectLabelModel(int labelId) {
        return null;
    }
}

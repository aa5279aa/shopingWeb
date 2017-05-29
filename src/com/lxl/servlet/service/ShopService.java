package com.lxl.servlet.service;

import com.lxl.servlet.config.Config;
import com.lxl.servlet.dao.ShopDaoImpl;
import com.lxl.servlet.model.ImageModel;
import com.lxl.servlet.model.LabelModel;
import com.lxl.servlet.model.ShopModel;
import com.lxl.servlet.model.TradingModel;
import com.lxl.servlet.util.IOHelper;
import com.lxl.servlet.util.NumberUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangleiliu on 2017/5/3.
 */
public class ShopService {
    ShopDaoImpl dao;
    Logger logger;

    public ShopService() {
        dao = new ShopDaoImpl();
        logger = Logger.getLogger();
    }

    public void saveOneShopModel(ShopModel shopModel) throws Exception {
        //插入酒店基础信息
        boolean flag = dao.insertShopModel(shopModel);

        //插入酒店图片信息
        List<ImageModel> mImageList = shopModel.mImageList;
        for (ImageModel imageModel : mImageList) {
            dao.insertImageModel(imageModel);
        }
        //插入打折
        dao.insertDiscountModel(shopModel.discountModel);

        //插入标签信息
        List<LabelModel> labelModelList = shopModel.labelModelList;
        for (LabelModel labelModel : labelModelList) {
            dao.insertLabelModel(labelModel);
        }
        System.out.print("flag:" + flag);
    }

    public void saveOneTradingModel(TradingModel tradingModel) throws Exception {
        boolean flag = dao.insertTradingModel(tradingModel);
        System.out.print("insert isSuccess:" + flag);
    }

    public List<TradingModel> getAllTradingModel() {

        List<TradingModel> tradingModels = dao.selectAllTradingModel();

        return tradingModels;
    }

}

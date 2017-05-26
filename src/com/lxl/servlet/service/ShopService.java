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

    //开个线程去存储
    public String saveImage(HttpServletRequest request, String imgPath, String input_shopname) throws Exception {
        ServletInputStream requestInputStream = request.getInputStream();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItems = null;
        try {
            fileItems = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        if (fileItems.size() == 0) {
            return "";
        }
        //转存图片
        File file = new File(imgPath);
        String name = file.getName();
        File saveImgFile = new File(Config.Save_Path + File.separator + input_shopname + "_" + name);
        fileItems.get(0).write(saveImgFile);
        return saveImgFile.getAbsolutePath();
    }

    public void saveOneTradingModel(TradingModel tradingModel) throws Exception {
        boolean flag = dao.insertTradingModel(tradingModel);
        System.out.print("insert isSuccess:" + flag);
    }


}

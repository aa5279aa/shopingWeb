package com.lxl.servlet.service;

import com.lxl.servlet.config.Config;
import com.lxl.servlet.dao.ShopDaoImpl;
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

    public void saveOneShopModel(HttpServletRequest request) throws Exception {
        String input_tradingid = request.getParameter("input_tradingid");
        String input_shopname = request.getParameter("input_shopname");
        String input_saleType = request.getParameter("input_saletype");
        String input_address = request.getParameter("input_address");
        String paymentmethod = request.getParameter("input_paymentmethod");
        String input_desc = request.getParameter("input_descibes");
        String input_img = request.getParameter("input_img");

        System.out.println(input_tradingid);
        System.out.println(input_saleType);
        System.out.println(input_shopname);
        System.out.println(input_address);
        System.out.println(paymentmethod);
        System.out.println(input_desc);
        System.out.println(input_img);

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItems = null;
        try {
            fileItems = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        ShopModel shopModel = readAllParams(fileItems);
        boolean flag = dao.insertOneShopModel(shopModel);
        System.out.print("flag:" + flag);
    }

    private ShopModel readAllParams(List<FileItem> fileItems) throws Exception {
        ShopModel shopModel = new ShopModel();
        //根据fileItem解析参数
        DiskFileItem imgItem = null;
        for (FileItem fileItem : fileItems) {
            if (!(fileItem instanceof DiskFileItem)) {
                continue;
            }
            DiskFileItem diskfileItem = (DiskFileItem) fileItem;
            String fieldName = fileItem.getFieldName();
            if (fieldName.equals("input_tradingid")) {
                shopModel.mTradingId = NumberUtil.string2Int(IOHelper.readStrByCode(fileItem.getInputStream(), "utf-8"));
            } else if (fieldName.equals("input_shopname")) {
                shopModel.mShopName = IOHelper.readStrByCode(fileItem.getInputStream(), "utf-8");
            } else if (fieldName.equals("input_img")) {
                File file = new File(diskfileItem.getName());
                String name = file.getName();
                imgItem = diskfileItem;
                shopModel.mImageName = name;
            }
        }
        //存储图片
        if (imgItem != null) {
            File file = new File(Config.Save_Path + File.separator + shopModel.mImageName);
            if (file.exists()) {
                file.delete();
            }
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            imgItem.write(file);
        }
        return shopModel;
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

    public void saveOneTradingModel(HttpServletRequest request) throws Exception {
        String input_cityid = request.getParameter("input_cityid");
        String input_shopid = request.getParameter("input_shopid");
        String input_shopname = request.getParameter("input_shopname");
        String input_address = request.getParameter("input_address");
        String input_coordinate = request.getParameter("input_coordinate");
        String input_desc = request.getParameter("input_desc");
        String input_img = request.getParameter("input_img");

        TradingModel tradingModel = new TradingModel();
        tradingModel.mCityTd = Integer.parseInt(input_cityid);
        tradingModel.mShopId = Integer.parseInt(input_shopid);
        tradingModel.mShopName = input_shopname;
        tradingModel.mAddress = input_address;
        double[] longAndLat = NumberUtil.getLongAndLat(input_coordinate);
        tradingModel.mLong = longAndLat[0];
        tradingModel.mLat = longAndLat[1];
        tradingModel.mDesc = input_desc;
        tradingModel.mImg = input_img;
        boolean flag = dao.insertOneTradingModel(tradingModel);
        System.out.print("insert isSuccess:" + flag);
    }


}

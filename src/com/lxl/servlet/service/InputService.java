package com.lxl.servlet.service;

import com.lxl.servlet.config.Config;
import com.lxl.servlet.model.ImageModel;
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
import java.io.IOException;
import java.util.List;

/**
 * Created by xiangleiliu on 2017/5/25.
 * 输入转化层
 */
public class InputService {

    public InputService() {

    }

    //请求转化为TradingModel
    public ShopModel readShopModel(HttpServletRequest request) {
        ShopModel shopModel = new ShopModel();
        String input_tradingid = request.getParameter("show_tradingid");
        String input_shopname = request.getParameter("input_shopname");
        String input_saleType = request.getParameter("input_saletype");
        String input_location = request.getParameter("input_location");
        String paymentmethod = request.getParameter("input_paymentmethod");
        String input_desc = request.getParameter("input_descibes");
        shopModel.mTradingId = NumberUtil.string2Int(input_tradingid);
        shopModel.mShopName = input_shopname;
        shopModel.mSaleType = NumberUtil.string2Int(input_saleType);
        shopModel.mLocation = input_location;
        shopModel.mPaymentmethod = NumberUtil.string2Int(paymentmethod);
        shopModel.mDesc = input_desc;
        return shopModel;
    }

    //请求转化为ShopModel
    public TradingModel readTradingModel(HttpServletRequest request) {
        String input_cityid = request.getParameter("input_cityid");
        String input_tradingname = request.getParameter("input_tradingname");
        String input_address = request.getParameter("input_address");
        String input_coordinate = request.getParameter("input_coordinate");
        String input_desc = request.getParameter("input_desc");
        String input_trafiic = request.getParameter("input_trafiic");

        TradingModel tradingModel = new TradingModel();
        tradingModel.mCityTd = NumberUtil.string2Int(input_cityid);
        tradingModel.mTradingName = input_tradingname;
        tradingModel.mAddress = input_address;
        double[] longAndLat = NumberUtil.getLongAndLat(input_coordinate);
        tradingModel.mLat = longAndLat[0];
        tradingModel.mLong = longAndLat[1];
        tradingModel.mDesc = input_desc;
        tradingModel.mTraffic = input_trafiic;
        return tradingModel;
    }


    //请求转化为ImgeModel
    public ImageModel readImageModel(List<FileItem> list) throws FileUploadException, IOException {
        ImageModel imageModel = new ImageModel();
        String fileName = "temp.png";
        for (FileItem fileItem : list) {
            String fieldName = fileItem.getFieldName();
            if ("input_type".equals(fieldName)) {
                String type = IOHelper.readStrByCode(fileItem.getInputStream(), "utf-8").trim();
                imageModel.mType = type.startsWith("商区") ? ImageModel.IMAGE_MODEL_TYPE_TRADING : ImageModel.IMAGE_MODEL_TYPE_SHOP;
            } else if ("input_nameId".equals(fieldName)) {
                imageModel.mRelationName = IOHelper.readStrByCode(fileItem.getInputStream(), "utf-8").trim();
            } else if ("input_img".equals(fieldName) && fileItem instanceof DiskFileItem) {
                fileName = fileItem.getName();
                imageModel.fileItem = fileItem;
            }
        }
        //重新整理imgName
        imageModel.mImgName = "SW_" + imageModel.mType + "_" + imageModel.mRelationName + "_" + fileName;
        imageModel.mImgPath = Config.Save_Path;
        imageModel.mImgUrl = imageModel.mImgPath + File.separator + imageModel.mImgName;
        return imageModel;
    }


    //请求转化为Discountodel
    public ImageModel readDiscountodel(HttpServletRequest request) throws FileUploadException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItems = upload.parseRequest(request);
        ImageModel imageModel = new ImageModel();
        if (fileItems.size() > 0) {
            FileItem fileItem = fileItems.get(0);
            String name = fileItem.getName();
            imageModel.mImgName = fileItem.getFieldName();
            //名称

            //存储地址

            //mType

            //mRelationId 关联值

            //mImgId自动生成

        }
        return imageModel;
    }

    public List<FileItem> readAllParams(HttpServletRequest request) throws Exception {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItems = upload.parseRequest(request);
        return fileItems;
    }

    //开个线程去存储
    public String saveImage(ImageModel imageModel) throws Exception {
        //转存图片
        File saveImgFile = new File(imageModel.mImgUrl);
        if (!saveImgFile.getParentFile().exists()) {
            saveImgFile.getParentFile().mkdirs();
        }
        if (imageModel.fileItem != null) {
            imageModel.fileItem.write(saveImgFile);
        } else {
            File error = new File(saveImgFile.getAbsolutePath() + ".fail");
            saveImgFile.renameTo(error);
        }
        return saveImgFile.getAbsolutePath();
    }
}

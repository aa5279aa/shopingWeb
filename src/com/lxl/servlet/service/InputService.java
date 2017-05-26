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

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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
        String input_tradingid = request.getParameter("input_tradingid");
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
    public ImageModel readImageModel(HttpServletRequest request) throws FileUploadException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItems = upload.parseRequest(request);
        ImageModel imageModel = new ImageModel();
        return imageModel;
    }


    //请求转化为Discountodel
    public ImageModel readDiscountodel(HttpServletRequest request) throws FileUploadException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItems = upload.parseRequest(request);
        ImageModel imageModel = new ImageModel();
        return imageModel;
    }

//    public ShopModel readAllParams(List<FileItem> fileItems) throws Exception {
//        ShopModel shopModel = new ShopModel();
//        //根据fileItem解析参数
//        DiskFileItem imgItem = null;
//        for (FileItem fileItem : fileItems) {
//            if (!(fileItem instanceof DiskFileItem)) {
//                continue;
//            }
//            DiskFileItem diskfileItem = (DiskFileItem) fileItem;
//            String fieldName = fileItem.getFieldName();
//            if (fieldName.equals("input_tradingid")) {
//                shopModel.mTradingId = NumberUtil.string2Int(IOHelper.readStrByCode(fileItem.getInputStream(), "utf-8"));
//            } else if (fieldName.equals("input_shopname")) {
//                shopModel.mShopName = IOHelper.readStrByCode(fileItem.getInputStream(), "utf-8");
//            }
//        }
//        return shopModel;
//    }
}

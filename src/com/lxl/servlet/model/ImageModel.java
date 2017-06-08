package com.lxl.servlet.model;

import org.apache.commons.fileupload.FileItem;

/**
 * Created by xiangleiliu on 2017/5/25.
 */
public class ImageModel {
    public static final int IMAGE_MODEL_TYPE_SHOP = 1;
    public static final int IMAGE_MODEL_TYPE_TRADING = 2;


    public int mImgId;
    public String mImgName;
    public String mImgPath;
    public String mImgUrl;
    public int mRelationId;//
    public String mRelationName;//
    public int mType;//类型

    public FileItem fileItem;

}

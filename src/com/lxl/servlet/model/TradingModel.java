package com.lxl.servlet.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangleiliu on 2017/5/4.
 */
public class TradingModel {

    public int mCityTd;//城市id
    public int mTradingId;//
    public String mTradingName;
    public String mTraffic;//交通信息
    public String mAddress;//地址
    public double mLat;//经度
    public double mLong;//纬度
    public String mDesc;//描述
    public List<String> mLabelList = new ArrayList<>();//描述
    public List<ImageModel> mImgList = new ArrayList<>();//图片
}

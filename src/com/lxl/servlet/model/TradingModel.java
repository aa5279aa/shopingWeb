package com.lxl.servlet.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangleiliu on 2017/5/4.
 */
public class TradingModel {

    public int mCityTd;//����id
    public int mTradingId;//
    public String mTradingName;
    public String mTraffic;//��ͨ��Ϣ
    public String mAddress;//��ַ
    public double mLat;//����
    public double mLong;//γ��
    public String mDesc;//����
    public List<String> mLabelList = new ArrayList<>();//����
    public List<ImageModel> mImgList = new ArrayList<>();//ͼƬ
}

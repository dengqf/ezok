/*
 * ImgUploadInfo.java 
 * Version: 2.01   2014-2-19
 * 
 * Copyright (c) 2013 YouGouInformation Technology Co.,Ltd 
 * All Rights Reserved.
 * 本软件为优购科技开发研制，未经本公司正式书面同意，其他任何个人、团体不得
 * 使用、复制、修改或发布本软件
 */
package com.ezok.model;

/**
 * Class description goes here
 *
 * @Author: 邓奇峰
 * Date: 14-2-19
 */
public class ImgUploadInfo {
    String iconUrl;
    String yxEwmUrl;
    String wxEwmUrl;
    String result;
    String reason;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getYxEwmUrl() {
        return yxEwmUrl;
    }

    public void setYxEwmUrl(String yxEwmUrl) {
        this.yxEwmUrl = yxEwmUrl;
    }

    public String getWxEwmUrl() {
        return wxEwmUrl;
    }

    public void setWxEwmUrl(String wxEwmUrl) {
        this.wxEwmUrl = wxEwmUrl;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

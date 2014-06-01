/*
 * ImgUploadUtil.java 
 * Version: 2.01   2014-2-19
 * 
 * Copyright (c) 2013 YouGouInformation Technology Co.,Ltd 
 * All Rights Reserved.
 * 本软件为优购科技开发研制，未经本公司正式书面同意，其他任何个人、团体不得
 * 使用、复制、修改或发布本软件
 */
package com.ezok.utils;

import com.app.tools.PropertiesTool;
import com.app.tools.file.FileUpload;
import com.app.tools.image.ImageHelp;
import com.ezok.model.NavInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Class description goes here
 *
 * @Author: 邓奇峰
 * Date: 14-2-19
 */
public class ImgUploadUtil {

    public static String isSpecImg(HttpServletRequest request, String param) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile(param);
        if (file.getSize() < 0) {
            return ("上传文件不能为空");
        }
        if (!ImageHelp.isValidImageName(file.getOriginalFilename())) {
            return "上传的文件不是图片格式";
        }
        if (file.getSize() > EzokConstant.IMG_MAX_SIZE) {
            return "文件大小不能超过100K";
        }


        return EzokConstant.SUCCESS;
    }

    /**
     * 如果图片存在，则判断是否符合规格
     *
     * @param request
     * @param param
     * @return
     */
    public static String isSpecImgIfExist(HttpServletRequest request, String param) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile(param);

        if (ImageHelp.isValidImageName(file.getOriginalFilename())) {
            if (file.getSize() > EzokConstant.IMG_MAX_SIZE) {
                return "文件大小不能超过100K";
            }
        }


        return EzokConstant.SUCCESS;
    }

    public static NavInfo uploadImg(HttpServletRequest request, String no, NavInfo info) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile iconFile = multipartRequest.getFile("icon");
        MultipartFile wxEwmFile = multipartRequest.getFile("wxEwm");
        MultipartFile yxEwmFile = multipartRequest.getFile("yxEwm");

        //服务器图片存放路径
        StringBuilder folder = new StringBuilder(PropertiesTool.getValueByKey("image.file.url"));
        //文件分割符
        String separator = System.getProperty("file.separator");
        //每个NAV一个独立的文件夹 ，以编号为单位
        folder.append(separator).append(no).append(separator);
        //名字固定
        String iconFileName = no + "_" + EzokConstant.ICON_FILENAME;//头像
        String wxEwmFileName = no + "_" + EzokConstant.WX_EWM_FILENAME;//微信二维码
        String yxEwmFileName = no + "_" + EzokConstant.YX_EWM_FILENAME;//微信二维码

        String iconUrl = folder + iconFileName;
        String wxEwmUrl = folder + wxEwmFileName;
        String yxEwmUrl = folder + yxEwmFileName;
        File iconDest = new File(iconUrl);

        //建立文件夹
        if (!iconDest.getParentFile().exists()) {
            iconDest.getParentFile().mkdir();
        }

        if (ImageHelp.isValidImageName(wxEwmFile.getOriginalFilename())) {
            //logger.error("易信二维码上传文件是图片");
            FileUpload.uploadImage(wxEwmFile, wxEwmUrl, EzokConstant.ICON_WIDTH, EzokConstant.ICON_HEIGHT);
            info.setWxEwmUrl("/" + no + "/" + wxEwmFileName);
        }

        if (ImageHelp.isValidImageName(iconFile.getOriginalFilename())) {
            //logger.error("易信二维码上传文件是图片");
            FileUpload.uploadImage(iconFile, iconUrl, EzokConstant.ICON_WIDTH, EzokConstant.ICON_HEIGHT);
            info.setIconUrl("/" + no + "/" + iconFileName);
        }

        if (ImageHelp.isValidImageName(yxEwmFile.getOriginalFilename())) {
            //logger.error("易信二维码上传文件是图片");
            FileUpload.uploadImage(yxEwmFile, yxEwmUrl, EzokConstant.ICON_WIDTH, EzokConstant.ICON_HEIGHT);
            info.setYxEwmUrl("/" + no + "/" + yxEwmFileName);
        }
        return info;

    }

    public static void uploadImg(HttpServletRequest request, String no, String param) {

    }
}

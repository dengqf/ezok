package com.ezok.services;

import com.app.tools.image.MagicImageScale;
import com.ezok.model.CategoryInfo;
import com.ezok.model.vo.CategoryListVO;
import com.ezok.utils.CateUtil;
import magick.MagickException;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-3-1
 * Time: 下午1:18
 * To change this template use File | Settings | File Templates.
 * <div class="lis">
 * <h3><a href="${context}/nav_list.html?no=" >新闻资讯</a></h3>
 * <div class="sub_con">
 * <a href="?" target="_blank">综合技术</a>
 * <a href="${context}/nav_list.html?no=123">科技类</a>
 * <a href="?" target="_blank">财经</a>
 * <a href="?" target="_blank">娱乐类</a>
 * <a href="?" target="_blank">论坛</a>
 * <a href="?" target="_blank">生活艺术</a>
 * <a href="?" target="_blank">婚姻</a>
 * <p/>
 * </div>
 * </div>
 */
public class CategoryServiceTest extends BaseTest {
    @Resource
    CateUtil cateUtil;

    public void testCreateCateMenu() {
        List<CategoryListVO> list = cateUtil.getCategoryListVos();
        StringBuilder html = new StringBuilder("<a href=\"#\" class=\"title\">全部分类<b class=\"caret\"></b></a>\n");
        html.append("<div class=\"lis_con\">\n");
        for (CategoryListVO vo : list) {
            CategoryInfo parent = vo.getCategoryInfo();
            html.append("<div class=\"lis\">\n");
            html.append("<h3><a href=\"${context}/nav_list.html?no="+parent.getNo()+"\" >"+parent.getName()+"</a></h3>\n");
            html.append("<div class=\"sub_con\">\n");
            List<CategoryInfo> child = vo.getChildList();
            for(CategoryInfo info:child){
                html.append("<a href=\"${context}/nav_list.html?no="+info.getNo()+"\">"+info.getName()+"</a>\n");
            }
            html.append("</div>\n");
            html.append("</div>\n");

        }
        html.append("</div>\n");
        System.out.print(html.toString());
    }

    public void testAA(){

        try {
            MagicImageScale.resizeFix(new File("J:\\下载\\1.png"),new File("J:\\下载\\1.png"),200,50);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (MagickException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}

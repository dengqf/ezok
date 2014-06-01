package com.ezok.utils;

import com.ezok.model.CategoryInfo;
import com.ezok.model.vo.CategoryListVO;
import com.ezok.service.ICategoryInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-3-1
 * Time: 上午10:12
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CateUtil {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ICategoryInfoService categoryInfoService;
    public static List<CategoryInfo> cateList = new ArrayList<CategoryInfo>();
    public static Map<String, CategoryInfo> cateMap = new HashMap<String, CategoryInfo>();

    /**
     * 得到所有的有效分类
     *
     * @return
     */
    public List<CategoryInfo> getAllCategory() {
        if (CollectionUtils.isEmpty(cateList)) {
            init();
        }
        return cateList;
    }

    public CategoryInfo getCategoryInfoByNo(String no) {
        if (CollectionUtils.isEmpty(cateMap)) {
            init();
        }
        if (cateMap.containsKey(no)) {
            return cateMap.get(no);
        } else {
            //查询数据库中是否有
            CategoryInfo info = categoryInfoService.getCategoryInfoByNo(no);
            if (null != info) {
                cateMap.put(no, info);
            }
            return info;

        }

    }

    private void init() {
        logger.info("分类列表初始化");
        cateList = categoryInfoService.getAllCategoryInfoList();
        for (CategoryInfo info : cateList) {
            cateMap.put(info.getNo(), info);
        }
    }

    public void clear() {
        cateList.clear();
        cateMap.clear();
    }

    public List<CategoryListVO> getCategoryListVos() {
        List<CategoryListVO> voList = new ArrayList<CategoryListVO>();
        //取得所有有效分类信息

        List<CategoryInfo> list = getAllCategory();
        //TODO 暂时不按STRUCT排序，
//        Collections.sort(list, new ComparatorCate());
        //取得所有一级分类
        for (CategoryInfo cate : list) {
            if (cate.getParentNo().equals(EzokConstant.DEFAULT_CATEGORY_PARENTNO)) {
                CategoryListVO vo = new CategoryListVO();
                vo.setCategoryInfo(cate);
                voList.add(vo);
            }
        }
        //循环VO，开始加载子分类 ,虽然多循环，但是可以避免查询数据库，以后可以用REDIS
        for (CategoryListVO vo : voList) {
            String no = vo.getCategoryInfo().getNo();
            for (CategoryInfo cate : list) {
                if (cate.getParentNo().equals(no)) {
                    vo.getChildList().add(cate);
                }
            }
        }
        return voList;
    }
}

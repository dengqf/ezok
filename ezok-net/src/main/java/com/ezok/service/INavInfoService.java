package com.ezok.service;

import com.ezok.model.NavInfo;
import com.ezok.model.PageInfo;
import com.ezok.model.vo.NavInfoVO;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-2-15
 * Time: 下午10:23
 * To change this template use File | Settings | File Templates.
 */
public interface INavInfoService {

    Integer addNavInfo(NavInfo navInfo);

    Integer saveNavInfo(NavInfo navInfo);

    /**
     * 根据分类编号以及分页信息取出数据
     *
     * @param categoryNo 分类编号
     * @param pageInfo   分页信息
     * @return NavInfoVO
     */
    NavInfoVO getNavInfoVo(String categoryNo, PageInfo pageInfo);

    /**
     * 根据第一级分类查询NAV
     *
     * @param categoryNo
     * @param pageInfo
     * @return
     */
    NavInfoVO getNavInfoVoByParentCate(String categoryNo, PageInfo pageInfo);

    NavInfoVO getNavInfoVo(NavInfo navInfo, PageInfo pageInfo);

    NavInfo getNavInfoByNo(String no);

    NavInfo getNavInfoById(String id);

    /**
     * 根据微信原始账号得到信息
     *
     * @param account 微信原始账号
     * @return NavInfo
     */
    NavInfo getNavInfoByWeixinAccount(String account);

    /**
     * 更新状态信息
     *
     * @param nos  NAV编号
     * @param info NavInfo
     * @return 修改条数
     */
    Integer updateStatusForNav(String[] nos, NavInfo info);

    /**
     * 猜你喜欢栏目推荐，暂时由数据库查询实现
     *
     * @param navInfo
     * @return
     */
    List<NavInfo> getLikeNavInfoList(NavInfo navInfo);

    List<NavInfo> getSiteMapList(Date startDate,Date endDate);


}

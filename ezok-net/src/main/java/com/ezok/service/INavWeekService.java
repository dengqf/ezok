package com.ezok.service;

import com.ezok.model.NavWeek;
import com.ezok.model.NavWeekExtend;
import com.ezok.model.PageInfo;
import com.ezok.model.vo.NavWeekExtendVO;
import com.ezok.model.vo.NavWeekVO;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-3-26
 * Time: 下午1:54
 * To change this template use File | Settings | File Templates.
 */
public interface INavWeekService {
    Integer addNavWeek(NavWeek navWeek);

    Integer updateNavWeek(NavWeek navWeek);

    /**
     * 根据导航NO得到导航每周推荐信息
     * @param navNo
     * @return
     */
    NavWeek getNavWeekByNavNo(String navNo);

    NavWeekExtendVO getNavWeekExtendVo(PageInfo pageInfo);
}

package com.ezok.service.impl;

import com.ezok.mapper.NavWeekMapper;
import com.ezok.model.NavWeek;
import com.ezok.model.NavWeekExample;
import com.ezok.model.NavWeekExtend;
import com.ezok.model.PageInfo;
import com.ezok.model.vo.NavWeekExtendVO;
import com.ezok.model.vo.NavWeekVO;
import com.ezok.service.INavWeekService;
import com.ezok.utils.CommonUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-3-26
 * Time: 下午1:54
 * To change this template use File | Settings | File Templates.
 */
@Service
public class NavWeekServiceImpl implements INavWeekService {
    @Autowired
    NavWeekMapper navWeekMapper;

    @Override
    public Integer addNavWeek(NavWeek navWeek) {
        return navWeekMapper.insertSelective(navWeek);
    }

    @Override
    public Integer updateNavWeek(NavWeek navWeek) {
        return navWeekMapper.updateByPrimaryKeySelective(navWeek);
    }

    @Override
    public NavWeek getNavWeekByNavNo(String navNo) {
        NavWeekExample example = new NavWeekExample();
        example.or().andNavNoEqualTo(navNo);
        List<NavWeek> list = navWeekMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public NavWeekExtendVO getNavWeekExtendVo(PageInfo pageInfo) {
        Integer count = pageInfo.getCount();
        if (count == null) {
            count = navWeekMapper.countNavWeekExtendList();
        }
        RowBounds rowBounds = CommonUtil.getRowBoundsByPageInfo(pageInfo);
        List<NavWeekExtend> list = navWeekMapper.getNavWeekExtendList(rowBounds);
        return new NavWeekExtendVO(count, list);
    }
}

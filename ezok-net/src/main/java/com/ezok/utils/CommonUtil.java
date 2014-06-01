package com.ezok.utils;

import com.ezok.model.AdminInfo;
import com.ezok.model.CategoryInfo;
import com.ezok.model.PageInfo;
import com.ezok.model.UserInfo;
import org.apache.ibatis.session.RowBounds;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-2-15
 * Time: 下午10:49
 * To change this template use File | Settings | File Templates.
 */
public class CommonUtil {
    public final static String CATEGORY_LIST = "CATEGORY_LIST";

    public static RowBounds getRowBoundsByPageInfo(PageInfo pageInfo) {
        Integer pageNo = pageInfo.getPageNo();
        Integer pageSize = pageInfo.getPageSize();
        return new RowBounds((pageNo - 1) * pageSize, pageSize);
    }

    public static List<CategoryInfo> getAllCategoryInfo() {
        return null;
    }

    public static AdminInfo getAdmin(HttpServletRequest request) {
        return (AdminInfo) request.getSession().getAttribute(EzokConstant.SESSION_LOGIN_ADMIN);

    }

    public static UserInfo getUser(HttpServletRequest request) {
        return (UserInfo) request.getSession().getAttribute(EzokConstant.SESSION_LOGIN_USER);

    }
}

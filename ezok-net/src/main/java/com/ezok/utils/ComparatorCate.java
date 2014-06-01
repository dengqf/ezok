package com.ezok.utils;

import com.ezok.model.CategoryInfo;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-2-24
 * Time: 下午8:58
 * To change this template use File | Settings | File Templates.
 */
public class ComparatorCate implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        CategoryInfo ca1 = (CategoryInfo) o1;
        CategoryInfo ca2 = (CategoryInfo) o2;
        return ca1.getStruct().compareTo(ca2.getStruct());

    }
}

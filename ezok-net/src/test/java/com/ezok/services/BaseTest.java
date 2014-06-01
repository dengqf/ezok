package com.ezok.services;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-3-1
 * Time: 下午1:18
 * To change this template use File | Settings | File Templates.
 */
public class BaseTest extends AbstractDependencyInjectionSpringContextTests {


    protected String[] getConfigLocations() {
        setAutowireMode(AUTOWIRE_BY_NAME);
        return new String[]{
                "classpath:/applicationContext-test.xml"
        };
    }
}

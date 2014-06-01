package com.ezok.model.vo;

/**
 * Created with IntelliJ IDEA.
 * User: dengqf
 * Date: 14-2-15
 * Time: 下午10:27
 * To change this template use File | Settings | File Templates.
 */
public abstract class VoObject {
    private int count;

    public VoObject(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

package com.wc.yff.bean;

import android.graphics.drawable.Drawable;

/**
 * AppInfo
 * Created by Administrator on 2016/7/14.
 */
public class AppInfo {
    private String name;
    private String packageName;
    private String packageVerson;
    private Drawable drawableIcon;


    public Drawable getDrawableIcon() {
        return drawableIcon;
    }

    public void setDrawableIcon(Drawable drawableIcon) {
        this.drawableIcon = drawableIcon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageVerson() {
        return packageVerson;
    }

    public void setPackageVerson(String packageVerson) {
        this.packageVerson = packageVerson;
    }
}

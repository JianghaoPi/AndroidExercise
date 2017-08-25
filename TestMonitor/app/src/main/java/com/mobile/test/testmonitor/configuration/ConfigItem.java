package com.mobile.test.testmonitor.configuration;

/**
 * Created by Administrator on 2017/8/17.
 */

public class ConfigItem {

    private String name;

    private String status;

    public ConfigItem(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

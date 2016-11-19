package com.example.yune.mybanban.mvp.model;

/**
 * Created by Yune on 2016/11/9.
 */

public class CommonParam {

    private String appVersion = "1.0.1";
    private String orgId;
    private Long longOrgId;
    private Long originatorId;
    private Integer page;
    private Integer pagesize;
    private Integer channel;
    private String appKey;
    private String sign;
    private String token;

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Long getOriginatorId() {
        return originatorId;
    }

    public void setOriginatorId(Long originatorId) {
        this.originatorId = originatorId;
    }

    @Override
    public String toString() {
        return "CommonParams [appVersion=" + appVersion + ", orgId=" + orgId
                + ", originatorId=" + originatorId + "]";
    }

    public Long getLongOrgId() {
        return longOrgId;
    }

    public void setLongOrgId(Long longOrgId) {
        this.longOrgId = longOrgId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}

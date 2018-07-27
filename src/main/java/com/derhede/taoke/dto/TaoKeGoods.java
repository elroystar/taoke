package com.derhede.taoke.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TaoKeGoods {
    private String id;

    private Date createTime;

    private Date updateTime;

    private Integer version;

    private Integer numIid;

    private String title;

    private String pictUrl;

    private String smallImages;

    private BigDecimal reservePrice;

    private BigDecimal zkFinalPrice;

    private Integer userType;

    private String provcity;

    private String itemUrl;

    private String clickUrl;

    private String nick;

    private Integer sellerId;

    private Integer volume;

    private String tkRate;

    private String zkFinalPriceWap;

    private Date eventStartTime;

    private Date eventEndTime;

    private Integer type;

    private Integer status;

    private Integer category;

    private String couponClickUrl;

    private String couponEndTime;

    private String couponInfo;

    private String couponStartTime;

    private Integer couponTotalCount;

    private Integer couponRemainCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getNumIid() {
        return numIid;
    }

    public void setNumIid(Integer numIid) {
        this.numIid = numIid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPictUrl() {
        return pictUrl;
    }

    public void setPictUrl(String pictUrl) {
        this.pictUrl = pictUrl == null ? null : pictUrl.trim();
    }

    public String getSmallImages() {
        return smallImages;
    }

    public void setSmallImages(String smallImages) {
        this.smallImages = smallImages == null ? null : smallImages.trim();
    }

    public BigDecimal getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(BigDecimal reservePrice) {
        this.reservePrice = reservePrice;
    }

    public BigDecimal getZkFinalPrice() {
        return zkFinalPrice;
    }

    public void setZkFinalPrice(BigDecimal zkFinalPrice) {
        this.zkFinalPrice = zkFinalPrice;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getProvcity() {
        return provcity;
    }

    public void setProvcity(String provcity) {
        this.provcity = provcity == null ? null : provcity.trim();
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl == null ? null : itemUrl.trim();
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl == null ? null : clickUrl.trim();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getTkRate() {
        return tkRate;
    }

    public void setTkRate(String tkRate) {
        this.tkRate = tkRate == null ? null : tkRate.trim();
    }

    public String getZkFinalPriceWap() {
        return zkFinalPriceWap;
    }

    public void setZkFinalPriceWap(String zkFinalPriceWap) {
        this.zkFinalPriceWap = zkFinalPriceWap == null ? null : zkFinalPriceWap.trim();
    }

    public Date getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(Date eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public Date getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(Date eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getCouponClickUrl() {
        return couponClickUrl;
    }

    public void setCouponClickUrl(String couponClickUrl) {
        this.couponClickUrl = couponClickUrl == null ? null : couponClickUrl.trim();
    }

    public String getCouponEndTime() {
        return couponEndTime;
    }

    public void setCouponEndTime(String couponEndTime) {
        this.couponEndTime = couponEndTime == null ? null : couponEndTime.trim();
    }

    public String getCouponInfo() {
        return couponInfo;
    }

    public void setCouponInfo(String couponInfo) {
        this.couponInfo = couponInfo == null ? null : couponInfo.trim();
    }

    public String getCouponStartTime() {
        return couponStartTime;
    }

    public void setCouponStartTime(String couponStartTime) {
        this.couponStartTime = couponStartTime == null ? null : couponStartTime.trim();
    }

    public Integer getCouponTotalCount() {
        return couponTotalCount;
    }

    public void setCouponTotalCount(Integer couponTotalCount) {
        this.couponTotalCount = couponTotalCount;
    }

    public Integer getCouponRemainCount() {
        return couponRemainCount;
    }

    public void setCouponRemainCount(Integer couponRemainCount) {
        this.couponRemainCount = couponRemainCount;
    }
}
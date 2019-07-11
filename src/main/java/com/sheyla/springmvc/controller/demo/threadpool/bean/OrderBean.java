package com.sheyla.springmvc.controller.demo.threadpool.bean;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/12 1:21
 * @Modified By：
 * @Description:
 */
public class OrderBean {
    private String orderNo;
    private String src;

    private Integer processCount;

    private Integer processStatus;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getProcessCount() {
        return processCount;
    }

    public void setProcessCount(Integer processCount) {
        this.processCount = processCount;
    }

    public Integer getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "orderNo='" + orderNo + '\'' +
                ", src='" + src + '\'' +
                ", processCount=" + processCount +
                ", processStatus=" + processStatus +
                '}';
    }
}

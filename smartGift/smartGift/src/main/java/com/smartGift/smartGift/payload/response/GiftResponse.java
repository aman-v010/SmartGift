package com.smartGift.smartGift.payload.response;

import java.util.Date;

public class GiftResponse {
    private String recipient;
    private String method;
    private int productId;
    private String status;
    private String address;
    private String variant;

    private int date;
    private int totalGifts;
    private int completedGifts;
    private int pendingGifts;
    private int failedGifts;

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getTotalGifts() {
        return totalGifts;
    }

    public void setTotalGifts(int totalGifts) {
        this.totalGifts = totalGifts;
    }

    public int getCompletedGifts() {
        return completedGifts;
    }

    public void setCompletedGifts(int completedGifts) {
        this.completedGifts = completedGifts;
    }

    public int getPendingGifts() {
        return pendingGifts;
    }

    public void setPendingGifts(int pendingGifts) {
        this.pendingGifts = pendingGifts;
    }

    public int getFailedGifts() {
        return failedGifts;
    }

    public void setFailedGifts(int failedGifts) {
        this.failedGifts = failedGifts;
    }
}

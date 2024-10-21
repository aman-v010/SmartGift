package com.smartGift.smartGift.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "analytics_collection")
public class Analytics {
    @Id
    @Column(name = "dates")
    private Date date;

    @Column(name = "total_gifts")
    private int totalGifts;

    @Column(name = "completed_gifts")
    private int completedGifts;

    @Column(name = "pending_gifts")
    private int pendingGifts;

    @Column(name = "failed_gifts")
    private int failedGifts;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

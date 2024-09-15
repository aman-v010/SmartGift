package com.smartGift.smartGift.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GiftRequest {
    String recipient;
    String method;
    String productId;
    String linkId;


//    private int totalGifts;
//    private int completedGifts;
//    private int pendingGifts;
//    private int failedGifts;


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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }
}

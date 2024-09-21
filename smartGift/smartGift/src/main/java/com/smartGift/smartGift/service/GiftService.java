package com.smartGift.smartGift.service;

import com.smartGift.smartGift.entity.Gift;
import com.smartGift.smartGift.payload.request.GiftDetails;
import com.smartGift.smartGift.payload.request.GiftRequest;
import com.smartGift.smartGift.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


import java.util.Date;

@Service
public class GiftService {
    @Autowired
    GiftRepository giftRepository;
//    public void addGifts(GiftRequest giftRequest) {
//        Date currentDate = new Date();
//        Gift gift = new Gift();
//        gift.setRecipient(giftRequest.getRecipient());
//        gift.setMethod(giftRequest.getMethod());
//        gift.setProductId(giftRequest.getProductId());
//        gift.setCreatedAt(currentDate);
//        gift.setUpdatedAt(currentDate);
//        giftRepository.save(gift);
//    }

    static {
        Twilio.init("AC9eefa2c5a15d89e1df1cda04c4bae244", "35e9138acae767b136e0e97042b17ca1");
    }

    public String createGiftLink(GiftRequest request) {
        if (!("sms".equalsIgnoreCase(request.getMethod()))) {
            return "Method must be SMS only.";
        }
        Gift gift = new Gift();
        gift.setRecipient(request.getRecipient());
        gift.setMethod(request.getMethod());
        gift.setProductId(request.getProductId());
        gift.setStatus("pending");
        gift.setCreatedAt(new Date());
        gift.setUpdatedAt(new Date());

        try {
            sendSmsNotification(request.getRecipient(), request.getLinkId());
        }
        catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        giftRepository.save(gift);

        return "Link generated and sent. Link ID: " + gift.getProductId();
    }

    private void sendSmsNotification(String recipient, String linkId) {
        try {
            Message message = Message.creator(
                    new PhoneNumber(recipient),
                    new PhoneNumber("+12402527052"),
                    "You've received a gift!" + linkId).create();
        }
        catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void updateGiftDetails(String productId, GiftDetails details) {
        Gift gift = giftRepository.findById(productId).orElseThrow(() -> new RuntimeException("Gift not found"));
        gift.setAddress(details.getAddress());
        gift.setVariant(details.getVariant());
        gift.setStatus("completed");
        gift.setUpdatedAt(new Date());
        giftRepository.save(gift);
    }
}
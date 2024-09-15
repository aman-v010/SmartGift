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
        Twilio.init("AC9eefa2c5a15d89e1df1cda04c4bae244", "e16f5d20786b01a7b09679513e0bfabb");
    }

    public String createGiftLink(GiftRequest request) {
        Gift gift = new Gift();
        gift.setRecipient(request.getRecipient());
        gift.setMethod(request.getMethod());
        gift.setProductId(request.getProductId());
        gift.setStatus("pending");
        gift.setCreatedAt(new Date());
        gift.setUpdatedAt(new Date());
        giftRepository.save(gift);

        if ("sms".equalsIgnoreCase(request.getMethod())) {
            sendSmsNotification(request.getRecipient(), request.getLinkId());
        }
        return gift.getProductId();
    }

    private void sendSmsNotification(String recipient, String linkId) {
        Message message = Message.creator(
                new PhoneNumber(recipient),
                new PhoneNumber("+12402527052"),
                "You've received a gift!" + linkId).create();
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
package com.smartGift.smartGift.controller;

import com.smartGift.smartGift.payload.request.GiftDetails;
import com.smartGift.smartGift.payload.request.GiftRequest;
import com.smartGift.smartGift.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/v1/gifts")
public class GiftController {

    @Autowired
    private GiftService giftService;

    @PostMapping("/generate-link")
    public ResponseEntity<String> generateLink(@RequestBody GiftRequest request) {
        try{
            String response = giftService.createGiftLink(request);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred: " + e.getMessage());
        }
    }

    @PostMapping("/submit-details/{productId}")
    public ResponseEntity<String> submitDetails(@PathVariable String productId, @RequestBody GiftDetails details) {
        giftService.updateGiftDetails(productId, details);
        return ResponseEntity.ok("Details submitted.");
    }
}
package com.ipaye.stripepayment.controller;

import com.ipaye.stripepayment.dto.ProductRequest;
import com.ipaye.stripepayment.dto.StripeResponse;
import com.ipaye.stripepayment.service.StripeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/v1")
public class ProductCheckOutController {

    private StripeService stripeService;

    public ProductCheckOutController(StripeService stripeService) {
        this.stripeService=stripeService;
    }

    @PostMapping("/checkout")
    public ResponseEntity<StripeResponse> checkOutProducts(@RequestBody ProductRequest productRequest){

        StripeResponse stripeResponse=stripeService.checkOutProducts(productRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(stripeResponse);

    }




}

package com.example.SBMSPayment3.Controller;

import com.example.SBMSPayment3.paymentDto.NetBankingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {
    Logger logger= LoggerFactory.getLogger(PaymentController.class);
    @GetMapping("/options")
    public List<String>getAllPaymentOptions(){
       logger.info("request for payment options");
        return List.of("UPI","Net Banking","Credit Card","debit Card");
    }
    @GetMapping("/netbanking")
    public String netBanking(@RequestBody NetBankingInfo netBankingInfo) {
        logger.info("request for net Banking options");
    return  "paymnet Success";
    }

}

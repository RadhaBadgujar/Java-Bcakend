package com.example.SBMSPayment3.paymentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NetBankingInfo {
    private  String userId;
    private String password;
}

package com.example.SBMSOrder2.Controller;

import com.example.SBMSOrder2.OrderServiceDto.OrderInfo;
import com.example.SBMSOrder2.OrderServiceEntity.ProductDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class OrderController {
    @PostMapping("/create")
    public String  createOrder(@RequestBody OrderInfo orderInfo){
        System.out.println(" order Creation Request dor User: " + orderInfo.getEmailId());
        // 8 digit number
        return "Order Created order Reference: " + UUID.randomUUID();
    }
    @GetMapping("/info/{orderId}")
    public  OrderInfo createorder(@PathVariable int orderId){
        System.out.println("order info for Order id"+orderId);
        //order id check presented or not presented
    return  new OrderInfo("rb27@gmail.com",List.of(new ProductDetails(1,"Iphone", 100000),
            new ProductDetails(2,"Dell",55000),
            new ProductDetails(3,"hp",90000)),155000);
    }
}

package com.example.SBMSOrder2.OrderServiceDto;


import com.example.SBMSOrder2.OrderServiceEntity.ProductDetails;
import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderInfo {
    @Id
    private String emailId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_email_id") // foreign key in ProductDetails table
    private List<ProductDetails> productInfo;

    private double totalAmount;
}


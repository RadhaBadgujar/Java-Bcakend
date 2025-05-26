package com.example.SBMSOrder2.OrderServiceEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="amazon_order_info")
public class ProductDetails {

    @Id
    private Integer productId; // ✅ This is now the primary key

    private String productName;
    private double price;
}

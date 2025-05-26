package com.example.SBMSP1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "amazon_users_info")
public class UserInfo {
    @Id
    private String emailId;
    private String password;
    private String fullname;
}

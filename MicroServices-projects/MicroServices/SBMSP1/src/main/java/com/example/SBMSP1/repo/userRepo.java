package com.example.SBMSP1.repo;

import com.example.SBMSP1.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<UserInfo, String> {
    UserInfo findByEmailId(String emailId); // Must return entity, not String
}

package com.example.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo,Integer>{
	Optional<UserInfo> findByName(String username);

}

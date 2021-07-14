package com.example.challegerdisney.Repository;

import com.example.challegerdisney.Entity.Username;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Username, Integer> {

    boolean existsByNameOrEmail(String name, String email);

    Username findUserByEmailAndToken(String email, String token);

    Username findUsernameByEmailAndTokenTemporal(String email, String tokenTemporal);


}

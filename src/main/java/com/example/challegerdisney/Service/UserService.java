package com.example.challegerdisney.Service;

import com.example.challegerdisney.Entity.Username;
import com.example.challegerdisney.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String save(Username username) {
        if(userRepository.existsByNameOrEmail(username.getName(), username.getEmail()))
            return "Usuario existente";

        int num = (int) (Math.random()*100)+1;
        username.setToken(username.getName()+num);
        username.setApiCallsLimit(1000);
        username.setApiCallsAvailable(1000);
        userRepository.save(username);
        return username.getToken();
    }

    // el token temporal es el Id de la seccion

    public String login(String email, String token) {
        Username username = userRepository.findUserByEmailAndToken(email, token);
        if(username != null){
            username.setTokenTemporal(String.valueOf((Math.round(Math.random()*100000)+1)));
            userRepository.save(username);
            return username.getTokenTemporal();
        }
        return "Error de acceso";
    }

    public boolean validateTemporalTokenAndCountApiCall(String email, String tokenTemporal){
        Username username = userRepository.findUsernameByEmailAndTokenTemporal(email, tokenTemporal);
        if(username!=null && username.getApiCallsAvailable()>0){
            username.consumirApiCall();
            userRepository.save(username);
            return true;
        }
        return false;
    }
}

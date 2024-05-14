package com.project.qvick.global.common.util.user;

import com.project.qvick.domain.user.domain.repository.UserRepository;
import com.project.qvick.domain.user.exception.UserExistException;
import com.project.qvick.domain.user.exception.UserNotFoundException;
import com.project.qvick.domain.user.mapper.UserMapper;
import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.domain.user.service.UserService;
import com.project.qvick.global.common.repository.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUtil {

    private final UserRepository userRepository;
    private final UserSecurity userSecurity;
    private final UserMapper userMapper;

    public void userExistCheck(String email){
        if (userRepository.findByEmail(email).isPresent()){
            throw UserExistException.EXCEPTION;
        }
    }

    public void userCheck(String email){
        if (userRepository.findByEmail(email).isEmpty()){
            throw UserNotFoundException.EXCEPTION;
        }
    }

    public void userCheckById(Long id){
        if (userRepository.findById(id).isEmpty()){
            throw UserNotFoundException.EXCEPTION;
        }
    }

    public User findUser(){
        return userRepository
                .findById(userSecurity.getUser().getId())
                .map(userMapper::toUser)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }

}
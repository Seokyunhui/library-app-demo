package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.UserResponse;
import com.group.libraryapp.dto.user.request.UserCreateReq;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void saveUser(UserCreateReq req){
        userRepository.saveUser(req.getName(), req.getAge());
    }

    public List<UserResponse> getUsers(){
        return userRepository.getUsers();
    }

    public void updateUser( UserUpdateRequest req){
        if(userRepository.isUserNotExist(req.getId())){
            throw new IllegalArgumentException();
        }
        userRepository.updateUserName(req.getName(), req.getId());
    }

    public void deleteUser(String name){
        if(userRepository.isUserNotExist(name)){
            throw new IllegalArgumentException();
        }
        userRepository.deleteUser(name);
    }
}

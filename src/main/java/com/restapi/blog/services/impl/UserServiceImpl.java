package com.restapi.blog.services.impl;

import com.restapi.blog.entites.User;
import com.restapi.blog.exceptions.ResourceNotFoundException;
import com.restapi.blog.payloads.UserDto;
import com.restapi.blog.repositories.UserRepo;
import com.restapi.blog.services.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));


        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());

        User upadtedUser = this.userRepo.save(user);
        return this.userToDto(upadtedUser);

    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();

        return users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

        this.userRepo.delete(user);
    }

    private User dtoToUser(UserDto userDto){
       User user = this.modelMapper.map(userDto, User.class);
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setAbout(userDto.getAbout());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
        return  user;

    }
    private UserDto userToDto(User user){
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setAbout(user.getAbout());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
        return  userDto;

    }
}

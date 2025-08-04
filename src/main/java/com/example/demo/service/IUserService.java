package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.UserModel;

public interface IUserService {

	UserDTO consult(String login);
	
	UserModel consultEntity(String login);

}

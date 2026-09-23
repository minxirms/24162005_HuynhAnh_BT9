package vn.minxi.service;

import vn.minxi.dto.UserDTO;

public interface UserService {
	UserDTO findById(Long id);
}
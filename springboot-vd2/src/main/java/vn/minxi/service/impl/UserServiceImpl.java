package vn.minxi.service.impl;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import vn.minxi.dto.UserDTO;
import vn.minxi.entity.User;
import vn.minxi.mapper.UserMapper;
import vn.minxi.repository.UserRepository;
import vn.minxi.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final UserMapper userMapper;

	@Override
	public UserDTO findById(Long id) {
		User user = userRepository.findById(id).orElseThrow();
		return userMapper.toDTO(user);
	}
}

package com.airtel.kyc.kenya.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.airtel.kyc.kenya.entity.Role;
import com.airtel.kyc.kenya.entity.User;
import com.airtel.kyc.kenya.model.LoginModel;
import com.airtel.kyc.kenya.model.RoleModel;
import com.airtel.kyc.kenya.model.UserModel;
import com.airtel.kyc.kenya.repository.RolesRepository;
import com.airtel.kyc.kenya.repository.UserRepository;
import com.airtel.kyc.kenya.util.beans.ModelEntityMapper;

/**
 * @author rvashishth
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RolesRepository rolesRepository;
	
	@Autowired
	private ModelEntityMapper modelEntityMapper;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserModel createUser(UserModel userModel) {
		userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
		userModel.setCreatedOn(System.currentTimeMillis());
		userModel.setUpdatedOn(System.currentTimeMillis());
		User user = modelEntityMapper.userModeltoEntity(userModel);
		User persistedUser = userRepository.save(user);
		return modelEntityMapper.userEntityToUserModel(persistedUser);
	}
	
	public UserModel findUserByMsisdn(String msisdn) {
		Optional<User> optionalUsers = userRepository.findByMsisdn(msisdn);
		User persistedUser = optionalUsers.orElseThrow(() -> new EntityNotFoundException("User not found for msisdn: " + msisdn));
		return modelEntityMapper.userEntityToUserModel(persistedUser);
	}
	
	public List<RoleModel> fetchAllRoles() {
		List<Role> roles = rolesRepository.findAll();
		return modelEntityMapper.roleEntityToModel(roles);
	}

	public boolean validateUserCredentials(LoginModel user){
		Optional<User> optionalUsers = userRepository.findByMsisdn(user.getUsername());
		User persistedUser = optionalUsers.orElseThrow(() -> new UsernameNotFoundException("User not found for username: " +user.getUsername()));
		user.setRole(persistedUser.getRole().getRolename());
		return passwordEncoder.matches(user.getPassword(), persistedUser.getPassword());
	}
}

package com.airtel.kyc.kenya.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airtel.kyc.kenya.entity.User;

/**
 * @author rvashishth
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public abstract Optional<User> findByMsisdn(String msisdn);
	
	//public abstract Optional<User> findByUsername(String username);

}

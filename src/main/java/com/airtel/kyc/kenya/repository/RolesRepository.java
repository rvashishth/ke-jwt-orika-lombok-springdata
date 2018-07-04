package com.airtel.kyc.kenya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airtel.kyc.kenya.entity.Role;

/**
 * @author rvashishth
 *
 */
@Repository
public interface RolesRepository extends JpaRepository<Role, Long>{

}

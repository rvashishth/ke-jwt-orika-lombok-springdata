package com.us.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.us.app.entity.Role;

/**
 * @author rvashishth
 *
 */
@Repository
public interface RolesRepository extends JpaRepository<Role, Long>{

}

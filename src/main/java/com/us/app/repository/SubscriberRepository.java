package com.us.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.us.app.entity.Subscriber;

/**
 * @author rvashishth
 *
 */
@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Long>{

}

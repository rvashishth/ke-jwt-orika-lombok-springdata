package com.us.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.app.entity.Subscriber;
import com.us.app.model.SubscriberModel;
import com.us.app.repository.SubscriberRepository;
import com.us.app.util.beans.ModelEntityMapper;

/**
 * @author rvashishth
 *
 */
@Service
public class SubscriberService {

	private static final Logger LOG = LoggerFactory.getLogger(SubscriberService.class);
	
	@Autowired
	private SubscriberRepository subscriberRepository;
	
	@Autowired
	private ModelEntityMapper entityMapper;
	
	public SubscriberModel createUser(SubscriberModel subscriberModel) {
		LOG.info("createUser() start - Add new subscriber in db: "+subscriberModel);
		// prepare userimage entity to persist
		Subscriber subscriber = entityMapper.subscriberModelToEntity(subscriberModel);
		subscriber = subscriberRepository.save(subscriber);
		LOG.info("createUser() end - Add new subscriber saved in db: "+subscriberModel);
		return null;
	}

}

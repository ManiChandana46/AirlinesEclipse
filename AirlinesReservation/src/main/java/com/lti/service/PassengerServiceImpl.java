package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.PassengerDetail;
import com.lti.repository.GenericRepository;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private GenericRepository genericRepository;

	@Override
	@Transactional
	public void addPassengers(List<PassengerDetail> passengers) {

		for (PassengerDetail passenger : passengers)
			genericRepository.save(passenger);

	}

}

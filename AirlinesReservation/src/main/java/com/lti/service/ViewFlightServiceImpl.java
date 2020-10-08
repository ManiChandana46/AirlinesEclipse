package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.ViewFlightDto;
import com.lti.entity.FlightRoute;
import com.lti.entity.FlightSchedule;
import com.lti.exception.AirlinesServiceException;
import com.lti.repository.ViewFlightRepository;

@Service
public class ViewFlightServiceImpl implements ViewFlightService {

	@Autowired
	private ViewFlightRepository viewFlightRepository;

	@Override
	public List<ViewFlightDto> getView() {
		try {
			List<ViewFlightDto> viewList = new ArrayList<>();
			List<Integer> flightNumberList = viewFlightRepository.listOfFlightNumber();

			for (Integer i : flightNumberList) {

				ViewFlightDto viewFlightDto = new ViewFlightDto();
				viewFlightDto.setFlightNumber(i);

				int flightId = viewFlightRepository.flightIdByFlightNumber(i);

				viewFlightDto.setInitialDate(viewFlightRepository.initialDateByFlightNumber(i));
				viewFlightDto.setFinalDate(viewFlightRepository.finalDateByFlightNumber(i));

				int routeId = viewFlightRepository.routeIdByFlightId(flightId);

				FlightRoute flightRoute = viewFlightRepository.getCityByRouteId(routeId);
				viewFlightDto.setSource(flightRoute.getCityFrom());
				viewFlightDto.setDestination(flightRoute.getCityTo());

				FlightSchedule flightSchedule = viewFlightRepository.getScheduleByFlightId(flightId);
				viewFlightDto.setDepartureTime(flightSchedule.getDepartureTime());
				viewFlightDto.setArrivalTime(flightSchedule.getArrivalTime());
				viewFlightDto.setBasePrice(flightSchedule.getPrice());

				viewList.add(viewFlightDto);
			}

			return viewList;
		} catch (Exception e) {
			throw new AirlinesServiceException("Cannot display view", e);
		}
	}
}

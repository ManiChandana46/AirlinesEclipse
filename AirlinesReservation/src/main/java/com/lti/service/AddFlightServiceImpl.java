package com.lti.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.AddFlightDto;
import com.lti.dto.AddFlightStatus;
import com.lti.entity.FlightDetail;
import com.lti.entity.FlightRoute;
import com.lti.entity.FlightSchedule;
import com.lti.entity.SeatDetail;
import com.lti.exception.AirlinesServiceException;
import com.lti.repository.AddFlightRepository;
import com.lti.repository.GenericRepository;

@Service
@Transactional
public class AddFlightServiceImpl implements AddFlightService {

	@Autowired
	private AddFlightRepository addFlightRepository;
	@Autowired
	private GenericRepository genericRepository;
	@Autowired
	private AddFlightStatus addFlightStatus;

	@Override
	public FlightDetail addFlightDetails(AddFlightDto addFlightDto) {
		try {
			FlightDetail flightDetail = new FlightDetail();
			flightDetail.setFlightNumber(addFlightDto.getFlightNumber());
			flightDetail.setCabin(addFlightDto.getCabin());
			flightDetail.setInitialDate(addFlightDto.getInitialDate());
			flightDetail.setFinalDate(addFlightDto.getFinalDate());
			return genericRepository.save(flightDetail);

		}
		catch(Exception e) {
			throw new AirlinesServiceException("Flight details not added", e);
		}
	}

	@Override
	public FlightRoute getRouteId(AddFlightDto addFlightDto) {
		int routeId=addFlightRepository.findRouteId(addFlightDto.getCityFrom(), addFlightDto.getCityTo());
		return genericRepository.fetchById(FlightRoute.class,routeId);
	}

	@Override
	public AddFlightStatus addToSchedule(FlightDetail flightDetail, FlightRoute flightRoute, AddFlightDto addFlightDto) {

		int operationalDays=(int) ChronoUnit.DAYS.between(addFlightDto.getInitialDate(), addFlightDto.getFinalDate());
		LocalDate travelDate = addFlightDto.getInitialDate();

		try {
			for(int i=0;i<operationalDays;i++) {

				FlightSchedule flightSchedule = new FlightSchedule();
				flightSchedule.setArrivalTime(addFlightDto.getArrivalTime());
				flightSchedule.setDepartureTime(addFlightDto.getDepartureTime());
				flightSchedule.setSeatAvailable(addFlightDto.getCabin());
				flightSchedule.setFlightDetail(flightDetail);
				flightSchedule.setFlightRoute(flightRoute);
				flightSchedule.setDateOfTravel(travelDate);

				if(travelDate.getDayOfWeek().getValue()==6 || travelDate.getDayOfWeek().getValue()==7) {
					double updatePrice=addFlightDto.getPrice()+(0.1*addFlightDto.getPrice());
					flightSchedule.setPrice(updatePrice);
				}
				else
					flightSchedule.setPrice(addFlightDto.getPrice());

				flightSchedule=genericRepository.save(flightSchedule);
				for(int j=1;j<=10;j++) {
					for(char a='A';a<='F';a++) {
						SeatDetail seatDetail=new SeatDetail();
						seatDetail.setFlightSchedule(flightSchedule);
						seatDetail.setSeatName(j+""+a);
						seatDetail.setStatus(false);
						genericRepository.save(seatDetail);

					}
				}

				travelDate = travelDate.plusDays(1);
			}

			addFlightStatus.setStatus(true);
			addFlightStatus.setMessage("Flight Added");
		}
		catch(Exception e) {
			addFlightStatus.setStatus(false);
			addFlightStatus.setMessage("Could not add flight");
			throw new AirlinesServiceException("Could not add flight", e);
		}
		return addFlightStatus;
	}
}

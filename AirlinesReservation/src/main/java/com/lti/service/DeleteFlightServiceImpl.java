package com.lti.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.DeleteFlightStatusDto;
import com.lti.exception.AirlinesServiceException;
import com.lti.repository.DeleteFlightRepository;
import com.lti.repository.GenericRepository;

@Service
@Transactional
public class DeleteFlightServiceImpl implements DeleteFlightService {


	@Autowired
	private DeleteFlightRepository deleteFlightRepository;

	@Autowired
	private GenericRepository genericRepository;

	@Autowired
	private DeleteFlightStatusDto deleteFlightStatusDto;

	@Override
	@SuppressWarnings("null")
	public DeleteFlightStatusDto deleteFlight(int flightNumber, LocalDate travelDate) {
		try {
			int flightId = deleteFlightRepository.flightIdByFlightNumber(flightNumber);
			int scheduleId = deleteFlightRepository.scheduleIdByFlightIdAndTravelDate(flightId, travelDate);
			
			if(scheduleId != 0) {
				List<Integer> flightBookIdList = deleteFlightRepository.listOfBookIdByScheduleId(scheduleId);
				List<Integer> returnIdList = deleteFlightRepository.listOfReturnIdByScheduleId(scheduleId);
				//System.out.println("hello");
				List<Integer> customerIdList =  new ArrayList<>();
			
				if(!returnIdList.isEmpty()) {
					//System.out.println("Inside ReturnList");
					for(int returnId : returnIdList) {
						int bookId = deleteFlightRepository.bookIdByReturnId(returnId);
						customerIdList.add(deleteFlightRepository.customerIdByBookId(bookId));
						deleteFlightRepository.refereneceDeletionOfReturnIdFromBookTable(returnId);
						deleteFlightRepository.deleteReturnDetailByReturnId(returnId);
					}
				}
				
				if(flightBookIdList != null) {
				
					for(int bookId : flightBookIdList) {
						customerIdList.add(deleteFlightRepository.customerIdByBookId(bookId));
						
						int returnId=deleteFlightRepository.isReturnPresent(bookId);
						//System.out.println(returnId);
					
						if(returnId != 0) {
							deleteFlightRepository.refereneceDeletionOfReturnIdFromBookTable(returnId);
							deleteFlightRepository.deleteReturnDetailByReturnId(returnId);
							deleteFlightRepository.deletePassengerByBookId(bookId);
							deleteFlightRepository.deletePaymentByBookId(bookId);
							deleteFlightRepository.deleteBookingByBookId(bookId);
						}
						
						else {
							deleteFlightRepository.deletePassengerByBookId(bookId);
							deleteFlightRepository.deletePaymentByBookId(bookId);
							deleteFlightRepository.deleteBookingByBookId(bookId);
						}
					}
				}

				deleteFlightRepository.deleteFlightScheduleByFlightIdAndTravelDate(flightId, travelDate);
			}
			deleteFlightStatusDto.setStatus(true);
			deleteFlightStatusDto.setMessage("Flight Deleted!");
		}
		catch(Exception e) {
			throw new AirlinesServiceException("Delete Flight failed!", e);
		}

		return deleteFlightStatusDto;
	}
}

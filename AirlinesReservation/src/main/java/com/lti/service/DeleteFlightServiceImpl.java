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

@Service
@Transactional
public class DeleteFlightServiceImpl implements DeleteFlightService {


	@Autowired
	private DeleteFlightRepository deleteFlightRepository;

	@Autowired
	private DeleteFlightStatusDto deleteFlightStatusDto;

	@Override
	public DeleteFlightStatusDto deleteFlight(int flightNumber, LocalDate travelDate) {
		try {
			int flightId = deleteFlightRepository.flightIdByFlightNumber(flightNumber);
			int scheduleId = deleteFlightRepository.scheduleIdByFlightIdAndTravelDate(flightId, travelDate);

			if(scheduleId != 0) {
				List<Integer> flightBookIdList = deleteFlightRepository.listOfBookIdByScheduleId(scheduleId);
				List<Integer> returnIdList = deleteFlightRepository.listOfReturnIdByScheduleId(scheduleId);

				List<Integer> customerIdList =  new ArrayList<>();

				if(!returnIdList.isEmpty()) {

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

				deleteFlightRepository.deleteSeatDetailByScheduleId(scheduleId);
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

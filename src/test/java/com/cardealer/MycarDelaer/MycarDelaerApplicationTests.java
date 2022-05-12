package com.cardealer.MycarDelaer;

import com.cardealer.MycarDelaer.dao.ICarDAO;
import com.cardealer.MycarDelaer.dto.Car;
import com.cardealer.MycarDelaer.service.IcarService;
import com.cardealer.MycarDelaer.service.carServiceStub;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class MycarDelaerApplicationTests {

	private IcarService carService;
	private Car car = new Car();

	@MockBean
	private ICarDAO carDAO;

	@Test
	void contextLoads() {
	}

	@Test
	void fetchCarByID_returnsJeepSrtForID83() throws  Exception{
		givenCarDataAreAvailable();
		whenSearchCarwithID83();
		thenReturnJeepSRT8forID83();
	}



	private void thenReturnJeepSRT8forID83() {
	}

	private void whenCarAddedIsJeep(){
		Car jeep = new Car();
		jeep.setCarId("83");
		jeep.setDescription("SRT");
		Mockito.when(carDAO.fetch(83)).thenReturn(jeep);
	}

	private void whenSearchCarwithID83() {
		car = carService.fetchById(83);
	}

	private void givenCarDataAreAvailable () throws  Exception{
		Mockito.when(carDAO.save(car)).thenReturn(car);
		carService = new carServiceStub(carDAO);
	}

	@Test
	void saveCar_validateReturnCarwithModelAndYear() throws Exception{
		givenCarDataAreAvailable();
		whenUserCreateANewCarAndSaves();
		thenCreateNewCarRecordAndReturnIt();
	}

	private void thenCreateNewCarRecordAndReturnIt() throws Exception {
		Car createdCar = carService.save(car);
		assertEquals(car, createdCar);
		verify(carDAO, atLeastOnce()).save(car);
	}

	private void whenUserCreateANewCarAndSaves() {
		car.setModel("Jeep");
		car.setYear("2014");
	}

}

package com.resasncf.ResaSncf.UseCase.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import org.springframework.stereotype.Service;

import com.resasncf.ResaSncf.Dto.CarDTO;
import com.resasncf.ResaSncf.Dto.CarDTOminimalist;
import com.resasncf.ResaSncf.Dto.FuelCardDTO;
import com.resasncf.ResaSncf.Dto.LocationDTO;
import com.resasncf.ResaSncf.Dto.MaintenanceTypeDTO;
import com.resasncf.ResaSncf.Dto.OperationForCarDTO;
import com.resasncf.ResaSncf.Dto.ReservationForCarDTO;
import com.resasncf.ResaSncf.Models.Car;
import com.resasncf.ResaSncf.Models.FuelCard;
import com.resasncf.ResaSncf.Models.Location;
import com.resasncf.ResaSncf.Models.MaintenanceType;
import com.resasncf.ResaSncf.Models.Operation;
import com.resasncf.ResaSncf.Models.Reservation;
import com.resasncf.ResaSncf.Repository.CarRepository;
import com.resasncf.ResaSncf.Repository.FuelCardRepository;
import com.resasncf.ResaSncf.Repository.LocationRepository;
import com.resasncf.ResaSncf.Repository.MaintenanceTypeRepository;
import com.resasncf.ResaSncf.Repository.OperationRepository;
import com.resasncf.ResaSncf.Repository.ReservationRepository;
import com.resasncf.ResaSncf.UseCase.Exception.CarException;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CarService {
private final CarRepository caRepository;
private final ReservationRepository resaRepository;
private final LocationRepository locationRepository;
private final FuelCardRepository fuelCardRepository;
private final OperationRepository operationRepository;
private final MaintenanceTypeRepository maintenanceTypeRepository;

//////////////////////////////////////////
    public Car create(Car car) {
        return caRepository.save(car);
    }


//////////////////////////////////////////
    public List<CarDTOminimalist> getAll() {
        List<Car> cars = caRepository.findAll();
        List<CarDTOminimalist> carsDTOminimalists = new  ArrayList<>();

        for (Car car : cars) {
            CarDTOminimalist carDTO = new CarDTOminimalist();
            carDTO.setId(car.getId());
            carDTO.setImmat(car.getImmat());
            carDTO.setType(car.getType());
            carDTO.setBrand(car.getBrand());
            carDTO.setPicture(car.getPicture());
            carDTO.setModel(car.getModel());
            carsDTOminimalists.add(carDTO);
        }
        return carsDTOminimalists;
    }


//////////////////////////////////////////
    public CarDTO getById(long id) {
        Optional<Car> carFound = caRepository.findById(id);
        Set<OperationForCarDTO> operationDTOs = new HashSet<>();
        Set<ReservationForCarDTO> carReservationDTOs = new HashSet<>();
        CarDTO carDTO = new CarDTO();
        LocationDTO locationDTO = new LocationDTO();
        FuelCardDTO fuelCardDTO = new FuelCardDTO();

    if(carFound.isPresent()){
        Optional<List<Reservation>> reservationOptional = resaRepository.findByCar_Id(id);
        Optional<List<Operation>> operOptional = operationRepository.findByCar_Id(id);
        Optional<Location> locationOptional = locationRepository.findByCar_Id(id);
        Optional<FuelCard> fuelCardOptional = fuelCardRepository.findByCar_Id(id);
        
        if(reservationOptional.isPresent()){
            List<Reservation> reservations = reservationOptional.get();

            for (Reservation reservation : reservations) {
                ReservationForCarDTO careservationDTO = new ReservationForCarDTO();
                careservationDTO.setId(reservation.getId());
                careservationDTO.setStartDate(reservation.getStartDate());
                careservationDTO.setEndDate(reservation.getEndDate());
                careservationDTO.setStatusReservation(reservation.isStatusReservation());
                careservationDTO.setCostReservation(reservation.getCostReservation());
                carReservationDTOs.add(careservationDTO);
            }
        }

        if(operOptional.isPresent()){
            List<Operation> operations = operOptional.get();

            for(Operation operation : operations) {
                OperationForCarDTO operationDTO = new OperationForCarDTO();
                MaintenanceTypeDTO maintenanceDTO = new MaintenanceTypeDTO();
                Optional<MaintenanceType> maintenanceTypeOptional = maintenanceTypeRepository.findById(operation.getMaintenanceType().getId());
                if(maintenanceTypeOptional.isPresent()) {
                    MaintenanceType maintenanceType = maintenanceTypeOptional.get();
                    maintenanceDTO.setId(maintenanceType.getId());
                    maintenanceDTO.setType(maintenanceType.getType());
                    maintenanceDTO.setDurationHours(maintenanceType.getDurationHours());
                    maintenanceDTO.setCost(maintenanceType.getCost());
                }
                operationDTO.setId(operation.getId());
                operationDTO.setDate(operation.getDate());
                operationDTO.setDescription(operation.getDescription());
                operationDTO.setMaintenanceType(maintenanceDTO);
                operationDTOs.add(operationDTO);
            }
        }     

        if(locationOptional.isPresent()) {
            Location carLocation = locationOptional.get();
            locationDTO.setId(carLocation.getId());
            locationDTO.setCoordinates((carLocation.getCoordinates()));
            locationDTO.setAddress(carLocation.getAddress());
        }

        if(fuelCardOptional.isPresent()) {
            FuelCard fuelCard = fuelCardOptional.get();
            fuelCardDTO.setId(fuelCard.getId());
            fuelCardDTO.setCardNumber(fuelCard.getCardNumber());
            fuelCardDTO.setType(fuelCard.getType());
        }

            Car car = carFound.get();
            carDTO.setCarId(car.getId());
            carDTO.setImmat(car.getImmat());
            carDTO.setType(car.getType());
            carDTO.setBrand(car.getBrand());
            carDTO.setPicture(car.getPicture());
            carDTO.setModel(car.getModel());
            carDTO.setAvailable(car.isAvailable());
            carDTO.setKilometers(car.getKilometers());
            carDTO.setState(car.getState());
            carDTO.setFuel(car.getFuel());
            carDTO.setLocation(locationDTO);
            carDTO.setFuelCard(fuelCardDTO);
            carDTO.setPriceDay(car.getPriceDay()); 
            carDTO.setReservation(carReservationDTOs);       
            carDTO.setOperation(operationDTOs);
        }
        return carDTO;
    }
 

//////////////////////////////////////////
    public void delete(long id) {
        caRepository.deleteById(id);
    }

    
//////////////////////////////////////////
    public Car update(Long id, Car updateCar) {
        Optional<Car> carFound = caRepository.findById(id);
    if(carFound.isPresent()){
        Car oldCar = carFound.get();

        if(updateCar.getImmat() !=null) {
            oldCar.setImmat(updateCar.getImmat()); 
        }

        if(updateCar.getType() !=null) {
            oldCar.setType(updateCar.getType());
        }

        if(updateCar.getBrand() !=null) {
            oldCar.setBrand(updateCar.getBrand());
        }

        if(updateCar.getPicture() !=null) {
            oldCar.setPicture(updateCar.getPicture());
        }

        if(updateCar.getModel() !=null) {
            oldCar.setModel(updateCar.getModel());
        }

        if(updateCar.getKilometers() !=0) {
            oldCar.setKilometers(updateCar.getKilometers());
        }

        if(updateCar.getState() !=null) {
            oldCar.setState(updateCar.getState());
        }

        if(updateCar.getFuel() !=null) {
            oldCar.setFuel(updateCar.getFuel());
        }

        if(updateCar.getPriceDay() !=0) {
            oldCar.setPriceDay(updateCar.getPriceDay());
        }
        return caRepository.save(oldCar);
    } else {
        throw new CarException(id);
    }
    }
}

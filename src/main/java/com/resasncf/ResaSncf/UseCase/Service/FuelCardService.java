package com.resasncf.ResaSncf.UseCase.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.resasncf.ResaSncf.Dto.CarDTOminimalist;
import com.resasncf.ResaSncf.Dto.FuelCardDTO;
import com.resasncf.ResaSncf.Dto.FuelCardDTOWCar;
import com.resasncf.ResaSncf.Models.Car;
import com.resasncf.ResaSncf.Models.FuelCard;
import com.resasncf.ResaSncf.Repository.CarRepository;
import com.resasncf.ResaSncf.Repository.FuelCardRepository;
import com.resasncf.ResaSncf.UseCase.Exception.FuelCardException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuelCardService {
    private final FuelCardRepository repository;
    private final CarRepository carRepository;

//////////////////////////////////////////
    public FuelCard create(FuelCard fuelCard) {
        return repository.save(fuelCard);
    }
    

//////////////////////////////////////////
    public Set<FuelCardDTO> getAll() {
        List<FuelCard> fuelCards = repository.findAll();
        Set<FuelCardDTO> fuelCardsDTO = new HashSet<>();
        
         for (FuelCard fuelCard : fuelCards) {
            FuelCardDTO fuelCardDTO = new FuelCardDTO();
            fuelCardDTO.setId(fuelCard.getId());
            fuelCardDTO.setCardNumber(fuelCard.getCardNumber());
            fuelCardDTO.setType(fuelCard.getType());
            fuelCardDTO.setCostFuel(fuelCard.getCostFuel());

            fuelCardsDTO.add(fuelCardDTO);
        }
           return fuelCardsDTO;
    }


//////////////////////////////////////////
    public FuelCardDTOWCar getById(Long id) {
        FuelCardDTOWCar fuelCardDTO = new FuelCardDTOWCar();
        CarDTOminimalist carDTOminimalist = new CarDTOminimalist();
        Optional<FuelCard> fuelCardFound = repository.findById(id);
        Optional<Car> carOptional = carRepository.findByFuelCard_Id(id);

        if(carOptional.isPresent()){
            Car carFound = carOptional.get();
            carDTOminimalist.setId(carFound.getId());
            carDTOminimalist.setImmat(carFound.getImmat());
            carDTOminimalist.setType(carFound.getType());
            carDTOminimalist.setBrand(carFound.getBrand());
            carDTOminimalist.setModel(carFound.getModel());
            carDTOminimalist.setPicture(carFound.getPicture());
        }
        
        if(fuelCardFound.isPresent()) {
            FuelCard fuelCard = fuelCardFound.get();
            fuelCardDTO.setId(fuelCard.getId());
            fuelCardDTO.setCardNumber(fuelCard.getCardNumber());
            fuelCardDTO.setType(fuelCard.getType());
            fuelCardDTO.setCostFuel(fuelCard.getCostFuel());
            fuelCardDTO.setCar(carDTOminimalist);
           }
        return fuelCardDTO;
    }


//////////////////////////////////////////
    public void delete(long id) {
    repository.deleteById(id);
    }


//////////////////////////////////////////
    public FuelCard update(Long id, FuelCard updateFuelCard) {
        Optional<FuelCard> fuelCardFound = repository.findById(id);
        if(fuelCardFound.isPresent()) {
            FuelCard oldFuelCard = fuelCardFound.get();

            if(updateFuelCard.getCardNumber() != null) {
                oldFuelCard.setCardNumber(updateFuelCard.getCardNumber());
            }

            if(updateFuelCard.getType() != null) {
                oldFuelCard.setType(updateFuelCard.getType());
            }

            if(updateFuelCard.getCostFuel() != null) {
                oldFuelCard.setCostFuel(updateFuelCard.getCostFuel());
            }

            return repository.save(oldFuelCard);
        } else {
            throw new FuelCardException(id);
        }
    }
}

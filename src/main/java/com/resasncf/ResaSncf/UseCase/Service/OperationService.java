package com.resasncf.ResaSncf.UseCase.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.resasncf.ResaSncf.Dto.CarDTOminimalist;
import com.resasncf.ResaSncf.Dto.MaintenanceTypeDTO;
import com.resasncf.ResaSncf.Dto.OperationDTO;
import com.resasncf.ResaSncf.Models.Car;
import com.resasncf.ResaSncf.Models.MaintenanceType;
import com.resasncf.ResaSncf.Models.Operation;
import com.resasncf.ResaSncf.Repository.CarRepository;
import com.resasncf.ResaSncf.Repository.MaintenanceTypeRepository;
import com.resasncf.ResaSncf.Repository.OperationRepository;
import com.resasncf.ResaSncf.UseCase.Exception.OperationException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OperationService {
    private final OperationRepository operationRepository;
    private final MaintenanceTypeRepository maintenanceTypeRepository;
    private final CarRepository carRepository;

    //////////////////////////////////////////
    public Operation create(Operation operation) {
        return operationRepository.save(operation);
    }
    

////////////////////////////////////////////
    public Set<OperationDTO> getAll( ) {
        List<Operation> operations = operationRepository.findAll();
        Set<OperationDTO> operationsDTO = new HashSet<>();
        MaintenanceTypeDTO maintenanceDTO = new MaintenanceTypeDTO();
        CarDTOminimalist carDTOminimalist = new CarDTOminimalist();

        for (Operation operation : operations) {
            Optional<MaintenanceType> maintenanceTyOptional = maintenanceTypeRepository.findById(operation.getMaintenanceType().getId());
            Optional<Car> carOptional = carRepository.findByOperation_Id(operation.getId());

            if(carOptional.isPresent()) {
                Car carFound = carOptional.get();
                carDTOminimalist.setId(carFound.getId());
                carDTOminimalist.setImmat(carFound.getImmat());
                carDTOminimalist.setType(carFound.getType());
                carDTOminimalist.setBrand(carFound.getBrand());
                carDTOminimalist.setModel(carFound.getModel());
                carDTOminimalist.setPicture(carFound.getPicture());
            }
            if(maintenanceTyOptional.isPresent()) {
                MaintenanceType maintenanceType = maintenanceTyOptional.get();
                maintenanceDTO.setId(maintenanceType.getId());
                maintenanceDTO.setType(maintenanceType.getType());
                maintenanceDTO.setDurationHours(maintenanceType.getDurationHours());
                maintenanceDTO.setCost(maintenanceType.getCost());
            }

            OperationDTO operationDTO = new OperationDTO();
            operationDTO.setId(operation.getId());
            operationDTO.setDate(operation.getDate());
            operationDTO.setDescription(operation.getDescription());
            operationDTO.setMaintenanceType(maintenanceDTO);
            operationDTO.setCar(carDTOminimalist);
            operationsDTO.add(operationDTO);
    
        }
            return operationsDTO;
    }


//////////////////////////////////////////
    public OperationDTO getById(long id) {
        OperationDTO operationDTO = new OperationDTO();
        MaintenanceTypeDTO maintenanceTypeDTO = new MaintenanceTypeDTO();
        CarDTOminimalist carDTOminimalist = new CarDTOminimalist();
        Optional<Operation> operationFound = operationRepository.findById(id);
        
        if(operationFound.isPresent()) {
             Operation operation = operationFound.get();
             Optional<MaintenanceType> maintenanceFound = maintenanceTypeRepository.findByOperation_Id(id);
             Optional<Car> carOptional = carRepository.findByOperation_Id(id);
                Car carFound = carOptional.get();
                carDTOminimalist.setId(carFound.getId());
                carDTOminimalist.setImmat(carFound.getImmat());
                carDTOminimalist.setType(carFound.getType());
                carDTOminimalist.setBrand(carFound.getBrand());
                carDTOminimalist.setModel(carFound.getModel());
                carDTOminimalist.setPicture(carFound.getPicture());

                MaintenanceType maintenanceType = maintenanceFound.get();
                maintenanceTypeDTO.setId(maintenanceType.getId());
                maintenanceTypeDTO.setType(maintenanceType.getType());
                maintenanceTypeDTO.setDurationHours(maintenanceType.getDurationHours());
                maintenanceTypeDTO.setCost(maintenanceType.getCost());
             operationDTO.setId(operation.getId());
             operationDTO.setDescription(operation.getDescription());
             operationDTO.setDate(operation.getDate());
             operationDTO.setMaintenanceType(maintenanceTypeDTO);
             operationDTO.setCar(carDTOminimalist);
        }
        return operationDTO;
    }


//////////////////////////////////////////
    public void delete(long id) {
        operationRepository.deleteById(id);
    }


//////////////////////////////////////////
    public Operation update ( Long id, Operation updateOperation) {
        Optional<Operation> operationFound = operationRepository.findById(id);
        
        if(operationFound.isPresent()) {
             Operation oldOperation = operationFound.get();

            if(updateOperation.getDescription() != null){
                oldOperation.setDescription(updateOperation.getDescription());
            }

            if(updateOperation.getDate() != null){
                oldOperation.setDate(updateOperation.getDate());
            }

            if(updateOperation.getCar().getId() != null){
                oldOperation.setCar(updateOperation.getCar());
            }

            if(updateOperation.getMaintenanceType() != null) {
                oldOperation.setMaintenanceType(updateOperation.getMaintenanceType());
            }

            return operationRepository.save(oldOperation);
        } else {
            throw new OperationException(id);
        }
    }
}

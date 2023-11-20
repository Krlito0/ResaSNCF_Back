package com.resasncf.ResaSncf.UseCase.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.resasncf.ResaSncf.Dto.MaintenanceTypeDTO;
import com.resasncf.ResaSncf.Models.MaintenanceType;
import com.resasncf.ResaSncf.Repository.MaintenanceTypeRepository;
import com.resasncf.ResaSncf.UseCase.Exception.MaintenanceTypeException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MaintenanceTypeService {

    private final MaintenanceTypeRepository repository;
 
//////////////////////////////////////////
    public MaintenanceType create(MaintenanceType maintenanceType) {
        return repository.save(maintenanceType);
    }
    

////////////////////////////////////////////
    public Set<MaintenanceTypeDTO> getAll( ) {
        List<MaintenanceType> maintenancesType = repository.findAll();
        Set<MaintenanceTypeDTO> maintenancesDTO = new HashSet<>();

        for (MaintenanceType maintenanceType : maintenancesType) {
            MaintenanceTypeDTO maintenanceDTO = new MaintenanceTypeDTO();
            maintenanceDTO.setId(maintenanceType.getId());
            maintenanceDTO.setType(maintenanceType.getType());
            maintenanceDTO.setDurationHours(maintenanceType.getDurationHours());
            maintenanceDTO.setCost(maintenanceType.getCost());
            
            maintenancesDTO.add(maintenanceDTO);
        }
            return maintenancesDTO;
    }


//////////////////////////////////////////
    public MaintenanceTypeDTO getById(long id) {
        MaintenanceTypeDTO maintenanceDTO = new MaintenanceTypeDTO();
        Optional<MaintenanceType> maintenanceTypeFound = repository.findById(id);

        if(maintenanceTypeFound.isPresent()) {
            MaintenanceType maintenanceType = maintenanceTypeFound.get();
            maintenanceDTO.setType(maintenanceType.getType());
            maintenanceDTO.setDurationHours(maintenanceType.getDurationHours());
            maintenanceDTO.setCost(maintenanceType.getCost()); 
        }
        return maintenanceDTO;
    }


//////////////////////////////////////////
    public void delete(long id) {
        repository.deleteById(id);
    }


//////////////////////////////////////////
    public MaintenanceType update ( Long id, MaintenanceType updateMaintenanceType) {
        Optional<MaintenanceType> maintenanceTypeFound = repository.findById(id);

        if(maintenanceTypeFound.isPresent()) {
            MaintenanceType oldMaintenanceType = maintenanceTypeFound.get();

            if(updateMaintenanceType.getType() != null){
                oldMaintenanceType.setType(updateMaintenanceType.getType());
            }

            if(updateMaintenanceType.getDurationHours() != 0) {
                oldMaintenanceType.setDurationHours(updateMaintenanceType.getDurationHours());
            }

            if(updateMaintenanceType.getCost() != 0) {
                oldMaintenanceType.setCost(updateMaintenanceType.getCost());
            }

            return repository.save(oldMaintenanceType);
        } else {
            throw new MaintenanceTypeException(id);
        }
    }
}
package com.resasncf.ResaSncf.UseCase.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.resasncf.ResaSncf.Dto.CarDTOminimalist;
import com.resasncf.ResaSncf.Dto.OpinionForReservationDTO;
import com.resasncf.ResaSncf.Dto.ReservationDTO;
import com.resasncf.ResaSncf.Models.Car;
import com.resasncf.ResaSncf.Models.Opinion;
import com.resasncf.ResaSncf.Models.Reservation;
import com.resasncf.ResaSncf.Repository.CarRepository;
import com.resasncf.ResaSncf.Repository.OpinionRepository;
import com.resasncf.ResaSncf.Repository.ReservationRepository;
import com.resasncf.ResaSncf.UseCase.Exception.ReservationException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final CarRepository carRepository;
    private final OpinionRepository opinionRepository;

//////////////////////////////////////////
    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
    

//////////////////////////////////////////
    public List<ReservationDTO> getAll( ) {
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationDTO> reservationsDTO = new ArrayList<>();
        CarDTOminimalist carDTOminimalist = new CarDTOminimalist();
        OpinionForReservationDTO opinionForReservationDTO = new OpinionForReservationDTO();

        for (Reservation reservation : reservations) {
            Optional<Car> carOptional = carRepository.findByReservation_Id(reservation.getId());
            Optional<Opinion> opinionOptional =  opinionRepository.findByReservation_Id(reservation.getId());
            if(carOptional.isPresent()){
                Car carFound = carOptional.get();
                carDTOminimalist.setId(carFound.getId());
                carDTOminimalist.setImmat(carFound.getImmat());
                carDTOminimalist.setType(carFound.getType());
                carDTOminimalist.setBrand(carFound.getBrand());
                carDTOminimalist.setModel(carFound.getModel());
                carDTOminimalist.setPicture(carFound.getPicture());
            }

            if(opinionOptional.isPresent()) {
                Opinion opionFound = opinionOptional.get();
                opinionForReservationDTO.setId(opionFound.getId());
                opinionForReservationDTO.setComments(opionFound.getComments());
                opinionForReservationDTO.setOpinionRank(opionFound.getOpinionRank());
            }
            
            ReservationDTO reservationDTO = new ReservationDTO();
            reservationDTO.setId(reservation.getId());
            reservationDTO.setStartDate(reservation.getStartDate());
            reservationDTO.setEndDate(reservation.getEndDate());
            reservationDTO.setStatusReservation(reservation.isStatusReservation());
            reservationDTO.setCostReservation(reservation.getCostReservation());
            reservationDTO.setCar(carDTOminimalist);
            reservationDTO.setOpinion(opinionForReservationDTO);
            reservationsDTO.add(reservationDTO);
        }
            return reservationsDTO;
    }


//////////////////////////////////////////
    public ReservationDTO getById(long id) {
        ReservationDTO reservationDTO = new ReservationDTO();
        CarDTOminimalist carDTOminimalist = new CarDTOminimalist();
        OpinionForReservationDTO opinion = new OpinionForReservationDTO();
        Optional<Reservation> reservationFound = reservationRepository.findById(id);

        if(reservationFound.isPresent()) {
            Optional<Car> carOptional = carRepository.findByReservation_Id(id);
            Optional<Opinion> opinionOptional =  opinionRepository.findByReservation_Id(id);
            if(carOptional.isPresent()) {
                Car carFound = carOptional.get();
                carDTOminimalist.setId(carFound.getId());
                carDTOminimalist.setImmat(carFound.getImmat());
                carDTOminimalist.setType(carFound.getType());
                carDTOminimalist.setBrand(carFound.getBrand());
                carDTOminimalist.setModel(carFound.getModel());
                carDTOminimalist.setPicture(carFound.getPicture());
            }

            if(opinionOptional.isPresent()) {
                Opinion opionFound = opinionOptional.get();
                opinion.setId(opionFound.getId());
                opinion.setComments(opionFound.getComments());
                opinion.setOpinionRank(opionFound.getOpinionRank());
            }
            

            Reservation resa = reservationFound.get();
             reservationDTO.setId(resa.getId());
             reservationDTO.setStartDate(resa.getStartDate());
             reservationDTO.setEndDate(resa.getEndDate());
             reservationDTO.setStatusReservation(resa.isStatusReservation());
             reservationDTO.setCostReservation(resa.getCostReservation());
             reservationDTO.setOpinion(opinion);
             reservationDTO.setCar(carDTOminimalist);
        }

        return reservationDTO;
    }


//////////////////////////////////////////
    public void delete(long id) {
        reservationRepository.deleteById(id);
    }


//////////////////////////////////////////
    public Reservation update ( Long id, Reservation updateReservation) {
        Optional<Reservation> reservationFound = reservationRepository.findById(id);
        if(reservationFound.isPresent()){
            Reservation oldReservation = reservationFound.get();

            if(updateReservation.getStartDate() != null) {
                oldReservation.setStartDate(updateReservation.getStartDate());
            }

            if(updateReservation.getEndDate() != null) {
                oldReservation.setEndDate(updateReservation.getEndDate());
            }

            if(updateReservation.isStatusReservation()) {

            }

            if(updateReservation.getCostReservation() != 0) {
                oldReservation.setCostReservation(updateReservation.getCostReservation());
            }

            return reservationRepository.save(oldReservation);
        } else {
            throw new ReservationException(id);
        }
    }
}

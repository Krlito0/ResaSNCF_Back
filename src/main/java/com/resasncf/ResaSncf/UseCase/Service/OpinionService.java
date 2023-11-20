package com.resasncf.ResaSncf.UseCase.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.resasncf.ResaSncf.Dto.OpinionDTO;
import com.resasncf.ResaSncf.Models.Opinion;
import com.resasncf.ResaSncf.Repository.OpinionRepository;
import com.resasncf.ResaSncf.UseCase.Exception.OpinonException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OpinionService {
    private final OpinionRepository opinionRepository;

//////////////////////////////////////////
    public Opinion create(Opinion opinion) {
        return opinionRepository.save(opinion);
    }


//////////////////////////////////////////
    public Set<OpinionDTO> getAll() {
       List<Opinion> opinions = opinionRepository.findAll();
       Set<OpinionDTO> opinionsDTO = new HashSet<>();
       
       for(Opinion opinion: opinions) {
        OpinionDTO opinionDTO = new OpinionDTO();
        opinionDTO.setId(opinion.getId());
        opinionDTO.setComments(opinion.getComments());
        opinionDTO.setOpinionRank(opinion.getOpinionRank());
        opinionsDTO.add(opinionDTO);
        }
    return opinionsDTO;
    }
 
    
//////////////////////////////////////////
    public OpinionDTO getById(Long id) {
        OpinionDTO opinionDTO = new OpinionDTO();
        Optional<Opinion> opinionFound = opinionRepository.findById(id);
        if(opinionFound.isPresent()) {
            Opinion opinion = opinionFound.get();
            opinionDTO.setId(opinion.getId());
            opinionDTO.setComments(opinion.getComments());
            opinionDTO.setOpinionRank(opinion.getOpinionRank());
        }
        return opinionDTO;
    }


//////////////////////////////////////////
public void delete(long id) {
    opinionRepository.deleteById(id);
}


//////////////////////////////////////////
public Opinion update(Long id, Opinion updateOpinion) {
    Optional<Opinion> opinionFound = opinionRepository.findById(id);
    if(opinionFound.isPresent()) {
        Opinion oldOpinion = opinionFound.get();

        if(updateOpinion.getComments() != null) {
            oldOpinion.setComments(updateOpinion.getComments());            
        }

        if(updateOpinion.getOpinionRank() != 0) {
            oldOpinion.setOpinionRank(updateOpinion.getOpinionRank());
        }

        return opinionRepository.save(updateOpinion);
    }else {
        throw new OpinonException(id);
    }
}

}

package com.wineranger.wineranger.service;

import com.wineranger.wineranger.dto.auxiliars.CoordinatesDTO;
import com.wineranger.wineranger.entity.auxuliars.Coordinates;
import com.wineranger.wineranger.repository.CoordinatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoordinatesServiceImpl implements CoordinatesService{

    private final CoordinatesRepository coordinatesRepository;

    @Autowired
    public CoordinatesServiceImpl(CoordinatesRepository coordinatesRepository, CoordinatesRepository coordinatesRepository1){
        this.coordinatesRepository = coordinatesRepository;
    }

    @Override
    public List<CoordinatesDTO> getAll() {
        return coordinatesRepository.findAll().stream().map(CoordinatesDTO::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public CoordinatesDTO getById(Long id) throws Exception {
        Optional<Coordinates> existing = coordinatesRepository.findById(id);
        if(existing.isEmpty()){
            throw new Exception("No entity");
        }
        return existing.get().returnDTO();
    }

    @Override
    public CoordinatesDTO create(CoordinatesDTO dto) {
        Coordinates entity = new Coordinates(dto);
        return coordinatesRepository.save(entity).returnDTO();
    }

    @Override
    public CoordinatesDTO modify(CoordinatesDTO dto) throws Exception {
        Optional<Coordinates> existing = coordinatesRepository.findById(dto.getId());
        if(existing.isEmpty()){
            throw new Exception("No entity");
        }
        Coordinates entityToUpdate = existing.get();
        entityToUpdate.updateFromDTO(dto);
        return coordinatesRepository.save(entityToUpdate).returnDTO();

    }

    @Override
    public CoordinatesDTO delete(Long id) throws Exception {
        Optional<Coordinates> existing = coordinatesRepository.findById(id);
        if(existing.isEmpty()){
            throw new Exception("No entity");
        }
        Coordinates entityToUpdate = existing.get();
        entityToUpdate.setValid(false);
        return coordinatesRepository.save(entityToUpdate).returnDTO();
    }
}

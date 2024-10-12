package com.wineranger.wineranger.service;

import com.wineranger.wineranger.dto.auxiliars.CoordinatesDTO;
import com.wineranger.wineranger.entity.auxuliars.Coordinates;
import com.wineranger.wineranger.repository.CoordinatesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoordinatesServiceImpl implements CoordinatesService{

    private final CoordinatesRepository coordinatesRepository;
    private static final Logger logger = LoggerFactory.getLogger(CoordinatesServiceImpl.class);


    @Autowired
    public CoordinatesServiceImpl(CoordinatesRepository coordinatesRepository, CoordinatesRepository coordinatesRepository1){
        this.coordinatesRepository = coordinatesRepository;
    }

    @Override
    public List<CoordinatesDTO> getAllAndValid() {
        logger.info("getAllAndValid started");
        return coordinatesRepository.findAllAndValid().stream().map(CoordinatesDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<CoordinatesDTO> getAll() {
        logger.info("getAll started");
        return coordinatesRepository.findAll().stream().map(CoordinatesDTO::new).collect(Collectors.toList());
    }

    @Override
    public CoordinatesDTO getById(Long id) throws Exception {
        logger.info("getById started");
        Optional<Coordinates> existing = coordinatesRepository.findById(id);
        if(existing.isEmpty()){
            throw new Exception("No entity");
        }
        logger.info("getById:{}", existing.get().toString());
        return existing.get().returnDTO();
    }

    @Override
    public CoordinatesDTO create(CoordinatesDTO dto) {
        logger.info("create started");
        Coordinates entity = new Coordinates(dto);
        logger.info("create:{}", entity.toString());
        return coordinatesRepository.save(entity).returnDTO();
    }

    @Override
    public CoordinatesDTO modify(CoordinatesDTO dto) throws Exception {
        logger.info("modify started");
        Optional<Coordinates> existing = coordinatesRepository.findById(dto.getId());
        if(existing.isEmpty()){
            throw new Exception("No entity");
        }
        Coordinates entityToUpdate = existing.get();
        entityToUpdate.updateSystemDataFields(dto);
        entityToUpdate.updateFromDTO(dto);
        logger.info("modify:{}", entityToUpdate.toString());
        return coordinatesRepository.save(entityToUpdate).returnDTO();

    }

    @Override
    public CoordinatesDTO delete(Long id) throws Exception {
        logger.info("delete started");
        Optional<Coordinates> existing = coordinatesRepository.findById(id);
        if(existing.isEmpty()){
            throw new Exception("No entity");
        }
        Coordinates entityToUpdate = existing.get();
        entityToUpdate.setDeleted();
        logger.info("delete:{}", entityToUpdate.toString());
        return coordinatesRepository.save(entityToUpdate).returnDTO();
    }
}

package com.wineranger.wineranger.service;

import com.wineranger.wineranger.dto.auxiliars.CoordinatesDTO;
import java.util.List;

public interface CoordinatesService {

    public List<CoordinatesDTO> getAll();
    public CoordinatesDTO getById(Long id) throws Exception;
    public CoordinatesDTO create(CoordinatesDTO dto);
    public CoordinatesDTO modify(CoordinatesDTO dto) throws Exception;
    public CoordinatesDTO delete (Long id) throws Exception;
}

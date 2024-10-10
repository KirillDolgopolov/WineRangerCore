package com.wineranger.wineranger.entity.auxuliars;

import com.wineranger.wineranger.dto.auxiliars.CoordinatesDTO;
import com.wineranger.wineranger.entity.AbstractClass;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Coordinates extends AbstractClass {

    private Double latitude;
    private Double longitude;

    public Coordinates(CoordinatesDTO dto){
        super(dto);
        this.setLongitude(dto.getLongitude());
        this.setLatitude(dto.getLatitude());
    }

    public Coordinates(){
       // super();
    }

    public CoordinatesDTO returnDTO(){
        CoordinatesDTO result = new CoordinatesDTO(this);
        result.mapSystemFields(this);
        return result;
    }

    /*
    * We can update an existing entity from a DTO
    */
    public void updateFromDTO(CoordinatesDTO dto){
        this.setLatitude(dto.getLatitude());
        this.setLongitude(dto.getLongitude());
    }


}

package com.wineranger.wineranger.entity.auxuliars;

import com.wineranger.wineranger.dto.auxiliars.CoordinatesDTO;
import com.wineranger.wineranger.entity.AbstractClass;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@ToString(callSuper = true)
public class Coordinates extends AbstractClass {

    private Double latitude;
    private Double longitude;

    public Coordinates(){
    }

    public Coordinates(CoordinatesDTO dto){
        super(dto);
        this.setLongitude(dto.getLongitude());
        this.setLatitude(dto.getLatitude());
    }

    public CoordinatesDTO returnDTO(){
        return new CoordinatesDTO(this);
    }

    public void updateFromDTO(CoordinatesDTO dto){
        this.setLatitude(dto.getLatitude());
        this.setLongitude(dto.getLongitude());
    }


}

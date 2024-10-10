package com.wineranger.wineranger.entity.auxuliars;

import com.wineranger.wineranger.dto.auxiliars.CoordinatesDTO;
import com.wineranger.wineranger.entity.AbstractClass;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
public class Coordinates extends AbstractClass {
    private Double latitude;
    private Double longitude;

    /*
     * We can create a new entity from a DTO
     */
    public Coordinates(CoordinatesDTO dto){
        super();
        this.setLongitude(dto.getLongitude());
        this.setLatitude(dto.getLatitude());
    }

    public Coordinates(){
        super();
    }

    public CoordinatesDTO returnDTO(){
        return new CoordinatesDTO(this.getLatitude(), this.getLongitude());
    }

    /*
    * We can update an existing entity from a DTO
    */
    public void updateFromDTO(CoordinatesDTO dto){
        this.setLatitude(dto.getLatitude());
        this.setLongitude(dto.getLongitude());
    }


}

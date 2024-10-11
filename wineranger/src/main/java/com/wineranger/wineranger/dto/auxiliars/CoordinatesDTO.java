package com.wineranger.wineranger.dto.auxiliars;

import com.wineranger.wineranger.dto.AbstractClassDTO;
import com.wineranger.wineranger.entity.auxuliars.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CoordinatesDTO extends AbstractClassDTO {
    private Double latitude;
    private Double longitude;

    public CoordinatesDTO(){
        super();
    }

    public CoordinatesDTO(Coordinates entity){
    super(entity);
    this.setLatitude(entity.getLatitude());
    this.setLongitude(entity.getLongitude());
    }


}

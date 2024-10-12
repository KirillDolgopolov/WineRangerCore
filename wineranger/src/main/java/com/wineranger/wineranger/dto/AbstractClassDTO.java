package com.wineranger.wineranger.dto;

import com.wineranger.wineranger.entity.AbstractClass;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@MappedSuperclass
@Data
public abstract class AbstractClassDTO {

    private Long id;
    private Boolean valid = true;
    private Long userModId;
    private Timestamp dateMod;

    public AbstractClassDTO(){
    }

    public AbstractClassDTO(AbstractClass entity){
        updateDataFields(entity);
    }

    public void updateDataFields(AbstractClass entity) {
        this.setId(entity.getId());
        this.setValid(entity.getValid());
        this.setUserModId(entity.getUserModId());
        this.setDateMod(entity.getDateMod());
    }

}

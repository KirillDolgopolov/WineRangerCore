package com.wineranger.wineranger.entity;

import com.wineranger.wineranger.dto.AbstractClassDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@MappedSuperclass
//@RequiredArgsConstructor
@Data
public abstract class AbstractClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="valid", nullable=false)
    private Boolean valid = true;

    @Column(name="usuari_mod_id", length=50, nullable=false)
    private Long userModId;

    @Column(name="data_mod", nullable=false)
    private Timestamp dateMod;

    public void prepareToSave() {
        this.setDateMod(new Timestamp(System.currentTimeMillis()));
    }

    public AbstractClass(AbstractClassDTO dto) {
        mapSystemFields(dto);
    }

    public AbstractClass() {
    }


    public void mapSystemFields(AbstractClassDTO dto) {
        this.setId(dto.getId());
        this.setValid(dto.getValid());
        this.setUserModId(dto.getUserModId());
        this.setDateMod(dto.getDateMod());
    }


}

package com.wineranger.wineranger.entity.auxuliars;

import com.wineranger.wineranger.entity.AbstractClass;
import com.wineranger.wineranger.entity.PlaceOfInterest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Phone extends AbstractClass {

    @Column
    private String number;  //TODO validate number

    @JoinColumn(name = "place_of_interest_id")
    private PlaceOfInterest placeOfInterest;

    private String description;
}

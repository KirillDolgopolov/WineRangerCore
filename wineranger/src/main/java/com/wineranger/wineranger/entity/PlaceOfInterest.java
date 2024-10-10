package com.wineranger.wineranger.entity;

import com.wineranger.wineranger.entity.auxuliars.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
public class PlaceOfInterest extends AbstractClass{

    private String description;

    @JoinColumn
    @ManyToOne
    private TypeOfPlace typeOfPlace;

    @OneToMany(mappedBy = "placeOfInterest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List <Link> links;

    @OneToMany(mappedBy = "placeOfInterest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List <Email> emails;

    @OneToMany(mappedBy = "placeOfInterest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List <Phone> phones;

    @OneToMany(mappedBy = "placeOfInterest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List <WorkSchedule> schedules;

    @ManyToOne
    private Coordinates coordinates;

    @Column(nullable = true)
    private Boolean drink;

    @Column(nullable = true)
    private Boolean buy;

    @Column(nullable = true)
    private Boolean eat;

    @Column(nullable = true)
    private Boolean hotel;


}

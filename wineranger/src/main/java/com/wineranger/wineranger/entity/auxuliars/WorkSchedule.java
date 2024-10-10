package com.wineranger.wineranger.entity.auxuliars;

import com.wineranger.wineranger.entity.AbstractClass;
import com.wineranger.wineranger.entity.PlaceOfInterest;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@RequiredArgsConstructor
public class WorkSchedule extends AbstractClass {

    private String open;
    private String close;
    @ManyToOne
    @JoinColumn(name = "place_of_interest_id")
    private PlaceOfInterest placeOfInterest;
    @ManyToOne
    @JoinColumn(name = "weekday_id")
    private Weekday day;

}

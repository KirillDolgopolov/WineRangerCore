package com.wineranger.wineranger.entity.auxuliars;

import com.wineranger.wineranger.entity.AbstractClass;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Weekday extends AbstractClass {

    @Column
    @NonNull
    private String dayName;
}

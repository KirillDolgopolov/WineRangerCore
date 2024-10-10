package com.wineranger.wineranger.entity.auxuliars;

import com.wineranger.wineranger.entity.AbstractClass;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Language extends AbstractClass {

    @Column
    @NonNull
    private String languageName;
}

package com.wineranger.wineranger.entity.auxuliars;

import com.wineranger.wineranger.entity.AbstractClass;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DescriptionLangText extends AbstractClass {

    private Long languageId;
    private Long placeOfInterestId;
    private String descriptionText;

}

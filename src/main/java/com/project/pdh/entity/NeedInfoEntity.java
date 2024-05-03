package com.project.pdh.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "needInfo")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NeedInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prkplceNo;

    private String prkplceNm;

    private String prkplceSe;

    private String rdnmadr;

    private String operDay;

    private String weekdayOperOpenHhmm;

    private String weekdayOperCloseHhmm;

    private String parkingchrgeInfo;
}

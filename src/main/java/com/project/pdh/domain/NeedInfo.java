package com.project.pdh.domain;

import com.project.pdh.entity.NeedInfoEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@Builder
public class NeedInfo {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String prkplceNo;
    private String prkplceNm;
    private String prkplceSe;
    private String rdnmadr;
    private String operDay;
    private String weekdayOperOpenHhmm;
    private String weekdayOperCloseHhmm;
    private String parkingchrgeInfo;

    public static NeedInfo toDomain(NeedInfoEntity entity) {
        return NeedInfo.builder()
                .id(entity.getId())
                .prkplceNo(entity.getPrkplceNo())
                .prkplceNm(entity.getPrkplceNm())
                .prkplceSe(entity.getPrkplceSe())
                .rdnmadr(entity.getRdnmadr())
                .operDay(entity.getOperDay())
                .weekdayOperOpenHhmm(entity.getWeekdayOperOpenHhmm())
                .weekdayOperCloseHhmm(entity.getWeekdayOperCloseHhmm())
                .parkingchrgeInfo(entity.getParkingchrgeInfo())
                .build();
    }

    public static NeedInfoEntity toEntity(NeedInfo needInfo) {
        return NeedInfoEntity.builder()
                .id(needInfo.getId())
                .prkplceNo(needInfo.getPrkplceNo())
                .prkplceNm(needInfo.getPrkplceNm())
                .prkplceSe(needInfo.getPrkplceSe())
                .rdnmadr(needInfo.getRdnmadr())
                .operDay(needInfo.getOperDay())
                .weekdayOperOpenHhmm(needInfo.getWeekdayOperOpenHhmm())
                .weekdayOperCloseHhmm(needInfo.getWeekdayOperCloseHhmm())
                .parkingchrgeInfo(needInfo.getParkingchrgeInfo())
                .build();
    }
}


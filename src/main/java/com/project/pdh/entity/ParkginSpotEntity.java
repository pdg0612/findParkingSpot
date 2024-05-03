package com.project.pdh.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "parkingspot")
public class ParkginSpotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prkplceNo")
    private String prkplceNo;

    @Column(name = "prkplceNm")
    private String prkplceNm;

    @Column(name = "prkplceSe")
    private String prkplceSe;

    @Column(name = "prkplceType")
    private String prkplceType;

    @Column(name = "rdnmadr")
    private String rdnmadr;

    @Column(name = "lnmadr")
    private String lnmadr;

    @Column(name = "prkcmprt")
    private String prkcmprt;

    @Column(name = "feedingSe")
    private String feedingSe;

    @Column(name = "enforceSe")
    private String enforceSe;

    @Column(name = "operDay")
    private String operDay;

    @Column(name = "weekdayOperOpenHhmm")
    private String weekdayOperOpenHhmm;

    @Column(name = "weekdayOperCloseHhmm")
    private String weekdayOperCloseHhmm;

    @Column(name = "satOperOperOpenHhmm")
    private String satOperOperOpenHhmm;

    @Column(name = "satOperCloseHhmm")
    private String satOperCloseHhmm;

    @Column(name = "holidayOperOpenHhmm")
    private String holidayOperOpenHhmm;

    @Column(name = "holidayCloseOpenHhmm")
    private String holidayCloseOpenHhmm;

    @Column(name = "parkingchrgeInfo")
    private String parkingchrgeInfo;

    @Column(name = "basicTime")
    private int basicTime;

    @Column(name = "basicCharge")
    private int basicCharge;

    @Column(name = "addUnitTime")
    private int addUnitTime;

    @Column(name = "addUnitCharge")
    private int addUnitCharge;

    @Column(name = "dayCmmtktAdjTime")
    private String dayCmmtktAdjTime;

    @Column(name = "dayCmmtkt")
    private int dayCmmtkt;

    @Column(name = "monthCmmtkt")
    private int monthCmmtkt;

    @Column(name = "metpay")
    private String metpay;

    @Column(name = "spcmnt")
    private String spcmnt;

    @Column(name = "institutionNm")
    private String institutionNm;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "pwdbsPpkZoneYn")
    private String pwdbsPpkZoneYn;

    @Column(name = "referenceDate")
    private String referenceDate;

    @Column(name = "instt_code")
    private String instt_code;

    @Column(name = "instt_nm")
    private String instt_nm;

}

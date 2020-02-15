package com.spring5.practice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_country")
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long countryId;
    @Column(name = "country_code", unique = true, nullable = false, updatable = false)
    private String countryCode;
    @Column(name = "country_name", nullable = false)
    private String countryName;

    public Country() {
    }

    public Country(long countryId, String countryCode, String countryName) {
        super();
        this.countryId = countryId;
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}

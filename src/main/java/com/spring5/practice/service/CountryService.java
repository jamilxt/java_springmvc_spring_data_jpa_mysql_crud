package com.spring5.practice.service;

import com.spring5.practice.exceptions.ResourceAlreadyExistsException;
import com.spring5.practice.model.Country;
import com.spring5.practice.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    private static List<Country> countries = new ArrayList<Country>();

    @Autowired
    private CountryRepository countryRepository;

    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    public void checkCountryInList(Country c) {
        if (countries.stream().filter(country -> country.getCountryCode().equals(c.getCountryCode())).findAny()
                .isPresent()) {
            throw new ResourceAlreadyExistsException("Country already exists in list");
        }
    }

    public Country getCountryByCode(String countryCode) {
        return countryRepository.findByCountryCode(countryCode);
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}

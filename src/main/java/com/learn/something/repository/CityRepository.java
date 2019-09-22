package com.learn.something.repository;

import com.learn.something.entity.City;

public interface CityRepository {

    City findCityByName(String name);

    City findCityById(int id);

}

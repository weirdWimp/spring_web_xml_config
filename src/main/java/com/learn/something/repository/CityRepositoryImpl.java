package com.learn.something.repository;

import com.learn.something.entity.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class CityRepositoryImpl implements CityRepository {

    private static String QUERY_CITY_BY_NAME_SQL = "SELECT * FROM City WHERE name = ?";

    private JdbcOperations jdbcOperations;

    private SessionFactory sessionFactory;

    @Autowired
    public CityRepositoryImpl(JdbcOperations jdbcOperations, SessionFactory sessionFactory) {
        this.jdbcOperations = jdbcOperations;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public City findCityByName(String name) {
        return jdbcOperations.queryForObject(QUERY_CITY_BY_NAME_SQL, (rs, rowNum) -> {
            City city = new City();
            city.setId(rs.getInt("ID"));
            city.setName(rs.getString("Name"));
            city.setCountryCode(rs.getString("CountryCode"));
            city.setDistrict(rs.getString("District"));
            city.setPopulation(rs.getInt("Population"));
            return city;
        }, name);
    }

    @Override
    public City findCityById(int id) {
        Session session = getCurrentSession();
        City city = session.get(City.class, id);
        return city;
    }

    private Session getCurrentSession() {
        return sessionFactory.openSession();
    }

}

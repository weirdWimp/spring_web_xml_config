package com.learn.something;

import com.learn.something.entity.City;
import com.learn.something.repository.CityRepository;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AppMain {

    public static void main(String[] args) {

        contextTest();

    }

    public static void contextTest() {

        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext();
        context.setConfigLocation("F:\\DevelopmentKit\\idea-workspace\\java-workspace\\spring_web_xml_config\\web\\WEB-INF\\spring\\root-context.xml");
        context.refresh();

        CityRepository repository = context.getBean(CityRepository.class);
        City qandaharCity = repository.findCityByName("Qandahar");
        System.out.println("qandaharCity = " + qandaharCity);

        City city = repository.findCityById(1);
        System.out.println("city = " + city);
    }

}

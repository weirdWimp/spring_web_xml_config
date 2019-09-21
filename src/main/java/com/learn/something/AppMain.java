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
        context.setConfigLocation("D:\\workspace\\idea\\java_workspace\\spring_web_xml_config\\web\\WEB-INF\\spring\\root-context.xml");
        context.refresh();

        CityRepository repository = context.getBean(CityRepository.class);
        City qandaharCity = repository.findCityByName("Qandahar");
        System.out.println("qandaharCity = " + qandaharCity);


    }

}

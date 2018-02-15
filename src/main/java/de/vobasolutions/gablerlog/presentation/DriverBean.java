package de.vobasolutions.gablerlog.presentation;

import de.vobasolutions.gablerlog.model.Driver;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class DriverBean {
    private List<Driver> drivers;

    public List<Driver> getDrivers() {
        return drivers;
    }

    @PostConstruct
    public void setup() {
        List<Driver> drivers = new ArrayList<Driver>();

        Driver driver1 = new Driver();
        driver1.setForeName("John");
        driver1.setLastName("Doe");
        driver1.setDriverId(123456);
        driver1.setLicenceString("B-Klasse");

        drivers.add(driver1);

        Driver driver2 = new Driver();
        driver2.setForeName("Adam");
        driver2.setLastName("Scott");
        driver2.setDriverId(98765);
        driver2.setLicenceString("E-Klasse");


        drivers.add(driver2);

        Driver driver3 = new Driver();
        driver3.setForeName("Jane");
        driver3.setLastName("Doe");
        driver3.setDriverId(65432);
        driver3.setLicenceString("LKW");


        drivers.add(driver3);
        this.drivers = drivers;
    }
}
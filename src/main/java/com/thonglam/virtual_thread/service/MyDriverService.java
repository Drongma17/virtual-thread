package com.thonglam.virtual_thread.service;

import com.thonglam.virtual_thread.entity.Driver;

import java.util.List;
import java.util.Optional;

public interface MyDriverService {

    public Optional<Driver> saveDriver(Driver driver);

    public List<Driver> getAllDriver();

    public  Optional<Driver>  getDriver(Long driverId);

    public  Optional<Driver>  updateDriver(Driver driver, Long driverId);

    public void deleteDriver(Long driverId);
}

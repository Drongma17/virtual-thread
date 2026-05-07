package com.thonglam.virtual_thread.service.serviceImpl;

import com.thonglam.virtual_thread.entity.Driver;
import com.thonglam.virtual_thread.repository.DriverRepository;
import com.thonglam.virtual_thread.service.MyDriverService;

import java.util.List;
import java.util.Optional;

public class DriverServiceImpl implements MyDriverService {


    private final DriverRepository repository;

    public DriverServiceImpl(DriverRepository repository) {
        this.repository = repository;
    }

    @Override
    public  Optional<Driver>  saveDriver(Driver driver) {
        return Optional.of(repository.save(driver));
    }

    @Override
    public List<Driver> getAllDriver() {
        return repository.findAll();
    }

    @Override
    public Optional<Driver> getDriver(Long driverId) {
        return repository.findById(driverId);
    }

    @Override
    public  Optional<Driver>  updateDriver(Driver driver, Long driverId) {
        Optional<Driver>  driverFromDb = repository.findById(driverId);

        return null;
    }

    @Override
    public void deleteDriver(Long driverId) {

    }
}

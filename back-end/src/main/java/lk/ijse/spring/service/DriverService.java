package lk.ijse.spring.service;

import lk.ijse.spring.dto.DriverDTO;

import java.util.ArrayList;

public interface DriverService {
    public void savedriver(DriverDTO dto);
    public ArrayList<DriverDTO> loadAllDrivers();
}

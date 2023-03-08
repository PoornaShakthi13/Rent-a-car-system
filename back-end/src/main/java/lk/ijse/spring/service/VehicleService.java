package lk.ijse.spring.service;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.VehicleDTO;

import java.util.ArrayList;

public interface VehicleService {
    public void saveVehicle(VehicleDTO dto);
    public ArrayList<VehicleDTO> LoadAllVehicles();
}

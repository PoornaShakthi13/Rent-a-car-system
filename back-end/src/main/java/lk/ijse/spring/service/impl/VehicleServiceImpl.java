package lk.ijse.spring.service.impl;


import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.VehicleDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.Vehicle;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.repo.VehicleRepo;
import lk.ijse.spring.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional

public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void saveVehicle(VehicleDTO dto) {
        if (vehicleRepo.existsById(dto.getId())){
            throw new RuntimeException("Vehicle"+dto.getId()+"already exits");
        }
        vehicleRepo.save(modelMapper.map(dto, Vehicle.class));
    }

    @Override
    public ArrayList<VehicleDTO> LoadAllVehicles() {
        return modelMapper.map(vehicleRepo.findAll(), new TypeToken<ArrayList<VehicleDTO>>() {}.getType());
    }
}

package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional

public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public void savedriver(DriverDTO dto) {
        if (driverRepo.existsById(dto.getId())){
            throw new RuntimeException("driver"+dto.getId()+"already exits");
        }
        driverRepo.save(modelMapper.map(dto, Driver.class));
    }


    @Override
    public ArrayList<DriverDTO> loadAllDrivers() {
        return modelMapper.map(driverRepo.findAll(), new TypeToken<ArrayList<DriverDTO>>() {}.getType());
    }
}

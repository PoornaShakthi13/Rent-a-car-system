package lk.ijse.spring.service.impl;


import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void saveAdmin(AdminDTO dto) {
        if (adminRepo.existsById(dto.getId())){
            throw new RuntimeException("Admin"+dto.getId()+"already exits");
        }
        adminRepo.save(modelMapper.map(dto, Admin.class));
    }


    @Override
    public ArrayList<AdminDTO> loadAllAdmins() {
        return modelMapper.map(adminRepo.findAll(), new TypeToken<ArrayList<AdminDTO>>() {}.getType());
    }
}

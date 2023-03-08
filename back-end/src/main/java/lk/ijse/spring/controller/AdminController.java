package lk.ijse.spring.controller;


import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.service.AdminService;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/Admin")

public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseUtil saveAdmin(@RequestBody AdminDTO dto){
        adminService.saveAdmin(dto);
        return new ResponseUtil("200",dto.getId()+"added",null);

    }
    @GetMapping
    public ResponseUtil loadAllAdmins(){
        ArrayList<AdminDTO> allAdmins= adminService.loadAllAdmins();
        return new ResponseUtil("200","success",allAdmins);
    }
}

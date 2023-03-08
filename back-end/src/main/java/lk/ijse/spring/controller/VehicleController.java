package lk.ijse.spring.controller;


import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.VehicleDTO;
import lk.ijse.spring.service.AdminService;
import lk.ijse.spring.service.VehicleService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/Vehicle")

public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseUtil saveVehicle(@RequestBody VehicleDTO dto){
        vehicleService.saveVehicle(dto);
        return new ResponseUtil("200",dto.getId()+"added",null);

    }
    @GetMapping
    public ResponseUtil loadAllAdmins(){
        ArrayList<VehicleDTO> allAdmins= vehicleService.LoadAllVehicles();
        return new ResponseUtil("200","success",allAdmins);
    }
}

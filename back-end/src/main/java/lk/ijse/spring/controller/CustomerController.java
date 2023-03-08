package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/customer")


public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO dto){
        customerService.savecustomer(dto);
        return new ResponseUtil("200",dto.getId()+"added",null);

    }

    public ResponseUtil getAllCustomers(){
        ArrayList<CustomerDTO> allcustomers= customerService.getAllCustomer();
        return new ResponseUtil("200","success",allcustomers);
    }
}

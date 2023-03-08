package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    public void  savecustomer(CustomerDTO dto);
    public ArrayList <CustomerDTO> getAllCustomer();

}

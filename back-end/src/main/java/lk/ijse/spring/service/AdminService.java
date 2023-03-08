package lk.ijse.spring.service;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.DriverDTO;

import java.util.ArrayList;

public interface AdminService {
    public void saveAdmin(AdminDTO dto);
    public ArrayList<AdminDTO> loadAllAdmins();
}

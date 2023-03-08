package lk.ijse.spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.security.PrivateKey;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Vehicle {
    @Id
    private int id;
    private String vehicleModel;
    private String vehicleNumber;
    private String fuelType;
    private String vehiclePrice;


}

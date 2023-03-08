package lk.ijse.spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {
    @Id
    private int id;
    private String first_name;
    private String last_name;
    private String birthday;
    private String email;
    private String mobile;
}

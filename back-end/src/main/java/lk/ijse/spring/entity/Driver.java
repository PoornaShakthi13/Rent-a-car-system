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

public class Driver {
    @Id
    private int id;
    private String firstname;
    private String lasttname;
    private String birthday;
    private String img;
    private String email;
    private String phonenumber;
}

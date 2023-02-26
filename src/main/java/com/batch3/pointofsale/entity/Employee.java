package com.batch3.pointofsale.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
@Table(name = "employee")
@TypeDefs({
        @TypeDef(name = "json" , typeClass = JsonType.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;

    @Column(name = "employee_name", nullable = false)
    private  String employeeName;

    @Column(name = "employee_address",length = 250)
    private String employeeAddress;

    @Column(name = "email",length = 100)
    private  String email;

    @Column(name = "contact_numbers", columnDefinition = "json")
    @Type(type = "json")
    private ArrayList contactNumber;

    @Column(name = "nic", length = 20)
    private String nic;

    @Column(name = "position")
    private String position;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState;


}

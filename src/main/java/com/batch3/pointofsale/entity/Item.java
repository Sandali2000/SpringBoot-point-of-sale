package com.batch3.pointofsale.entity;

import com.batch3.pointofsale.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Item {
    @Id
    @Column(name = "item_id", length = 100)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name" , nullable = false, length = 200)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measuring_unit" ,nullable = false, length = 25)
    private MeasuringUnitType measuringUnit;

    @Column(name = "balance_qty" , nullable = false, length = 200)
    private double balanceQty;

    @Column(name = "supplier_price" , nullable = false, length = 200)
    private double supplierPrice;

    @Column(name = "selling_price" , nullable = false, length = 200)
    private double sellingPrice;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState;
}

package com.batch3.pointofsale.dto.request;

import com.batch3.pointofsale.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestSaveItemDTO {
    private String itemName;
    private MeasuringUnitType measuringUnit;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
}

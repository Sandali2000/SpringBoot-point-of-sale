package com.batch3.pointofsale.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ResponseActiveCustomerDTO {

    private String customerName;
    private ArrayList contactNumber;

}

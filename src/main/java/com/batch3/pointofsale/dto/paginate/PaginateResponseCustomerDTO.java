package com.batch3.pointofsale.dto.paginate;

import com.batch3.pointofsale.dto.response.ResponseAllCustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginateResponseCustomerDTO {
    private List<ResponseAllCustomerDTO> list;
    private long DataCount;
}

package com.batch3.pointofsale.dto.paginate;

import com.batch3.pointofsale.dto.response.ResponseGetAllItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginateResponseItemDTO {
    private List<ResponseGetAllItemDTO> list;
    private long DataCount;
}

package com.batch3.pointofsale.util.mapper;


import com.batch3.pointofsale.dto.paginate.PaginateResponseItemDTO;
import com.batch3.pointofsale.dto.request.RequestSaveItemDTO;
import com.batch3.pointofsale.dto.response.ResponseAllCustomerDTO;
import com.batch3.pointofsale.dto.response.ResponseGetAllItemDTO;
import com.batch3.pointofsale.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item itemDtoToEntity(RequestSaveItemDTO requestSaveItemDTO);
    List<RequestSaveItemDTO> entityDtoToResponseDto(List<Item>items);
   List<ResponseGetAllItemDTO> pageListToDtoList(Page<Item> items);

}
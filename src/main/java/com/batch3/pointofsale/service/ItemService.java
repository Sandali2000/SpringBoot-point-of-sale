package com.batch3.pointofsale.service;

import com.batch3.pointofsale.dto.paginate.PaginateResponseItemDTO;
import com.batch3.pointofsale.dto.request.RequestSaveItemDTO;
import com.batch3.pointofsale.dto.response.ResponseGetAllItemDTO;
import com.batch3.pointofsale.dto.response.ResponseSaveItemDTO;

import java.util.List;

public interface ItemService {


    ResponseSaveItemDTO addItem(RequestSaveItemDTO requestSaveItemDTO);

    List<RequestSaveItemDTO> getAllItem();

    PaginateResponseItemDTO getAllItemByPaginate(int page, int size);


    List<ResponseGetAllItemDTO> itemGet();
}

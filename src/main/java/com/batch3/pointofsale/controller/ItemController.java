package com.batch3.pointofsale.controller;

import com.batch3.pointofsale.dto.paginate.PaginateResponseItemDTO;
import com.batch3.pointofsale.dto.request.RequestSaveItemDTO;
import com.batch3.pointofsale.dto.response.ResponseGetAllItemDTO;
import com.batch3.pointofsale.dto.response.ResponseSaveItemDTO;
import com.batch3.pointofsale.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;
@Validated
@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

  @Autowired
  private ItemService itemService;

    @PostMapping(path = "/save")
    public ResponseSaveItemDTO saveItem(@RequestBody RequestSaveItemDTO requestSaveItemDTO){
        ResponseSaveItemDTO responseSaveItemDTO = itemService.addItem(requestSaveItemDTO);
        return responseSaveItemDTO;
    }
    @GetMapping(path = "/get-all-item")
    public List<RequestSaveItemDTO> getItem(){
        List<RequestSaveItemDTO> requestSaveItemDTOList=itemService.getAllItem();
        return requestSaveItemDTOList;
    }

    @GetMapping(path = "get-all-item-by-paginate",
                params = {"page","size"})
    public PaginateResponseItemDTO getAllItemByPaginate(
            @RequestParam (value = "page" )int page,
            @RequestParam (value = "size" ) @Max(50)  int size
            ) {
        PaginateResponseItemDTO paginateResponseItemDTO =itemService.getAllItemByPaginate(page,size);
        return paginateResponseItemDTO;
    }

    @GetMapping(path = "get-item")
   public List<ResponseGetAllItemDTO> itemGet(){
        List<ResponseGetAllItemDTO> responseGetAllItemDTOS=itemService.itemGet();
        return responseGetAllItemDTOS;
    }




}

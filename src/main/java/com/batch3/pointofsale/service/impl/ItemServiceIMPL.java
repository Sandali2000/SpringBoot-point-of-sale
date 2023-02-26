package com.batch3.pointofsale.service.impl;

import com.batch3.pointofsale.dto.paginate.PaginateResponseItemDTO;
import com.batch3.pointofsale.dto.request.RequestSaveItemDTO;
import com.batch3.pointofsale.dto.response.ResponseGetAllItemDTO;
import com.batch3.pointofsale.dto.response.ResponseSaveItemDTO;
import com.batch3.pointofsale.entity.Item;
import com.batch3.pointofsale.exception.NotFoundException;
import com.batch3.pointofsale.repo.ItemRepo;
import com.batch3.pointofsale.service.ItemService;
import com.batch3.pointofsale.util.mapper.ItemMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemMapper itemMapper;


    @Override
    public ResponseSaveItemDTO addItem(RequestSaveItemDTO requestSaveItemDTO) {
    //    Item item=modelMapper.map(requestSaveItemDTO,Item.class);
        Item item=itemMapper.itemDtoToEntity(requestSaveItemDTO);
        item.setActiveState(true);
        if(!itemRepo.existsById(item.getItemId())){
         return   modelMapper.map(itemRepo.save(item),ResponseSaveItemDTO.class);
        }
        else {
            throw new KeyAlreadyExistsException("Already Exit");
        }

    }

    @Override
    public List<RequestSaveItemDTO> getAllItem() {
      List<Item> itemList = itemRepo.findAll();

      if(itemList.size()>0){
          //List<RequestSaveItemDTO> requestSaveItemDTOList=modelMapper.map(itemList ,new TypeToken<List<RequestSaveItemDTO>>(){}.getType());
          List<RequestSaveItemDTO> requestSaveItemDTOList=itemMapper.entityDtoToResponseDto(itemList);
          return requestSaveItemDTOList;
      }else
      {
         throw new NotFoundException("Not Found Any Item");
      }

    }

    @Override
    public PaginateResponseItemDTO getAllItemByPaginate(int page, int size) {
        Page<Item> items= itemRepo.findAll(PageRequest.of(page, size));
        PaginateResponseItemDTO paginateResponseItemDTO=new PaginateResponseItemDTO(
                itemMapper.pageListToDtoList(items),
                itemRepo.count()
        );

        return paginateResponseItemDTO;
    }

    @Override
    public List<ResponseGetAllItemDTO> itemGet() {
        List<Item> itemList=itemRepo.findAll();
        if (itemList.size()>0){
            //List<> requestSaveItemDTOList=itemMapper.entityDtoToResponseDto(itemList);
            //return requestSaveItemDTOList;
        }

        return null;
    }


}

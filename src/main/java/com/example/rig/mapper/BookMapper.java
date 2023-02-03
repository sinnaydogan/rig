package com.example.rig.mapper;

import com.example.rig.dto.CustomerDto;
import com.example.rig.entity.Book;
import com.example.rig.entity.Customer;
import com.example.rig.response.BookResponse;
import com.example.rig.response.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
   BookResponse entityToResponse(Book book);

}

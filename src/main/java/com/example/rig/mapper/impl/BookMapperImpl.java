package com.example.rig.mapper.impl;

import com.example.rig.entity.Book;
import com.example.rig.mapper.BookMapper;
import com.example.rig.response.BookResponse;
import org.springframework.stereotype.Service;

@Service
public class BookMapperImpl implements BookMapper {

    @Override
    public BookResponse entityToResponse(Book book) {
        if (book == null){
            return null;
        }
        BookResponse bookResponse = new BookResponse();
        bookResponse.setId(book.getId());
        bookResponse.setType(book.getType());
        bookResponse.setName(book.getName());
        bookResponse.setStock(book.getStock());
        bookResponse.setAuthor(book.getAuthor());
        bookResponse.setPrice(book.getPrice());
        return bookResponse;
    }
}

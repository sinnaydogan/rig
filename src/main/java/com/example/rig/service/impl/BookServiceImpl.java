package com.example.rig.service.impl;

import com.example.rig.dto.BookDto;
import com.example.rig.entity.Book;
import com.example.rig.mapper.BookMapper;
import com.example.rig.repository.BookRepository;
import com.example.rig.response.BookResponse;
import com.example.rig.service.BookService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookResponse save(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setAuthor(bookDto.getAuthor());
        book.setType(bookDto.getType());
        book.setPrice(bookDto.getPrice());
        book.setStock(bookDto.getStock());

        return bookMapper.entityToResponse(bookRepository.save(book));
    }

    @Override
    public BookResponse stockUpdate(Long bookId, Long stock) {
        Book book = bookRepository.getById(bookId);
        book.setStock(stock);
        return bookMapper.entityToResponse(bookRepository.save(book));
    }
}

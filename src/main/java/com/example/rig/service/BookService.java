package com.example.rig.service;

import com.example.rig.dto.BookDto;
import com.example.rig.response.BookResponse;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface BookService {
    BookResponse save(BookDto bookDto);

    BookResponse stockUpdate(Long bookId, Long stock);
}

package com.example.rig.controller;


import com.example.rig.dto.BookDto;
import com.example.rig.response.BookResponse;
import com.example.rig.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponse> save(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.save(bookDto));
    }

    @PutMapping("/stock-update/{bookId}")
    public ResponseEntity<BookResponse> stockUpdate(@PathVariable Long bookId, @RequestBody Long stock) {
        return ResponseEntity.ok(bookService.stockUpdate(bookId, stock));
    }
}

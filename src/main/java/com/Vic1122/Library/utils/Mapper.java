package com.Vic1122.Library.utils;

import com.Vic1122.Library.domain.Book;
import com.Vic1122.Library.dto.BookDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    @Autowired
    ModelMapper modelMapper;

    public BookDto convertToDto(Book book) {
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        return bookDto;
    }

    public Book convertToEntity(BookDto bookDto) {
        Book book = modelMapper.map(bookDto, Book.class);
        return book;
    }
}

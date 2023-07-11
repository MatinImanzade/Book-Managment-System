//package az.company.bookmanagmentsystem.mapper;


import az.company.bookmanagmentsystem.dto.BookDto;
import az.company.bookmanagmentsystem.dto.CreateBookRequest;
import az.company.bookmanagmentsystem.dto.UpdateBookRequest;
import az.company.bookmanagmentsystem.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//public interface BookMapper {
//    BookDto bookToBookDto(Book book);
//
//    @Mapping(target = "id",ignore = true)
//    Book createBookRequestToBook(CreateBookRequest createBookRequest);
//
//    void updateBook(@MappingTarget Book book, UpdateBookRequest updateBookRequest);
//
//}

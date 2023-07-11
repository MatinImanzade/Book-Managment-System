package az.company.bookmanagmentsystem.mapper;

import az.company.bookmanagmentsystem.dto.BookDto;
import az.company.bookmanagmentsystem.dto.CreateBookRequest;
import az.company.bookmanagmentsystem.dto.UpdateBookRequest;
import az.company.bookmanagmentsystem.model.Book;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ManualBookMapper {
    public BookDto convertToBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setName(book.getBookName());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setReleaseDate(book.getReleaseDate());
        return bookDto;
    }

    public Book convertToBook(CreateBookRequest createBookRequest) {
        Book book = new Book();
        book.setBookName(createBookRequest.getName());
        book.setAuthor(createBookRequest.getAuthor());
        book.setReleaseDate(createBookRequest.getReleaseDate());
        return book;
    }

    public void updateBook(Book book, UpdateBookRequest updateBookRequest) {
        if (updateBookRequest.getName() != null) {
            book.setBookName(updateBookRequest.getName());
        }
        if (updateBookRequest.getAuthor() != null) {
            book.setAuthor(updateBookRequest.getAuthor());
        }
        if (updateBookRequest.getReleaseDate() != null) {
            book.setReleaseDate(updateBookRequest.getReleaseDate());
        }
    }
}

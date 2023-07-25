package az.company.bookmanagmentsystem.service.inter;

import az.company.bookmanagmentsystem.dto.BookDto;
import az.company.bookmanagmentsystem.dto.CreateBookRequest;
import az.company.bookmanagmentsystem.dto.UpdateBookRequest;

import java.util.List;

public interface BookServiceInter {
    public void createBook(CreateBookRequest createBookRequest);

    public List<BookDto> getAllBooks();

    public BookDto getBookById(Long id);

    public void updateBook(Long id, UpdateBookRequest updateBookRequest);

    public void deleteBookById(Long id);

}

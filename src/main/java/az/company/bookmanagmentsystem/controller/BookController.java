package az.company.bookmanagmentsystem.controller;

import az.company.bookmanagmentsystem.dto.BookDto;
import az.company.bookmanagmentsystem.dto.CreateBookRequest;
import az.company.bookmanagmentsystem.dto.UpdateBookRequest;
import az.company.bookmanagmentsystem.service.impl.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/books")
@RequiredArgsConstructor // final deyisenler ucun parametrli konstruktor yaradir
@Validated
public class BookController {
    private final BookService bookService;

    @PostMapping("/create")
    public void createBook(@Valid @RequestBody CreateBookRequest createBookRequest) {
        bookService.createBook(createBookRequest);
    }

    @GetMapping("/all")
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody @Valid UpdateBookRequest request) {
        bookService.updateBook(id, request);
    }
    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

}

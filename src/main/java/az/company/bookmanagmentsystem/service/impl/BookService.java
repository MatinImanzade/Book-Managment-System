package az.company.bookmanagmentsystem.service.impl;


import az.company.bookmanagmentsystem.exception.BookNotFoundException;
import az.company.bookmanagmentsystem.dto.BookDto;
import az.company.bookmanagmentsystem.dto.CreateBookRequest;
import az.company.bookmanagmentsystem.dto.UpdateBookRequest;
//import az.company.bookmanagmentsystem.mapper.BookMapper;
//import az.company.bookmanagmentsystem.mapper.ManualBookMapper;
//import az.company.bookmanagmentsystem.mapper.BookMapperImpl;
import az.company.bookmanagmentsystem.mapper.ManualBookMapper;
import az.company.bookmanagmentsystem.model.Book;
import az.company.bookmanagmentsystem.repository.BookRepository;
import az.company.bookmanagmentsystem.service.inter.BookServiceInter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * burada istifade etdiyim @RequiredArgsConstructor annotationu final deyisenlere gore yazilib ve her bir final fieldi
 * ehate eden parametrli konstruktor duzeldir ve belece biz final deyisenlere neyise menimsetmek ucun her defe konstruktor yaratmiriq
 *
 * @Slf4j - bu ise lombok kitabxanasindan gelen bir ozellikdir
 */
@Service
@RequiredArgsConstructor
@Slf4j // loglama etmek ucun kitabxana
public class BookService implements BookServiceInter {
    private final BookRepository bookRepository;
    private final ManualBookMapper manualBookMapper;

    /**
     * @param createBookRequest bu metod bireded createBookRequest alaraq creatBookRequesti MapStruct vasitesiyle Book obyektine cevirir
     *                          bookRepository obyekti ise JpaRepository interfeysini extend etdiyi ucun onun daxilinde olan hazir metodlari istifa-
     *                          de ede bilir.
     */
    public void createBook(CreateBookRequest createBookRequest) {
        bookRepository.save(manualBookMapper.convertToBook(createBookRequest));
        log.info("book saved succesfully", createBookRequest);
    }

    /**
     * @return Bu method butun kitablari tapib geriye BookDto Listi seklinde donderir ,burada Stream API den istifade etmisem.
     */
    public List<BookDto> getAllBooks() {
        List<BookDto> allBooks = bookRepository.findAll()
                .stream()
                .map(manualBookMapper::convertToBookDto)
                .collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(allBooks)) {
            log.info("books fetced successfully from DB, {}", allBooks);
            return allBooks;
        }
        log.info("books not fetced from DB ,{}", allBooks);
        return allBooks;
    }

    public BookDto getBookById(Long id) {
        Book book = fetchBookFromDB(id);
        return manualBookMapper.convertToBookDto((book));
    }

    public void updateBook(Long id, UpdateBookRequest updateBookRequest) {
        Book book = fetchBookFromDB(id);
        manualBookMapper.updateBook(book, updateBookRequest);
        bookRepository.save(book);
        log.info("book update was successfully {}", book);
    }

    public void deleteBookById(Long id) {
        Book book = fetchBookFromDB(id);
        bookRepository.deleteById(book.getId());
        log.info("delete book by id {} from db", id);
    }

    private Book fetchBookFromDB(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        }
        log.error("not found book by id ,{}", id);
        throw new BookNotFoundException("book not found by id : " + id);
    }


}

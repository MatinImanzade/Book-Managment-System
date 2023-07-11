package az.company.bookmanagmentsystem.repository;


import az.company.bookmanagmentsystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

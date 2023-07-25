package az.company.bookmanagmentsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {

    @NotBlank(message = "Book name must be defined")
    private String name;

    @NotBlank(message = "Book author must be defined")
    private String author;

    @NotNull(message = "Book release date must be defined")
    private LocalDate releaseDate;

}

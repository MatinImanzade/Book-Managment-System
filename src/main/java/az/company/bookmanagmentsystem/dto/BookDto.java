package az.company.bookmanagmentsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Long id;
    private String name;
    private String author;
    private Integer releaseDate;

}

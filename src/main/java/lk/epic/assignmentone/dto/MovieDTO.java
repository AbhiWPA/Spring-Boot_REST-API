package lk.epic.assignmentone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MovieDTO {

    @NotBlank(message = "IMDB shouldn't be blank or null")
    @NotEmpty(message = "IMDB shouldn't be empty")
    @Size(min = 9, max = 9, message = "FirstName length must be between 5 and 10 characters")
    @Pattern(regexp = "^(tt)[0-9]{7}$", message = "IMDB must start at 'T' ")
    private String imdb;

    @NotBlank(message = "title shouldn't be blank or null")
    @NotEmpty(message = "title shouldn't be empty")
    private String title;

    @NotBlank(message = "description shouldn't be blank or null")
    @NotEmpty(message = "description shouldn't be empty")
    private String description;

    @Min(value = 0, message = "Rating not be less than 0")
    @Max(value = 10, message = "Rating should not be greater than 10")
    @Digits(integer = 2, fraction = 1, message = "Rating must be in this format, ex: 7.9 , 8.5")
    private double rating;

    @NotBlank(message = "category shouldn't be blank or null")
    @NotEmpty(message = "category shouldn't be empty")
    private String category;

   @Min(value = 1900, message = "Rating not be less than 0")
   @Max(value = 2023, message = "Rating not be less than 0")
    private int year;

    @NotBlank(message = "Image URL shouldn't be blank or null")
    @NotEmpty(message = "Image URL shouldn't be empty")
    private String imgUrl;
}

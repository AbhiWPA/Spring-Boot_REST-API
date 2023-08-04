package lk.epic.assignmentone.dto;

import lk.epic.assignmentone.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserDTO {

    @Email(message = "Email Should be valid")
    @NotBlank(message = "Email shouldn't be blank or null")
    @NotEmpty(message = "Email shouldn't be empty")
    private String email;

    @NotBlank(message = "FirstName shouldn't be blank or null")
    @NotEmpty(message = "FirstName shouldn't be empty")
    @Size(min = 3, max = 20, message = "FirstName length must be between 5 and 10 characters")
    private String firstname;

    @NotBlank(message = "LastName shouldn't be blank or null")
    @NotEmpty(message = "LastName shouldn't be empty")
    @Size(min = 3, max = 20, message = "LastName length must be between 5 and 10 characters")
    private String lastname;

    @NotBlank(message = "Password shouldn't be blank or null")
    @NotEmpty(message = "Password shouldn't be empty")
    @Size(min = 5, max = 10, message = "Password length must be between 5 and 10 characters")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

}

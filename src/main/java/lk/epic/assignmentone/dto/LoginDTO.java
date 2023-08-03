package lk.epic.assignmentone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class LoginDTO {

    @Email(message = "Email is not valid", regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}")
    @NotBlank(message = "Email shouldn't be blank or null")
    @NotEmpty(message = "Email shouldn't be empty")
    private String email;

    @NotBlank(message = "Password shouldn't be blank or null")
    @NotEmpty(message = "Password shouldn't be empty")
    @Size(min = 5, max = 10, message = "Password length must be between 5 and 10 characters")
    private String password;
}

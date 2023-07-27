package lk.epic.assignmentone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserDTO {

    private String email;
    private String firstname;
    private String lastname;
    private String password;


}

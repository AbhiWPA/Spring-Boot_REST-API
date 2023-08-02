package lk.epic.assignmentone.util;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUtil {
    private String code;
    private String message;
    private Object data;
}

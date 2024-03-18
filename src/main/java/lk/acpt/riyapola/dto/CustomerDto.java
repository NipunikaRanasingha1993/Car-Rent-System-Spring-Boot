package lk.acpt.riyapola.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CustomerDto {
    private Long id;
    private String name;
    private String contact;
    private String email;
    private String password;

}

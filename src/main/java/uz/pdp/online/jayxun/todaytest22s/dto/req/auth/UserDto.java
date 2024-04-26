package uz.pdp.online.jayxun.todaytest22s.dto.req.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link uz.pdp.online.jayxun.todaytest22s.entity.User}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    @Email
    String email;

    @Size(min = 6, max = 20)
    String password;
}
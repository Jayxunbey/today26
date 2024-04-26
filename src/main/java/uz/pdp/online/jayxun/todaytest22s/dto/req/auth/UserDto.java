package uz.pdp.online.jayxun.todaytest22s.dto.req.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link uz.pdp.online.jayxun.todaytest22s.entity.User}
 */
@Value
public class UserDto implements Serializable {
    @Email
    String email;

    @NotNull
    String password;
}
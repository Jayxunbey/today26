package uz.pdp.online.jayxun.todaytest22s.dto.req.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link uz.pdp.online.jayxun.todaytest22s.entity.User}
 */
@Value
public class SignUpReqDto implements Serializable {
    @Email
    String email;

    @NotNull
    String username;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",message = "password not valid")
    String password;
}
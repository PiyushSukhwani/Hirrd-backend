package com.hirrd.dto;


import com.hirrd.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String id;
    @NotBlank(message = "{user.name.absent}")
    private String name;
    @NotBlank(message = "{email.name.absent}")
    @Email(message = "{user.email.invalid}")
    private String email;
    @NotBlank(message = "{user.password.absent}")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W_])(?=.*\\d).{8,15}$", message = "{user.password.invalid}")
    private String password;
    private AccountType accountType;

    public User toEntity() {
        return new User(this.id, this.name, this.email, this.password, this.accountType);
    }
}

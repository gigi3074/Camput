package camput.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Builder
public class LoginDto {

    @NotBlank
    private String memberLoginId;
    @NotBlank
    private String memberPassword;

    @Builder
    public LoginDto(String memberLoginId, String memberPassword) {
        this.memberLoginId = memberLoginId;
        this.memberPassword = memberPassword;
    }
}

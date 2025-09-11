package za.co.jewellerysystem.domain.dto;
import lombok.Data;
public class UserDto {

    @Data
    public class SignupRequest {
        private String username;
        private String password;
    }

    @Data
    public class LoginRequest {
        private String username;
        private String password;
    }

    @Data
    public static class LoginResponse {
        private String message;
        private String username;

        public LoginResponse(String message, String username) {
            this.message = message;
            this.username = username;
        }
    }
}


package com.white.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public abstract class AuthDTO {
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class AuthLoginDTO {
        private String username;
        private String password;
    }

}

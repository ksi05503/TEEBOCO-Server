package com.teeboco.demo.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignUpRequestDTO {
    private String nickname;
    private String introduction;
}

package com.teeboco.demo.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignUpUserEntity {
    private String nickname;
    private String profileImgUrl;
    private String introduction;

}

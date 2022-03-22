package com.teeboco.demo.service;

import com.teeboco.demo.domain.base.BaseException;
import com.teeboco.demo.domain.user.SignUpRequestDTO;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    void signUp(SignUpRequestDTO signUpRequestDTO, MultipartFile mFile) throws BaseException;
}

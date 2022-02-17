package com.teeboco.demo.controller;


import com.teeboco.demo.domain.base.BaseException;
import com.teeboco.demo.domain.base.BaseResponse;
import com.teeboco.demo.domain.base.BaseResponseStatus;
import com.teeboco.demo.domain.user.SignUpRequestDTO;
import com.teeboco.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping( value = "/signup", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE} )
    BaseResponse postSignUp(@RequestPart SignUpRequestDTO signUpRequestDTO, @RequestPart MultipartFile mFile){
        try{
            userService.signUp(signUpRequestDTO,mFile);
            return new BaseResponse(BaseResponseStatus.SUCCESS);
        }catch (BaseException exception){
            return new BaseResponse(exception.getStatus());
        }
    }


}

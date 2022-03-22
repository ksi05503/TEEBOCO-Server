package com.teeboco.demo.service;

import com.teeboco.demo.domain.base.BaseException;
import com.teeboco.demo.domain.base.BaseResponseStatus;
import com.teeboco.demo.domain.user.SignUpRequestDTO;
import com.teeboco.demo.domain.user.SignUpUserEntity;
import com.teeboco.demo.repository.UserRepository;
import com.teeboco.demo.service.commons.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/*
    설계원칙
     - BaseException은 Service에서만 throw된다. 이는 controller에서 response로 사용될 것이다.
     - Repositary에서는 명시된 exception만을 throw한다. (그 외의 unexpected error는 service에서 처리한다.)
     - 에러로깅은 발생지점을 명확히 하기위해 한 프로세스에 한번 찍어준다.
     - NPE 발생 가능 지점은 무조건 boxing 하기
 */

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final S3Service s3Service;

    public void signUp(SignUpRequestDTO signUpRequestDTO, MultipartFile mFile) throws BaseException {

        //닉네임 중복체크
        if (userRepository.checkNicknameDuplication(signUpRequestDTO.getNickname()))
            throw new BaseException(BaseResponseStatus.POST_USERS_EXISTS_NICKNAME);

        //S3에 프로필 사진 업로드 & URL 추출
        String profileImgUrl;

        try{
            profileImgUrl = s3Service.upload(mFile,"user-img");
        } catch (IOException e) {
            log.error("[ERROR][IOException] signUp() upload img / message : {}" , e.getMessage());
            throw new BaseException(BaseResponseStatus.SIGNUP_FAILED_TO_UPLOAD_PROFILE);
        }

        //DB에 유저 엔티티 insert
        try{
            SignUpUserEntity signUpUserEntity = new SignUpUserEntity(signUpRequestDTO.getNickname(),profileImgUrl,signUpRequestDTO.getIntroduction());
            userRepository.postUser(signUpUserEntity);
        } catch (NullPointerException e){
            log.error("[ERROR][NullPointerException] signUp() post db user entity failed / message : {}",e.getMessage());
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }

}

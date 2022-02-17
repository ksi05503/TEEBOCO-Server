package com.teeboco.demo.domain.base;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {
    /**
     * 1000 : 요청 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다."),



    /**
     * 2000 : Request 오류
     */
    // Common
    EMPTY_NICKNAME(false, 2004, "닉네임을 입력해주세요"),
    REQUEST_ERROR(false, 2000, "입력값을 확인해주세요."),
    EMPTY_ACCESS_JWT(false, 2001, "Access 토큰을 입력해주세요."),
    EMPTY_REFRESH_JWT(false, 2002, "Refresh 토큰을 입력해주세요."),
    INVALID_ACCESS_JWT(false, 2003, "지원되지 않거나 잘못된 Access 토큰 입니다."),
    INVALID_REFRESH_JWT(false, 2012, "지원되지 않거나 잘못된 Refresh 토큰 입니다."),
    INVALID_USER_ACCESS_JWT(false,2005,"Access 토큰의 userIdx와 Request의 userIdx가 일치하지 않습니다."),
    NOT_EXIST_REFRESH_JWT(false,2006,"존재하지 않거나 만료된 Refresh 토큰입니다. 다시 로그인해주세요."),
    EXPIRED_ACCESS_JWT(false,2007,"만료된 Access 토큰입니다. Refresh 토큰을 이용해서 새로운 Access 토큰을 발급 받으세요."),
    EXPIRED_REFRESH_JWT(false,2008,"만료된 Refresh 토큰입니다. 다시 로그인해주세요."),
    EMPTY_USER_IDX(false,2009,"유저 인덱스를 입력해주세요."),
    REFRESH_TOKEN_DELETE_FAIL(false, 2011, "이미 Refresh 토큰이 존재하지 않아서, Refresh 토큰 삭제에 실패했습니다."),
    LOGOUT_SUCCESS(true, 1000, "로그아웃했습니다. 안드로이드의 jwtAccessToken과 jwtRefreshToken을 삭제해주세요."),

    // users
    USERS_EMPTY_USER_ID(false, 2010, "유저 아이디 값을 확인해주세요."),
    INVALID_USER_ID(false, 2014, "존재하지 않는 유저 인덱스입니다."),

    // [POST] /users
    POST_USERS_EMPTY_EMAIL(false, 2015, "이메일을 입력해주세요."),
    POST_USERS_INVALID_EMAIL(false, 2016, "이메일 형식을 확인해주세요."),
    POST_USERS_EXISTS_EMAIL(false,2017,"중복된 이메일입니다."),
    POST_USERS_EXISTS_NICKNAME(false,2017,"중복된 닉네임입니다."),



    /**
     * 3000 : Response 오류
     */
    // Common
    RESPONSE_ERROR(false, 3000, "값을 불러오는데 실패하였습니다."),

    // [POST] /users
    DUPLICATED_EMAIL(false, 3013, "중복된 이메일입니다."),
    FAILED_TO_LOGIN(false,3014,"없는 아이디거나 비밀번호가 틀렸습니다."),



    /**
     * 4000 : Database, Server 오류
     */
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다."),
    SERVER_ERROR(false, 4001, "서버와의 연결에 실패하였습니다."),

    //[PATCH] /users/{userIdx}
    MODIFY_FAIL_USERNAME(false,4014,"유저네임 수정 실패"),

    PASSWORD_ENCRYPTION_ERROR(false, 4011, "비밀번호 암호화에 실패하였습니다."),
    PASSWORD_DECRYPTION_ERROR(false, 4012, "비밀번호 복호화에 실패하였습니다."),

    // 5000 : 필요시 만들어서 쓰세요
    /**
     * signup
     */
    SIGNUP_FAILED_TO_UPLOAD_PROFILE(false, 5000, "사용자 프로필 이미지 업로드에 실패하였습니다."),
    SIGNUP_EMPTY_USER_BIRTHDATE(false, 5001, "생년월일을 입력해주세요."),
    EMPTY_USER_PHONENUM(false, 5002, "휴대폰 번호를 입력해주세요."),
    SIGNUP_EMPTY_USER_NICKNAME(false, 5003, "닉네임을 입력해주세요."),
    SIGNUP_INVALID_FORM_USER_BIRTHDATE(false, 5004, "####-##-## 형태로 생년월일을 입력해주세요."),
    SIGNUP_INVALID_USER_BIRTHDATE(false, 5004, "오늘 또는 오늘 이전의 생년월일을 입력해주세요."),
    SIGNUP_INVALID_USER_GENDER(false, 5005, "올바르지 않은 성별 값입니다. 1(남자) 또는 2(여자)를 입력해주세요."),
    INVALID_USER_PHONENUM(false, 5006, "올바르지 않은 휴대폰 번호입니다. 숫자만 입력해주세요."),
    SIGNUP_EMPTY_USER_GENDER(false, 5007, "성별을 입력해주세요."),
    SIGNUP_EMPTY_USER_LOCATION(false, 5008, "활동 지역 번호를 입력해주세요."),
    SIGNUP_EMPTY_USER_EXPER(false, 5009, "활동 구력 번호를 입력해주세요."),
    SIGNUP_INVALID_USER_EXPER(false, 5009, "올바르지 않은 활동 구력 번호입니다. 1~14 사이의 번호를 입력해주세요."),
    SIGNUP_INVALID_USER_LOCATION(false, 5010, "올바르지 않은 활동 지역 번호입니다. 1~261 사이의 번호를 입력해주세요."),
    REDIS_ERROR(false,5011, "인증번호 발급 횟수를 초과했습니다. 인증번호는 하루 최대 5번까지 발급 가능합니다."),
    SMS_ERROR(false, 5012, "SMS 문자 전송에 실패했습니다."),
    SIGNUP_ALREADY_EXIST_PHONENUM(false, 5013, "이미 가입된 전화번호입니다.홈화면에서 로그인버튼을 클릭해주세요."),
    SIGNUP_ALREADY_EXIST_NICKNAME(false, 5014, "이미 존재하는 닉네임입니다."),
    EMPTY_AUTH_NUM(false, 5015, "인증번호를 입력해주세요."),
    INVALID_AUTH_NUM(false, 5016, "올바르지 않은 인증번호입니다. 6자리 숫자만 입력해주세요."),
    INCORRECT_AUTH_NUM(false, 5017, "일치하지 않는 인증번호입니다."),
    NOT_EXIST_AUTH_NUM(false, 5018, "해당 휴대폰 번호로 발급받은 인증번호가 없습니다."),
    LOGIN_NOT_EXIST_PHONENUM(false, 5019, "가입되지 않은 번호입니다. 홈화면에서 시작하기를 통해 회원가입 해주세요."),
    NOT_EXIST_USER(false, 5020, "로그인에 실패했습니다. 존재하지 않는 사용자입니다."),
    NOT_EXIST_USER_IDX(false, 5021, "존재하지 않는 유저 인덱스입니다."),
    SIGNUP_INVALID_USER_NICKNAME(false, 5022, "닉네임은 영어 또는 한글과 숫자를 조합한 2-10 자리만 가능합니다."),
    SIGNUP_EMPTY_USER_PROFILE(false, 5023, "프로필 사진을 입력해주세요."),
    SIGNUP_EMPTY_USER_INTRO(false, 5024, "자기소개를 입력해주세요."),
    SIGNUP_INVALID_SIZE_INTRO(false, 5025, "자기소개는 5자 이상 400자 이하로 입력해주세요."),
    SIGNUP_INVALID_USER_PROFILE(false, 5025, "유효하지 않은 프로필 사진입니다."),
    ALREADY_EXIST_PHONENUM(false, 5026, "이미 사용중인 휴대폰 번호입니다."),
    EMPTY_FCM_TOKEN(false, 5027, "FCM 토큰을 입력해주세요");

    private final boolean isSuccess;
    private final int code;
    private final String message;

    BaseResponseStatus(boolean isSuccess, int code, String message) { //BaseResponseStatus 에서 각 해당하는 코드를 생성자로 맵핑
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

    public static BaseResponseStatus of(final String errorName){
        // valueOf : 이름을 가지고 객체르 가져오는 함수
        return BaseResponseStatus.valueOf(errorName);
    }
}

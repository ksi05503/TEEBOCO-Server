# TEEBOCO Server


## [0] 설계 원칙 (추가중) 

>
     - BaseException은 Service에서만 throw된다. 이는 controller에서 response로 사용될 것이다.
     - Repositary에서는 명시된 exception만을 throw한다. (그 외의 unexpected error는 service에서 처리한다.)
     - 에러로깅은 발생지점을 명확히 하기위해 한 프로세스에 한번 찍어준다.
     - NPE 발생 가능 지점은 무조건 boxing 하기
     - Service 코드에서 분리된 필요한 도구함수(?)들은 아래에 private 으로 작성
     - 테스트 친화적으로 코드 작성 (검증 가능한 코드)
     - TDD 에 따른다.
     - mockito 를 이용하여 SpringBootTest 가 아닌, 스프링에 독립된 테스트 코드 작성


## [1] 유저정보 관리 flow
**[기능]**
- 회원가입 및 회원삭제
- 회원정보 수정 및 프로필 사진 수정

**[사용기술]** 
- *S3 버킷* : 프로필 사진 관리

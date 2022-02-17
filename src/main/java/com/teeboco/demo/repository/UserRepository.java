package com.teeboco.demo.repository;

import com.teeboco.demo.domain.user.SignUpUserEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Objects;

@Log4j2
@Repository
public class UserRepository {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int postUser(SignUpUserEntity signUpUserEntity) {
        String postUserQuery =
                        "INSERT User\n" +
                        "SET nickname = ?,profileImgUrl=? ,introduction = ?";
        Object[] params = {signUpUserEntity.getNickname(),signUpUserEntity.getProfileImgUrl() ,signUpUserEntity.getIntroduction()};
        jdbcTemplate.update(postUserQuery, params);


        // 생성된 유저 인덱스 반환
        int userIdx = getLastIndex();
        log.info("postUserSuccess: new userIdx = {} ",userIdx);
        return userIdx;
    }

    private int getLastIndex() {
        String getLastIndexQuery =
                "SELECT LAST_INSERT_ID()";

        //  return jdbcTemplate.queryForObject(getLastIndexQuery, int.class);
        return Objects.requireNonNull(jdbcTemplate.queryForObject(getLastIndexQuery, int.class));

    }

    public boolean checkNicknameDuplication(String nickname){
        String checkNicknameDuplicationQuery = "SELECT exists(select nickname from User where nickname = ?)";

        String param = nickname;

    //  return jdbcTemplate.queryForObject(checkNicknameDuplicationQuery, boolean.class);
        return Objects.requireNonNull(jdbcTemplate.queryForObject(checkNicknameDuplicationQuery, boolean.class, param));

    }

}

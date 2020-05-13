package com.app.api.domain.user.support;

import com.app.api.domain.user.User;
import com.app.api.web.dto.LoginResponseDto;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.UserRespoenseDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserSupport {

    Optional<Long> update(long id, UserRespoenseDto dto);

    Optional<User> findByUser(LoginResponseDto dto);

    Page<User> findByUsers(List<String> roleTitles , PageableDto dto);

    User findByEmail(String email);

}
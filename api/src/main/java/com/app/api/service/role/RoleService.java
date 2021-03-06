package com.app.api.service.role;


import com.app.api.domain.role.Role;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.RoleDto;
import org.springframework.data.domain.Page;

public interface RoleService {

    Page<Role> getPages (PageableDto dto);

    void createRole (RoleDto dto);

    void modifyRole( long seq , RoleDto dto);

    void removeRole(long seq);

    Role getRole(long seq);

}

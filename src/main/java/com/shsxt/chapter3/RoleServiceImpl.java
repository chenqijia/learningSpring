package com.shsxt.chapter3;

import com.shsxt.chapter.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class RoleServiceImpl implements RoleService {
    @Override
    public void printRole(Role role) {
        System.out.println("id: " + role.getId() + "," + "role_name:" + role.getRoleName() + "," + "note:" + role.getNote() + "}");
    }
}

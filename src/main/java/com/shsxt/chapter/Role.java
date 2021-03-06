package com.shsxt.chapter;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="role") //表示会把这个扫描入Bean实例
public class Role {
    @Value("1") //注入值
    private Long id;
    @Value("role_name")
    private String roleName;
    @Value("role_note")
    private String note;

    public Role() {

    }

    public Role(Long id, String roleName, String note) {
        this.id = id;
        this.roleName = roleName;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}

package com.shsxt.chapter;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserRoleAssembly {
    private long id;
    private List<Role> list;
    private Map<Role,User> map;
    private Set<Role> set;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UserRoleAssembly{" +
                "id=" + id +
                ", list=" + list +
                ", map=" + map +
                ", set=" + set +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Role> getList() {
        return list;
    }

    public void setList(List<Role> list) {
        this.list = list;
    }

    public Map<Role, User> getMap() {
        return map;
    }

    public void setMap(Map<Role, User> map) {
        this.map = map;
    }

    public Set<Role> getSet() {
        return set;
    }

    public void setSet(Set<Role> set) {
        this.set = set;
    }
}

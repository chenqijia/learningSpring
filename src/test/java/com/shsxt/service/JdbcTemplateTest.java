package com.shsxt.service;

import com.shsxt.chapter.Role;
import com.shsxt.mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateTest {
    @Test
    public void jdbcTemplateTest()
    {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate=ctx.getBean(JdbcTemplate.class);
        Long id=1L;


        String sql="select id,role_name,note from t_role where id= "+id;
        Role role=jdbcTemplate.queryForObject(sql, new RowMapper<Role>() {
            @Override
            public Role mapRow(ResultSet resultSet, int i) throws SQLException {
                Role result=new Role();
                result.setId(resultSet.getLong("id"));
                result.setRoleName(resultSet.getString("role_name"));
                result.setNote(resultSet.getString("note"));
                return result;
            }
        });
        System.out.println(role);
    }
    @Test
    public void Test01()
    {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate=ctx.getBean(JdbcTemplate.class);
        JdbcTemplateTest test=new JdbcTemplateTest();
        //插入一个角色
        test.insertRole(jdbcTemplate);
        //查询角色的列表
        List<Role> roleList=test.findRole(jdbcTemplate,"role");
        System.out.println(roleList.size());
        Role role=new Role();
        role.setId(1L);
        role.setRoleName("update_role_name_1");
        role.setNote("update_role_note");
        test.updateRole(jdbcTemplate,role);
        String sql="select id,role_name,note from t_role where id= "+1L;
        Role role1=jdbcTemplate.queryForObject(sql, new RowMapper<Role>() {
            @Override
            public Role mapRow(ResultSet resultSet, int i) throws SQLException {
                Role result=new Role();
                result.setId(resultSet.getLong("id"));
                result.setRoleName(resultSet.getString("role_name"));
                result.setNote(resultSet.getString("note"));
                return result;
            }
        });

        System.out.println(role1);
        test.deleteRole(jdbcTemplate,1L);

    }

    public int deleteRole(JdbcTemplate jdbcTemplate,Long id)
    {
        String sql="delete from t_role where id=?";
        return jdbcTemplate.update(sql,id);
    }



    private int updateRole(JdbcTemplate jdbcTemplate, Role role) {
        String sql="update t_role set role_name=?,note=? where id=?";
        return jdbcTemplate.update(sql,role.getRoleName(),role.getNote(),role.getId());
    }

    /**
     * 查询角色的列表
     * @param jdbcTemplate
     * @param role
     * @return
     */
    private List<Role> findRole(JdbcTemplate jdbcTemplate, String roleName) {
        String sql="select id,role_name,note from t_role where role_name like concat('%',?,'%')";
        Object[] params={roleName};
        List<Role> list=jdbcTemplate.query(sql,params, new RowMapper<Role>() {
            @Override
            public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
                Role result = new Role();
                result.setId(rs.getLong("id"));
                result.setRoleName(rs.getString("role_name"));
                result.setNote(rs.getString("note"));
                return result;
            }
        });
        return list;
    }

    /**
     * 插入角色
     * @param jdbcTemplate
     * @return 条数
     */
    private int insertRole(JdbcTemplate jdbcTemplate) {
        String roleName="role_name_1";
        String note="note_1";
        String sql="insert into t_role(role_name,note) values (?,?)";
        return jdbcTemplate.update(sql,roleName,note);
    }

    @Test
    public void test02(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
        SqlSessionTemplate sqlSessionTemplate=ctx.getBean(SqlSessionTemplate.class);
        Role role=new Role();
        role.setRoleName("role_name_sqlSessionTemplate");
        role.setNote("note_sqlSessionTemplate");
        sqlSessionTemplate.insert("com.shsxt.mapper.RoleMapper.insertRole",role);
        Long id=2L;
        sqlSessionTemplate.selectOne("com.shsxt.mapper.RoleMapper.getRole",id);
        role.setNote("update_sqlSessionTemplate");
        sqlSessionTemplate.update("com.shsxt.mapper.RoleMapper.updateRole",role);
        sqlSessionTemplate.delete("com.shsxt.mapper.RoleMapper.deleteRole",id);
    }

    @Test
    public void test03(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
        RoleMapper roleMapper=ctx.getBean(RoleMapper.class);
        Role role=new Role();
        role.setRoleName("role_name_mapper");
        role.setNote("note_mapper");
        roleMapper.insertRole(role);
        Long id=role.getId()-1;
        roleMapper.getRole(id);
        role.setNote("note_mapper_update");
        roleMapper.updateRole(role);
        roleMapper.deleteRole(id);
    }
}

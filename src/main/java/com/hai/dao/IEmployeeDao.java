package com.hai.dao;

import com.hai.dao.sqlprovider.EmployeeSqlProvider;
import com.hai.model.Employee;
import com.hai.model.example.EmployeeExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface IEmployeeDao {
    @SelectProvider(type=EmployeeSqlProvider.class, method="countByExample")
    long countByExample(EmployeeExample example);

    @DeleteProvider(type=EmployeeSqlProvider.class, method="deleteByExample")
    int deleteByExample(EmployeeExample example);

    @Delete({
        "delete from employee",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into employee (id, age, ",
        "name)",
        "values (#{id,jdbcType=INTEGER}, #{age,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR})"
    })
    int insert(Employee record);

    @InsertProvider(type=EmployeeSqlProvider.class, method="insertSelective")
    int insertSelective(Employee record);

    @SelectProvider(type=EmployeeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Employee> selectByExample(EmployeeExample example);

    @Select({
        "select",
        "id, age, name",
        "from employee",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Employee selectByPrimaryKey(Integer id);

    @UpdateProvider(type=EmployeeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    @UpdateProvider(type=EmployeeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    @UpdateProvider(type=EmployeeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Employee record);

    @Update({
        "update employee",
        "set age = #{age,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Employee record);
}
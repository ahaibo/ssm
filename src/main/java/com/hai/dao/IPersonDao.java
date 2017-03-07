package com.hai.dao;

import com.hai.model.Person;
import com.hai.model.PersonExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface IPersonDao {
    @SelectProvider(type=PersonSqlProvider.class, method="countByExample")
    long countByExample(PersonExample example);

    @DeleteProvider(type=PersonSqlProvider.class, method="deleteByExample")
    int deleteByExample(PersonExample example);

    @Delete({
        "delete from person",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into person (id, name, ",
        "sex, age, mobile, ",
        "hobby, status)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER}, #{mobile,jdbcType=VARCHAR}, ",
        "#{hobby,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER})"
    })
    int insert(Person record);

    @InsertProvider(type=PersonSqlProvider.class, method="insertSelective")
    int insertSelective(Person record);

    @SelectProvider(type=PersonSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="hobby", property="hobby", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<Person> selectByExample(PersonExample example);

    @Select({
        "select",
        "id, name, sex, age, mobile, hobby, status",
        "from person",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="hobby", property="hobby", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    Person selectByPrimaryKey(Integer id);

    @UpdateProvider(type=PersonSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Person record, @Param("example") PersonExample example);

    @UpdateProvider(type=PersonSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Person record, @Param("example") PersonExample example);

    @UpdateProvider(type=PersonSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Person record);

    @Update({
        "update person",
        "set name = #{name,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "hobby = #{hobby,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Person record);
}
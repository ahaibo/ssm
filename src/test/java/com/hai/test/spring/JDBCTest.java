package com.hai.test.spring;

import com.hai.test.common.BaseTest;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by as on 2017/3/8.
 */
public class JDBCTest extends BaseTest {

    @Resource
    private DataSource dataSource;

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    public void testDatasource() {
        assertThat(dataSource, notNullValue());
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            assertThat(connection, notNullValue());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != connection) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testJDBCTemplate() {
        assertThat(jdbcTemplate, notNullValue());
        System.out.println("jdbc.maxRows: " + jdbcTemplate.getMaxRows());
        System.out.println("jdbc.queryTimeout: " + jdbcTemplate.getQueryTimeout());
        System.out.println("jdbc.fetchSize: " + jdbcTemplate.getFetchSize());
    }

    @Test
    public void testNamedParameterJdbcTemplate() {
        assertThat(namedParameterJdbcTemplate, notNullValue());
        System.out.println("namedParameterJdbcTemplate.cacheLimit: " + namedParameterJdbcTemplate.getCacheLimit());
        jsonToString("JdbcOperations:\n", namedParameterJdbcTemplate.getJdbcOperations());
    }
}

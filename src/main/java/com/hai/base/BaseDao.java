package com.hai.base;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by as on 2017/3/6.
 */
@Component
public class BaseDao {

    protected Logger logger = Logger.getLogger(BaseDao.class);

    @Autowired
    protected SqlSessionFactory sqlSessionFactory;

}

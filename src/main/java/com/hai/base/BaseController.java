package com.hai.base;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

/**
 * Created by as on 2017/3/8.
 */
public class BaseController {
    protected Logger logger = Logger.getLogger(BaseController.class);

    protected String toJsonString(Object obj) {
        return null == obj ? "" : JSONObject.toJSONString(obj);
    }

    protected void print(Object obj) {
        System.out.println(toJsonString(obj));
    }
}

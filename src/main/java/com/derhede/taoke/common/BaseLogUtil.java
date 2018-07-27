package com.derhede.taoke.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by alipc on 2017/9/12.
 */
public class BaseLogUtil {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 获取当前运行代码的类名、方法名、行号
     * @return
     */
    protected String getTraceInfo() {
        StringBuffer sb = new StringBuffer();
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        sb.append("class: ").append(stacks[1].getClassName())
                .append("; method: ").append(stacks[1].getMethodName())
                .append("; number: ").append(stacks[1].getLineNumber());

        return sb.toString();
    }
}

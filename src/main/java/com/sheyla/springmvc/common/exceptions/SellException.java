package com.sheyla.springmvc.common.exceptions;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/24 23:35
 * @Modified By：
 */
public class SellException extends RuntimeException {

    public SellException(int code, String desc) {
        super(desc);
    }
}

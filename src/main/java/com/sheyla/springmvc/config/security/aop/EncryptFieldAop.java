package com.sheyla.springmvc.config.security.aop;

import com.sheyla.springmvc.config.security.EncryptField;
import com.sheyla.springmvc.config.security.utils.AseUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Objects;


/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/10 1:14
 * @Modified By：
 * @Description:
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Aspect
@Component
public class EncryptFieldAop {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Value("${secretkey}")
    private String secretKey;

    @Pointcut("@annotation(com.sheyla.springmvc.config.security.EncryptMethod)")
    public void annotationPointCut() {
    }

    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object responseObj = null;
        try {
            Object requestObj = joinPoint.getArgs()[0];
            handleEncrypt(requestObj);
            responseObj = joinPoint.proceed();
            handleDecrypt(responseObj);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            log.error("SecureFieldAop处理出现异常{}", e);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.error("SecureFieldAop处理出现异常{}", throwable);
        }
        return responseObj;
    }

    /**
     * 处理加密
     *
     * @param requestObj
     */
    private void handleEncrypt(Object requestObj) throws IllegalAccessException {
        if (Objects.isNull(requestObj)) {
            return;
        }
        Field[] fields = requestObj.getClass().getDeclaredFields();
        for (Field field : fields) {
            boolean hasSecureField = field.isAnnotationPresent(EncryptField.class);
            if (hasSecureField) {
                field.setAccessible(true);
                String plaintextValue = (String) field.get(requestObj);
                String encryptValue = AseUtil.encrypt(plaintextValue, secretKey);
                field.set(requestObj, encryptValue);
            }
        }
    }


    /**
     * 处理解密
     *
     * @param responseObj
     */
    private Object handleDecrypt(Object responseObj) throws IllegalAccessException {
        if (Objects.isNull(responseObj)) {
            return null;
        }

        Field[] fields = responseObj.getClass().getDeclaredFields();
        for (Field field : fields) {
            boolean hasSecureField = field.isAnnotationPresent(EncryptField.class);
            if (hasSecureField) {
                field.setAccessible(true);
                String encryptValue = (String) field.get(responseObj);
                String plaintextValue = AseUtil.decrypt(encryptValue, secretKey);
                field.set(responseObj, plaintextValue);
            }
        }
        return responseObj;
    }
}

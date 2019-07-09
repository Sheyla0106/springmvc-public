package com.sheyla.springmvc.config.security.service;

import com.sheyla.springmvc.config.security.EncryptMethod;
import com.sheyla.springmvc.config.security.bean.DecryptRequest;
import com.sheyla.springmvc.config.security.bean.DecryptResponse;
import com.sheyla.springmvc.config.security.bean.EncryptRequest;
import com.sheyla.springmvc.config.security.bean.EncryptResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/10 1:17
 * @Modified By：
 * @Description:
 */
@Service
public class TestServiceImpl implements TestService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @EncryptMethod
    @Override
    public EncryptResponse testEncrypt(EncryptRequest request) {
        logger.info("testEncrypt 业务逻辑入参 request:{}", request.toString());
        return null;
    }

    @Override
    @EncryptMethod
    public DecryptResponse testDecrypt(DecryptRequest request) {
        logger.info("testDecrypt  业务逻辑入参 request:{}", request.toString());

        DecryptResponse response = new DecryptResponse();
        BeanUtils.copyProperties(request, response);
        return response;
    }
}

package com.sheyla.springmvc.config.security.service;

import com.sheyla.springmvc.config.security.bean.DecryptRequest;
import com.sheyla.springmvc.config.security.bean.DecryptResponse;
import com.sheyla.springmvc.config.security.bean.EncryptRequest;
import com.sheyla.springmvc.config.security.bean.EncryptResponse;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/10 1:17
 * @Modified By：
 * @Description:
 */
public interface TestService {

    EncryptResponse testEncrypt(EncryptRequest request);

    DecryptResponse testDecrypt(DecryptRequest request);
}

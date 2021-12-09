package com.nowcoder.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @author xh
 * @create 2021-12-07 20:00
 */
public class CommunityUtil {

    // 生成随机字符串，用于激活码、图片文件名
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    // MD5加密，只能加密不能解密
    // 并且给原始密码加上随机字符串后，再加密，提高安全性，key = 元素密码 + 随机字符串
    public static String md5(String key) {
        // null或空字符串，或仅有空格，都认为是空的(blank)
        if(StringUtils.isBlank(key)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }


}

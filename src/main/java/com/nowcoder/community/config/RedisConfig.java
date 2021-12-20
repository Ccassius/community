package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author xh
 * @create 2021-12-20 10:20
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory);

        // 设置 key 序列化方式
        template.setKeySerializer(RedisSerializer.string());

        // 设置 value 序列化方式
        template.setValueSerializer(RedisSerializer.json());

        // 设置 hash 的 key 的序列化方式
        template.setHashKeySerializer(RedisSerializer.string());

        // 设置 hash 的 value 的序列化方式
        template.setValueSerializer(RedisSerializer.json());

        // 使生效
        template.afterPropertiesSet();
        return template;
    }

}

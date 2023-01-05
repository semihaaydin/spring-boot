package com.saydin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.cache.annotation.EnableCaching;

@Configuration
@EnableCaching
public class AppConfig {
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        //redise connection olmak için kullanırız. ßpring bizim için bir implementasyon oluşturdu.
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("localhost", 6379);
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    public RedisTemplate redisTemplate() {
        //bu cachleri getirmemizi veya silmemiz için gerekli yapıları veririr.
        //collectionlar içerisinde veri yakalamamızı sağlar.
        RedisTemplate template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}

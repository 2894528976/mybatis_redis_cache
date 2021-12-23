package demo.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
@Slf4j
public class RedisConfig {
    AtomicInteger atomicInteger = new AtomicInteger(16);
    @Bean("redistp")
    @Lazy
    //多例 每个mapper 需要一个redis数据胡库
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();
        LettuceConnectionFactory connection = (LettuceConnectionFactory) redisConnectionFactory;
        int i = atomicInteger.decrementAndGet();
        connection.setDatabase(i);
        log.info("create new redis connection, id is:"+i);
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        connection.afterPropertiesSet();
        connection.resetConnection();
        //json占用内存相对较低
        redisTemplate.setKeySerializer(new GenericFastJsonRedisSerializer());
        redisTemplate.setValueSerializer(new GenericFastJsonRedisSerializer());
        return redisTemplate;
    }
}

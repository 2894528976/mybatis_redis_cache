package demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }
//    @Autowired
//    RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();
//    @Test
//    public void RedisTemplateOperationRedis(){
//        redisTemplate.delete("aa");
//        //boundValueOps 方法直接添加
//        BoundValueOperations<Object, Object> key =
//                redisTemplate.boundValueOps("key");
//        key.set("value");
//        //opsForValue 方法直接添加
//        ValueOperations<Object, Object> objectObjectValueOperations =
//                redisTemplate.opsForValue();
//        objectObjectValueOperations.set("k","v");
//    }

}

package demo.config;

import demo.service.ApplicationContentHolder;
import org.apache.ibatis.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;


import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 每一个映射文件对以一个cache对象
 *
 */
public class RedisCache implements Cache{
    RedisTemplate<Object,Object> redisTemplate;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final String id;

    public RedisCache(String id) {
        if (id==null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }
    @Override
    public String getId() {

        return id;
    }

    @Override
    public void putObject(Object o, Object o1) {

        ValueOperations<Object, Object> stringObjectValueOperations = getRedisTemplate().opsForValue();
        stringObjectValueOperations.set(o,o1);

    }

    @Override
    public Object getObject(Object o) {
        ValueOperations<Object, Object> stringObjectValueOperations = getRedisTemplate().opsForValue();
        Object o1 = stringObjectValueOperations.get(o);
        return o1;
    }

    @Override
    public Object removeObject(Object o) {


        return getRedisTemplate().delete(o);
    }

    @Override
    public void clear() {
        getRedisTemplate().execute((RedisCallback) connection->{
           connection.flushDb();
           return null;
        });
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return  readWriteLock;
    }

    public RedisTemplate<Object, Object> getRedisTemplate() {
        if (redisTemplate==null){
            Random random = new Random();
            int i = random.nextInt(10);
            System.out.println(id+":缓存选择了:" +i);
            redisTemplate =ApplicationContentHolder.getBean("redistp");
        }
         return redisTemplate;
    }
}

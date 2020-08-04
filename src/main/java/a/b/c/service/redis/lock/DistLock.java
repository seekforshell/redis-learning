package a.b.c.service.redis.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

/**
 * Description:
 *
 * @author: renfei
 * Version: 1.0
 * Create Date Time: 2020-08-03 15:43.
 */
@Slf4j
public class DistLock implements IDistLock{

    private String lockKey;

    private JedisCluster redisCluster;
    private final String OK = "OK";;


    @Override
    public String newLock(JedisCluster redisCluster) {
        if (null  == redisCluster) {

            throw new IllegalArgumentException("illegal argument  ");
        }

        this.redisCluster = redisCluster;
        lockKey = String.format("redis-lock-%s", System.currentTimeMillis());

        return lockKey;
    }

    @Override
    public boolean lock(String requestId, Integer expireTime) {
        Assert.notNull(requestId, "request id is required");

        String success = "";
        try {
            SetParams params = new SetParams();
            params.nx().px(expireTime);
            success = redisCluster.set(lockKey, requestId, params);
            log.info("result:{}", success);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return OK.equalsIgnoreCase(success);
    }

    @Override
    public boolean unlock(String requestId, Integer expireTime) {
        boolean success = false;
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        try {
            Object result = redisCluster.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
            log.info("result:{}", result);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return true;
    }
}

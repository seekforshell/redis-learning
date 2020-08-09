package a.b.c.service.redis;

import org.springframework.util.Assert;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.params.ZAddParams;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Description:
 *
 * @author: renfei
 * Version: 1.0
 * Create Date Time: 2020-08-04 14:35.
 */
public class RedisBasicServiceImpl implements IRedisBasicService {

    private JedisCluster jedisCluster = JedisConFactory.getConnection();

    @Override
    public void set(String key, String value, Integer nx, Integer px, Integer xx) {

    }

    @Override
    public List<String> lrange(String key, Long start, Long end) {
        Assert.notNull(key, "key is required");
        try {
            return jedisCluster.lrange(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add2List(List<String> elements, String key, Integer direction) {

    }

    @Override
    public String lindex(String key, Long index) {
        return jedisCluster.lindex(key, index);
    }

    @Override
    public void lpush(String key, String... value) {
        jedisCluster.lpush(key, value);
    }

    @Override
    public String lpop(String key) {
        return jedisCluster.lpop(key);
    }

    @Override
    public String brpop(Long timeout, String... key) {
        return null;
    }

    @Override
    public String blpop(Long timeout, String... key) {
        return null;
    }

    @Override
    public String rpoplpush(String src, String dest) {
        String result = jedisCluster.rpoplpush(src, dest);
        return result;
    }

    @Override
    public String brpoplpush(String src, String dest, Integer timeout) {
        String result = jedisCluster.brpoplpush(src, dest, timeout);
        return result;
    }

    @Override
    public Long lrem(String key, Integer count, String value) {
        Long num = jedisCluster.lrem(key, count, value);
        return num;
    }

    @Override
    public String hmset(String key, Map<String, String> kvs) {
        String success = jedisCluster.hmset(key, kvs);
        return success;
    }

    @Override
    public List<String> hmget(String key, String... property) {
        List<String> propertyList = jedisCluster.hmget(key, property);
        return propertyList;
    }

    @Override
    public Long sadd(String key, String... elements) {
        Long count = jedisCluster.sadd(key, elements);
        return count;
    }

    @Override
    public Long zadd(String key, Double score, String value) {
        ZAddParams zAddParams = new ZAddParams();
        // not update, but add
        zAddParams.nx();
        Long count = jedisCluster.zadd(key, score, value, zAddParams);
        return count;
    }

    @Override
    public Set<String> zrangebylex(String key, String start, String end) {
        if (null == start || null == end) {
            throw new IllegalArgumentException("start or end is null");
        }

        if ((!start.startsWith("(") && !start.startsWith("[")) ||
                (!end.startsWith("(") && !end.startsWith("["))) {
            throw new IllegalArgumentException("start or end should begin with '(' or '['");
        }

        Set<String> eles = jedisCluster.zrangeByLex(key, start, end);
        return eles;
    }
}

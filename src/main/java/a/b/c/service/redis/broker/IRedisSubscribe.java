package a.b.c.service.redis.broker;

/**
 * Description:
 *
 * @author: renfei
 * Version: 1.0
 * Create Date Time: 2020-08-03 16:41.
 */
public interface IRedisSubscribe {
    /**
     * 阻塞方法
     * @param key
     */
    void subscribe(String key);
}

package a.b.c.service.redis;

import java.util.List;
import java.util.Map;

/**
 * Description: 实现了redis的基本数据类型的相关操作
 *
 * @author:
 * Version: 1.0
 * Create Date Time: 2020-08-04 13:59.
 */
public interface IRedisBasicService {

    void set(String key, String value, Integer nx, Integer px, Integer xx);

    /**
     * 列表相关操作
     * @param key
     * @param start
     * @param end
     */
    List<String> lrange(String key, Long start, Long end);

    /**
     * 将元素加入到队列中去
     * @param elements
     * @param key
     * @param direction: 0:尾部插入 1:头部插入
     */
    void add2List(List<String> elements, String key, Integer direction);


    /**
     * 从列表指定位置取数据
     */
    String lindex(String key, Long index);

    /**
     * 插入元素
     * @param key
     * @param value
     */
    void lpush(String key, String... value);

    /**
     * 取出元素
     * @param key
     * @return
     */
    String lpop(String key);

    /**
     * 阻塞取数据，客户端请求遵循FIFO优先级
     * @param timeout
     * @param key
     * @return
     */
    String brpop(Long timeout, String... key);

    String blpop(Long timeout, String... key);

    /**
     * 右出左进：可用于持久化队列和循环队列
     * @param src
     * @param dest
     * @return 插入到新队列的元素
     */
    String rpoplpush(String src, String dest);

    /**
     * 阻塞版本
     * 右出左进：可用于持久化队列和循环队列
     * @param src
     * @param dest
     * @param timeout
     */
    String brpoplpush(String src, String dest, Integer timeout);

    /**
     * 删除队列中的元素
     * @param key
     * @param count
     * @param value
     * @return
     */
    Long lrem(String key, Integer count, String value);


    /**
     * hash表设置
     * @param key
     * @param kvs
     * @return
     */
    String hmset(String key, Map<String, String> kvs);

    /**
     * 获取hash表中的多个属性
     * @param key
     * @param property
     * @return
     */
    List<String> hmget(String key, String... property);
}

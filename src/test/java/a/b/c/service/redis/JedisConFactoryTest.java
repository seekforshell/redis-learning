package a.b.c.service.redis;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.JedisCluster;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description:
 *
 * @author: renfei
 * Version: 1.0
 * Create Date Time: 2020-08-03 19:11.
 */
class JedisConFactoryTest {

    @Test
    void getConnection() {
        JedisCluster jedis = JedisConFactory.getConnection();
    }
}
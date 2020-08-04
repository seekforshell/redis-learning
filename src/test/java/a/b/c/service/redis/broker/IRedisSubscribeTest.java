package a.b.c.service.redis.broker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description:
 *
 * @author: renfei
 * Version: 1.0
 * Create Date Time: 2020-08-03 19:45.
 */
class IRedisSubscribeTest {

    IRedisSubscribe iRedisSubscribe = new IRedisSubscribeImpl();
    @Test
    void subscribe() {
        iRedisSubscribe.subscribe("topic1");
    }
}
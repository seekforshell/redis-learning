package a.b.c.service.redis;

import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author:
 * Version: 1.0
 * Create Date Time: 2020-08-03 15:31.
 */
@Component
public class JedisConFactory {

    private static volatile JedisCluster jc;

    public static JedisCluster getConnection() {
        return jc;
    }

    static {
        if (null == jc) {
            newConnection();
        }
    }

    public static synchronized void newConnection() {
        if (null == jc) {
            Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
            //Jedis Cluster will attempt to discover cluster nodes automatically
            jedisClusterNodes.add(new HostAndPort("192.168.90.40", 7379));
            jedisClusterNodes.add(new HostAndPort("192.168.90.40", 7380));
            jedisClusterNodes.add(new HostAndPort("192.168.90.40", 7381));
            jc = new JedisCluster(jedisClusterNodes);
        }

    }
}

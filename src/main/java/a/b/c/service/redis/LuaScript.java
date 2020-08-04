package a.b.c.service.redis;

import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author: renfei
 * Version: 1.0
 * Create Date Time: 2020-08-03 16:00.
 */
@Component
public class LuaScript {
    public static final String LOCK = "if redis.call('get', KEYS[1]) == ARGV[1] " +
            "                           then return redis.call('del', KEYS[1]) " +
            "                           else return 0 end";

}

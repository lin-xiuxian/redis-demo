package lxx;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class TestHash {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.flushDB();
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        //添加名为 hash(key) 的 hash 元素
        jedis.hset("hash", map); //可以将 java 的 hash 直接写入
        //向 hash 中添加 key -> key5, value -> value5 的元素
        jedis.hset("hash", "key5", "value5");
        System.out.println("散列 hash 的所有键值对: " + jedis.hgetAll("hash")); //return Map<String, String>
        System.out.println("散列 hash 的所有键: " + jedis.keys("hash"));
        System.out.println("散列 hash 的所有值: " + jedis.hvals("hash"));
        System.out.println("将 key6 的的值加上一个整数，如果 key6 不存在则新建 key6: " + jedis.hincrBy("hash", "key6", 1));
        System.out.println("散列 hash 的所有键值对: " + jedis.hgetAll("hash"));
        System.out.println("删除一个或者多个键值对: " + jedis.hdel("hash", "key2"));
        System.out.println("散列 hash 的所有键值对: " + jedis.hgetAll("hash"));
        System.out.println("散列中键值对的个数: " + jedis.hlen("hash"));
        System.out.println("判断 hash 中是否存在 key2: " + jedis.hexists("hash", "key2"));
        System.out.println("判断 hash 中是否存在 key3: " + jedis.hexists("hash", "key3"));
        System.out.println("获取 hash 中对应的 key 的值: " + jedis.hget("hash", "key3"));
        System.out.println("批量获取 hash 中 key 的值: " + jedis.hmget("hash", "key3", "key4"));
    }
}

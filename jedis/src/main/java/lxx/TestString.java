package lxx;

import redis.clients.jedis.Jedis;

import javax.sound.midi.Soundbank;
import java.util.concurrent.TimeUnit;

public class TestString {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.flushDB();
        System.out.println("===========================新增数据==========================");
        System.out.println("添加数据 key1, value1 " + jedis.set("key1", "value1"));
        System.out.println("添加数据 key2, value2 " + jedis.set("key2", "value2"));
        System.out.println("添加数据 key3, value3 " + jedis.set("key3", "value3"));
        System.out.println("删除键 key2 " + jedis.del("key2"));
        System.out.println("获取键 key2 " + jedis.get("key2"));
        System.out.println("在 key3 后面加入值 " + jedis.append("newKey", "newValue"));
        System.out.println("增加多个键值对 " + jedis.mset("key4", "value4", "key5", "value5"));
        System.out.println("获取多个键值对 " + jedis.mget("key1", "key3", "key4"));
        System.out.println("删除多个键 " + jedis.del("key1", "key3"));
        System.out.println("获取所有键 " + jedis.keys("*"));

        jedis.flushDB();
        System.out.println("===============================新增数据防止覆盖原值(分布式锁)==================");
        System.out.println(jedis.setnx("key1", "value1"));
        System.out.println(jedis.setnx("key2", "value2"));
        System.out.println(jedis.setnx("key2", "value2-new2"));
        System.out.println(jedis.mget("key1", "key2"));

        System.out.println("=========================新增键并设置有效时间========================");
        System.out.println(jedis.setex("key3", 2, "value3"));
        System.out.println(jedis.get("key3"));
        try{
            TimeUnit.SECONDS.sleep(3);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(jedis.get("key3"));

        System.out.println("=========================获取原值，更新为新值===================");
        System.out.println(jedis.getSet("key2", "key2GetSet"));
        System.out.println(jedis.get("key2"));

        System.out.println("获取 key2 的值的字串 " + jedis.getrange("key2", 2,4));
    }
}

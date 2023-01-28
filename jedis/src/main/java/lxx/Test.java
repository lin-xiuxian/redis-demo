package lxx;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println("测试连接 " + jedis.ping());
        System.out.println("清空数据库 " + jedis.flushDB());
        System.out.println("新增键值对 k1, v1 " + jedis.set("k1", "v1"));
        System.out.println("新增键值对 k2, v2 " + jedis.set("k2", "v2"));
        System.out.println("新增键值对 k3, v3 " + jedis.set("k3", "v3"));
        System.out.println("获取指定键 k2 的值 " + jedis.get("k2"));
        System.out.println("获取所有键");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        System.out.println("删除键 k2 " + jedis.del("k2"));
        System.out.println("判断 k2 是否存在 " + jedis.exists("k2"));
        System.out.println("判断 k1 的数据类型 " + jedis.type("k1"));
        System.out.println("随机获取 key " + jedis.randomKey());
        System.out.println("重命名 key " + jedis.rename("k1", "name"));
        System.out.println("获取改名后的 k1 " + jedis.get("name"));
        System.out.println("查看当前数据库的条目数 " + jedis.dbSize());
        System.out.println("选择数据库 " + jedis.select(1));
        System.out.println("删除所有数据库的数据 " + jedis.flushAll());
    }
}

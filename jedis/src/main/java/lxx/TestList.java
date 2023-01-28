package lxx;

import redis.clients.jedis.Jedis;

public class TestList {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();

        System.out.println("=================添加一个list=============");
        jedis.lpush("collections", "ArrayList", "Stack", "HashMap", "WeakHashMap", "LinkedHashMap");
        jedis.lpush("collections", "HashSet");
        jedis.lpush("collections", "TreeSet");
        jedis.lpush("collections", "TreeMap");
        System.out.println("collections的内容: " + jedis.lrange("collections", 0, -1));
        System.out.println("collections区间 0 - 3 的元素: " + jedis.lrange("collections", 0, 3));
        System.out.println("==========================");
        //删除列表指定的值，第二个为删除的个数，后入的元素会先被删除
        System.out.println("删除指定元素个数: " + jedis.lrem("collections", 2, "HashMap"));
        System.out.println("collections 的所有内容: " + jedis.lrange("collections", 0, -1));
        System.out.println("删除列表 0 - 3 区间以外的元素: " + jedis.ltrim("collections", 0, 3));
        System.out.println("collections 的内容: " + jedis.lrange("collections", 0, -1));
        System.out.println("collections 列表左端出栈: " + jedis.lpop("collections"));
        System.out.println("collections 的内容: " + jedis.lrange("collections", 0, -1));
        System.out.println("collections 右端添加元素: " + jedis.rpush("collections", "EnumMap"));
        System.out.println("collections 的内容: " + jedis.lrange("collections", 0, -1));
        System.out.println("collections 右端出栈: " + jedis.rpop("collections"));
        System.out.println("collections 的内容: " + jedis.lrange("collections", 0, -1));
        System.out.println("修改 collections 下标为 1 的内容: " + jedis.lset("collections", 1,"LinkedArrayList"));
        System.out.println("collections 的内容: " + jedis.lrange("collections", 0, -1));
        System.out.println("========================");
        System.out.println("获取 collections 的长度: " + jedis.llen("collections"));
        System.out.println("获取 collections 下表为 2 的元素: " + jedis.lindex("collections", 2));
        System.out.println("============================");
        System.out.println("排序列表: ");
        jedis.lpush("sortedList", "3", "6", "2", "0", "7", "4");
        System.out.println("sortedList 排序前: " + jedis.lrange("sortedList", 0, -1));
        System.out.println("排序后（不改变原来的列表）: " + jedis.sort("sortedList"));
//        System.out.println("sortedList 排序后: " + jedis.lrange("sortedList", 0, -1));
    }
}

package lxx;

import java.util.ArrayList;
import java.util.List;

public class CacheSample {
    public CacheSample(){
        List<Goods> goodsList = new ArrayList<Goods>();
        goodsList.add(new Goods(8818, "苹果", "123", 2.5f));
        goodsList.add(new Goods(8819, "橙子", "123", 2.6f));
        goodsList.add(new Goods(8820, "香蕉", "123", 2.7f));
    }
}

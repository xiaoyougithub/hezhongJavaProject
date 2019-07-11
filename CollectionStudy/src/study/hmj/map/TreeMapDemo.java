package study.hmj.map;
/**
 * 
 * @author Hmj
 * @Date 2019-07-11
 *	Map中使用最多的就是HashMap,HashMap有LinkedMap和HashMap前者保证元素的输出顺序和插入顺序是一致的
 *	TreeMap和HashMap不同，其底层是Tree结构，数据按照键的大小进行排序
 */
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        Map<String,String> treeMap = new TreeMap<String,String>();
        Map<String,String> linkedMap = new LinkedHashMap<String, String>();

        treeMap.put("b",null);
        treeMap.put("c",null);
        treeMap.put("a",null);

        for (Iterator<String> iter = treeMap.keySet().iterator();iter.hasNext();){
            System.out.println("TreeMap="+iter.next());
        }

        System.out.println("----------分割线---------");

        linkedMap.put("b",null);
        linkedMap.put("c",null);
        linkedMap.put("a",null);

        for (Iterator<String> iter = linkedMap.keySet().iterator();iter.hasNext();){
            System.out.println("LinkedHashMap="+iter.next());
        }
    }
}
/**
 * 	演示结果：
 * 
TreeMap=a
TreeMap=b
TreeMap=c
----------分割线---------
LinkedHashMap=b
LinkedHashMap=c
LinkedHashMap=a
 */
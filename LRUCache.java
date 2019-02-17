import java.util.*;

/**
 * Created by zfz on 2019/2/17.
 */
class LRUCache {
    private Map<Integer, Integer> map;
    private List<Integer> queue;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        queue = new LinkedList<>();
    }

    public int get(int key) {
        if(!map.keySet().contains(key))
            return -1;
        queue.remove((Integer)key);
        queue.add(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if(map.keySet().contains(key)){
            map.remove(key);
            queue.remove((Integer)key);
        }
        if(map.size() == capacity){
            map.remove(queue.remove(0));
        }
        map.put(key, value);
        queue.add(key);
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by zfz on 2019/2/16.
 */
class MinStack {
    private int min = Integer.MAX_VALUE;
    private List<Integer> stack = new ArrayList<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.add(x);
        min = x < min ? x : min;
    }

    public void pop() {
        if(top() <= min){
            stack.remove(stack.size() - 1);
            List<Integer> stack = new ArrayList<>(this.stack);
            stack.sort(Integer::compareTo);
            min = stack.get(0);
            return;
        }
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min;
    }
}

class Minstack {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    /** initialize your data structure here. */
    public Minstack() {}

    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty() || s2.peek() >= x) s2.push(x);
    }

    public void pop() {
        // Cannot write like the following:
        // if (s2.peek() == s1.peek()) s2.pop();
        // s1.pop();
        int x = s1.pop();
        if (s2.peek() == x) s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }
}
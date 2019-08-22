package com.kolly.learning.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author kolly.li
 * @Date 2019/4/11
 */
public class StackTest {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        System.out.println(stack.isEmpty());
    }

    public static class Stack {

        private List<Integer> items = new ArrayList<>();

        /*
         * @param x: An integer
         * @return: nothing
         */
        public void push(int x) {
            // write your code here
            items.add(x);
        }

        /*
         * @return: nothing
         */
        public void pop() {
            // write your code here
            if (items.size() == 0) {
                return;
            }
            items.remove(items.size() - 1);
        }

        /*
         * @return: An integer
         */
        public int top() {
            // write your code here
            if (items.size() == 0) {
                return 0;
            }
            return items.get(items.size() - 1);
        }

        /*
         * @return: True if the stack is empty
         */
        public boolean isEmpty() {
            // write your code here
            return items.size() == 0;
        }
    }

}

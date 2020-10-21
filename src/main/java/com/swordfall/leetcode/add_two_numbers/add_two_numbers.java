package com.swordfall.leetcode.add_two_numbers;/**
 * @Author: Yang JianQiu
 * @Date: 2020/10/22 1:27
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Swordfall Yeung
 * @date:
 * @desc:
 */
public class add_two_numbers {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // List a1 = new ArrayList<int>(); ArrayList的类型写为int 错误; list没有标明类型错误
        List<Integer> a1 = new ArrayList<Integer>();
        List<Integer> a2 = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();

        while(null != l1){
            a1.add(l1.val);
            l1 = l1.next;
        }

        while(null != l2){
            a2.add(l2.val);
            l2 = l2.next;
        }

        // if (a1.size >= a2.size){   list.size没有括号，错误
        if (a1.size() < a2.size()){
            List<Integer> transfer = new ArrayList<Integer>();
            transfer = a1;
            a1 = a2;
            a2 = transfer;
        }

        int j = a2.size() - 1;
        int count = 0;
        Boolean flag = false;
        for(int i = a1.size() - 1; i >= 0; i--){
            if (j >= 0){
                // int sum = a1[i] + a2[j]; a1[i]为数组写法
                int sum = a1.get(i) + a2.get(j);
                if (sum >= 10){
                    sum = sum -10;
                    flag = true;
                }else{
                    flag = false;
                }
                result.add(sum + count);
                if (flag){
                    count = 1;
                }else{
                    count = 0;
                }
            }else{
                int sum = a1.get(i) + count;
                if (sum >= 10){
                    sum = sum -10;
                    flag = true;
                }else{
                    flag = false;
                }
                result.add(sum);
                if (flag){
                    count = 1;
                }else{
                    count = 0;
                }
                if(count == 1 && i == 0){
                    result.add(1);
                }
            }
            j--;
        }

        // Map<int, ListNode> map = new HashMap<int, ListNode>(); map类型不能为int，错误
        Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        for(int i = result.size() - 1; i >= 0; i--){
            //if (map.containKey(i - 1)){  containKey错误
            if (map.containsKey(i + 1)){
                ListNode ln = new ListNode(result.get(i), map.get(i + 1));
                map.put(i, ln);
            }else{
                ListNode ln = new ListNode(result.get(i));
                map.put(i, ln);
            }
        }
        return map.get(0);
    }

    public static void main(String[] args) {

    }
}

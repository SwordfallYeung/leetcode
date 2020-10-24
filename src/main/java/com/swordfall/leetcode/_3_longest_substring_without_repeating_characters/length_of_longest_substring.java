package com.swordfall.leetcode._3_longest_substring_without_repeating_characters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Swordfall Yeung
 * @date: 2020/10/25 1:47
 * @desc:
 */
public class length_of_longest_substring {
    public static int lengthOfLongestSubstring(String s) {
        // List<String> list = new ArrayList<String>; 没有括号，错误
        List<String> list = new ArrayList<String>();
        int length = 0;
        //for(int i = 0; i< s.length; i++){ 没有括号，错误
        for(int i = 0; i< s.length(); i++){
            for(int y = i; y < s.length(); y++){
                String index = s.substring(y, y+1);

                if(!list.contains(index)){
                    list.add(index);
                }else{
                    // continue; 错误 continue只中断循环中的其中一次，break则中断整个循环
                    break;
                }
            }
            if (length < list.size()){
                length = list.size();
            }
            list = new ArrayList<String>();
        }
        return length;
    }

    public int lengthOfLongestSubstring2(String s) {
        //哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为-1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i){
            if (i != 0){
                //左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))){
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            //第i到rk个字符是一个极长的无重复字符串子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("pwwkew");
        System.out.println(result);
    }
}

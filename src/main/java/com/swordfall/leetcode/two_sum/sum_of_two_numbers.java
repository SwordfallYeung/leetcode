package com.swordfall.leetcode.two_sum;/**
 * @Author: Yang JianQiu
 * @Date: 2020/10/21 0:18
 */

import java.util.HashMap;
import java.util.Map;

/**
 *  两数之和
 *  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Swordfall Yeung
 * @date:
 * @desc:
 */
public class sum_of_two_numbers {
    public static int[] twoSum(int[] nums, int target) {
        // nums.size int数组大小获取错误
        for(int i = 0; i < nums.length; i++){
            // result = 9 - nums[i]; 没有标明变量类型， 没有使用到target 错误
            int result = target - nums[i];

            //if (result > 0){ 忽略等于或者小于0 错误
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] == result){
                    // return int[]{nums[i], nums[j]}; int数组定义错误
                    return new int[]{i, j};
                }
            }

        }
        // 没有 return返回值 错误
        return new int[0];
    }

    /**
     * leetcod官方题解
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumOK1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * leetcod官方最优题解
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumOK2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    // public static void main() { 没有String[] args 错误
    public static void main(String[] args){
        // int nums = int[]{2,7,11,15}; int数组定义错误
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] resultArray = twoSum(nums, target);

        // System.out.println(resultArray); 显示的是数组对象hashcode
        String result = "[";
        for (int i = 0; i < resultArray.length; i++){
            if (i == 0){
                result += resultArray[i] + ",";
            }else {
                result += resultArray[i] ;
            }
        }
        System.out.println(result + "]");
    }
}

package com.jikaigg.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class demo1 {
    public static void main(String[] args) {
        int[] nums = {1, 4, 9, 3, 5};
        int target = 14;
        //System.out.println(add1(nums,target));
        System.out.println(add2(nums, target));

    }

    public static String add1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println("i:" + i);
            for (int j = i + 1; j < nums.length - 1; j++) {
                System.out.println("j:" + j);
                if (nums[i] + nums[j] == target) {
                    return "第一个数的索引为" + i + "第二个数的索引为" + j;
                }
            }
        }
        return "无匹配";
    }

    public static String add2(int[] nums, int target) {
/*        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return map.get(target-nums[i])+"============="+i;
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }*/

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            //判断map中有没有一个键为总和减另一个值
            if (map.containsKey(target - nums[i])) {
                return map.get(target - nums[i]) + "---" + i;
            }
            //将当前的值，索引号put进map
            map.put(nums[i], i);
        }
        return "无匹配";
    }
}

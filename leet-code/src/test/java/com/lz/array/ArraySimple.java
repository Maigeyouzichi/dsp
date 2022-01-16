package com.lz.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组类型题目 -- 简单
 */
public class ArraySimple {

    /**
     * 1. 两数之和
     */
    private int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            int t = target - ele;
            Integer index = map.get(t);
            if (index != 0) return new int[]{i, index};
            map.put(ele, i);
        }
        return null;
    }

    /**
     * 26. 删除有序数组中的重复项
     * <p>
     * 1 2 3 4 3 3 3 4
     * p=0 1 2
     * q=1 2 3 4 5 6 7
     * 思路: 双指针遍历数组:
     * 如果p,q位置数据相同,q++
     * 如果p,q位置数据不同,q下标数据和p+1下标数据交换,同时
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] == nums[q]) {
                q++;
            } else {
                nums[p + 1] = nums[q];
                p++;
            }
        }
        return p + 1;
    }

    /**
     * 27,移除元素
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] == val) {
                int tmp;
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j--;
            } else {
                i++;
            }
        }
        if (nums[i] == val) return i;
        return i + 1;
    }

    /**
     * 35. 搜索插入位置
     */
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (nums[i] < target) {
            return i+1;
        }else {
            return i;
        }
    }

    /**
     * 66,加一
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i] = digits[i]+1;
            digits[i] = digits[i]%10;
            //如果不需要进位,直接返回
            if (digits[i] != 0) return digits;
        }
        //如果可以走到这一步,说明一直都在进位,即9999这样的情况
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }


    /**
     * 88,合并有序数组
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m --;
        n --;
        int k = nums1.length-1;
        while (n >= 0) {
            if (m >= 0 && nums1[m] > nums2[n]) {
                nums1[k] = nums1[m];
                m --;
            }else {
                nums1[k] = nums2[n];
                n --;
            }
            k --;
        }
    }

    /**
     * 136. 只出现一次的数字
     * 位运算:
     *  &: 与 -- 1 & 1 = 1 其余都是0
     *  |: 或 -- 存在1就是1
     *  ^: 异或 -- 相同为0,不同为1 即: 任何数字和0进行异或运算结果都是数字本身, 任何数字和其本身异或结果都是0,且支持交换律.
     */
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num^nums[i];
        }
        return num;
    }

    /**
     * 167.两数之和 有序数组
     */
    private int[] twoSum02(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length -1;
        int sum;
        while (i < j) {
            sum = numbers[i]+numbers[j];
            if (sum == target) {
                return new int[]{i+1,j+1};
            }else if (sum > target) {
                j --;
            }else {
                i ++;
            }
        }
        return null;
    }

    /**
     * 169,多数元素
     */
    public int majorityElement(int[] nums) {
        int t = nums.length/2;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.get(num) == null ? 0 : map.get(num);
            count ++;
            if (count > t) return num;
            map.put(num,count);
        }
        return 0;
    }

    /**
     * 217,存在重复元素
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (map.get(num) != null) return true;
            map.put(num,1);
        }
        return false;
    }

}
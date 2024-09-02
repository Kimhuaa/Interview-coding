package org.feng.interview.sort;

/**
 * @program: Interview-coding
 * @description: 冒泡排序-稳定排序（相同元素顺序不变）
 * @author: fenging
 * @create: 2024-09-02 18:45
 **/

public class BubbleSort {

    /**
    * 稳定排序（相同元素顺序不变），时间复杂度(n - 1) * n / 2, 即 O(n^2)
    * 如何优化？ ——> 如果某轮“冒泡”中没有执行任何交换操作，说明数组已经完成排序，可直接返回结果, 最佳时间复杂度 O(n)
    */
    static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i++) { // 外循环：未排序区间[0, i]
            boolean flag = false; // 初始化标志位
            for (int j = 0; j < n; j++) {  // 内循环：交换未排序区间元素内的最大值至区间最右端
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+ 1];
                    nums[j+ 1] = tmp;
                    flag = true; // 记录交换元素
                }
            }
            if (!flag)
                break; // 此轮“冒泡”未交换任何元素，直接跳出
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 3, 1, 2, 3, 8, 6, 9};
        bubbleSort(nums);
        for(int i : nums) System.out.println(i);
    }
}

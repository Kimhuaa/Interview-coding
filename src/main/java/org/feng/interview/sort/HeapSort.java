package org.feng.interview.sort;

/**
 * @program: Interview-coding
 * @description: 堆排序
 * @author: zhu xuefeng
 * @create: 2024-09-02 23:22
 **/

public class HeapSort {

    private static void siftDown(int[] nums, int n, int i) {
        while (true) {
            // 判断节点 i, l, r 中值最大的节点，记为 fa
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int fa = i;
            if (l < n && nums[l] > nums[fa]) fa = l;
            if (r < n && nums[r] > nums[fa]) fa = r;
            if (fa == i) {
                break; // 当前节点比左右儿子节点大，说明堆化完成 (初始堆化，保证了子树的局部有序性，因此可以直接结束)
            }
            // 交换两节点
            int temp = nums[i];
            nums[i] = nums[fa];
            nums[fa] = temp;
            // 循环向下堆化
            i = fa;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-3, 2, 4, 7, 3, 1, 3, 9, -5};
        int n = nums.length;
        // 1. 建堆操作: 堆化除叶子节点以外的其他所有节点 (因为叶子节点没有儿子节点，不需要交换)
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(nums, n, i);
        }
        // 2. 原地排序: 从堆中交换提取最大元素，循环 n-1 轮
        for (int i = n - 1; i >= 0; i--) {
            // 交换堆顶元素 nums[0] 和未排序的最后一个叶子节点 nums[i]
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            siftDown(nums, i, 0);
        }
    }
}

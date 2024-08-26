package org.feng.interview.sort;

/**
 * @Description 快速排序（非稳定排序）
 * @Author Zhu XueFeng
 * @Date 2024/8/7 15:00
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {-3, 2, 4, 7, 3, 1, 3, 9, 5};
        quickSort(nums, 0, nums.length - 1);
        for (int n : nums) System.out.print(n + " ");
    }

    static void quickSort(int[] nums, int l, int r) {
        if (l >= r) return; // 子数组长度为1时递归终止
        int mid = choose(nums, l, (l + r) / 2, r);

        int i = l, j = r;
        int pivot = l; // 哨兵划分（一般情况下，时间复杂度 O(NlogN); 极端情况下，每次划分长度为0、n，此时复杂度退化为 O(N^2)）
        while (i < j) {
            while (i < j && nums[j] >= nums[pivot]) {
                j--; // 从右向左寻找第一个比哨兵小的值
            }
            while (i < j && nums[i] <= nums[pivot]) {
                i++; // 从左向右寻找第一个比哨兵大的值
            }
            swap(nums, i, j);
        }
        swap(nums, i, l);
        pivot = i;

        quickSort(nums, l, pivot - 1);
        quickSort(nums, pivot + 1, r);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static int choose(int[] nums, int l, int mid, int r) {
        if ((nums[l] < nums[mid]) ^ (nums[l] < nums[r])) {
            return l;
        } else if ((nums[mid] < nums[l]) ^ (nums[mid] < nums[r])) {
            return mid;
        } else {
            return r;
        }
    }
}

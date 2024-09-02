package org.feng.interview.sort;

/**
 * @Description 归并排序(基于'分治'策略, 先分后和), 稳定排序, 时间复杂度 O(NlogN)
 * @Author Zhu XueFeng
 * @Date 2024/8/7 15:15
 */
public class MergeSort {

    /**
    * 归并排序递归深度 logN, 每层操作 n 个数, 时间复杂度 O(NlogN)
    * 借助临时数组，空间复杂度 O(n)
    */
    static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = (r - l) / 2 + l;
        // 分
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        // 合
        merge(nums, l, mid, r);
    }

    private static void merge(int[] nums, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int i = l, j = mid + 1, idx = 0;
        // 比较两个区间的元素大小
        while(i <= mid && j <= r) {
            if(nums[i] <= nums[j]) {
                tmp[idx++] = nums[i++];
            } else {
                tmp[idx++] = nums[j++];
            }
        }
        while(i <= mid) tmp[idx++] = nums[i++];
        while(j <= r) tmp[idx++] = nums[j++];

        // 将临时数组 tmp 中的元素复制回原数组 nums 的对应区间
        System.arraycopy(tmp, 0, nums, l, r - l + 1);
        // for (int k = 0; k < tmp.length; k++) nums[l + k] = tmp[k];
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {-3, 2, 4, 7, 3, 1, 3, 9, -5};
        mergeSort(nums, 0, nums.length - 1);
        for (int n : nums) System.out.print(n + " ");
    }
}

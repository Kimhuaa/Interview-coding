package org.feng.interview.query;

/**
 * @Description TODO
 * @Author Zhu XueFeng
 * @Date 2024/8/10 15:37
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DiscreteAndBIT {
    private int[] bit;
    private int[] discrete;
    private int n;

    public DiscreteAndBIT(int[] nums) {
        // 离散化
        discrete = discretize(nums);
        n = discrete.length;
        bit = new int[n + 1];
    }

    private int[] discretize(int[] nums) {
        // 复制数组并排序
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        // 使用HashMap进行离散化
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, idx++);
            }
        }
        // 构建离散化后的数组
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = map.get(nums[i]);
        }
        return result;
    }

    public void update(int index, int val) {
        index = discrete[index] + 1; // 转换为BIT的索引
        while (index <= n) {
            bit[index] += val;
            index += index & -index;
        }
    }

    public int query(int index) {
        index = discrete[index] + 1; // 转换为BIT的索引
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }
        return sum;
    }

    public int queryRange(int left, int right) {
        return query(right) - query(left - 1);
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 7, 3, 9, 1};
        DiscreteAndBIT solution = new DiscreteAndBIT(nums);

        // 更新操作
        solution.update(2, 5); // 将索引2的值增加5

        // 区间查询操作
        int result = solution.queryRange(1, 4); // 查询索引1到4的区间和
        System.out.println("区间和: " + result); // 输出区间和
    }
}

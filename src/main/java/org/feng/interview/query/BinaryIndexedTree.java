package org.feng.interview.query;

/**
 * @Description 树状数组
 * @Author Zhu XueFeng
 * @Date 2024/8/10 15:20
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryIndexedTree {
    private int[] bit;
    private int[] discrete;
    private int n;
    private Map<Integer, Integer> valueToIndex;

    // 构造函数
    public BinaryIndexedTree(int[] nums) {
        this.n = nums.length;
        this.bit = new int[n + 1];
        this.discrete = nums.clone();
        Arrays.sort(discrete);

        this.valueToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndex.put(discrete[i], i + 1);
        }

        for (int i = 0; i < n; i++) {
            update(nums[i], 1); // 在离散化的索引上更新
        }
    }

    // 单点更新：将离散化后的值 index 处的值增加 delta
    public void update(int value, int delta) {
        int index = valueToIndex.get(value);
        while (index <= n) {
            bit[index] += delta;
            index += index & -index;
        }
    }

    // 查询前缀和：从0到离散化后的 index 的和
    public int query(int value) {
        int index = valueToIndex.get(value);
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }
        return sum;
    }

    // 查询区间和：从 left 到 right 的和
    public int queryRange(int leftValue, int rightValue) {
        int leftIndex = valueToIndex.get(leftValue);
        int rightIndex = valueToIndex.get(rightValue);
        return query(discrete[rightIndex - 1]) - query(discrete[leftIndex - 1] - 1);
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 7, 3, 9, 1};
        BinaryIndexedTree bit = new BinaryIndexedTree(nums);

        // 区间查询操作
        int result = bit.queryRange(2, 9); // 查询区间[2, 9]的和
        System.out.println("区间和: " + result); // 输出区间和

        // 更新操作
        bit.update(7, 5); // 将值为7的元素增加5

        // 再次进行区间查询操作
        result = bit.queryRange(2, 9); // 查询区间[2, 9]的和
        System.out.println("更新后的区间和: " + result); // 输出更新后的区间和
    }
}

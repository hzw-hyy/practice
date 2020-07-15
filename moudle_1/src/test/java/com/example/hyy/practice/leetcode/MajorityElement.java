package com.example.hyy.practice.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @author hyy
 * @version 1.0
 * @date 2020/7/4 10:27
 */
public class MajorityElement {


    @Test
    public void test() {


//        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int[] nums = new int[]{7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 7, 7, 7, 7};
//        System.out.println(majorityElement_HashMap(nums));
//        System.out.println(majorityElement_Sort(nums));
//        System.out.println(majorityElement_Randomization(nums));
//        System.out.println(majorityElement_DivideAndRule(nums));
        System.out.println(majorityElement_Boyer_Moore(nums));
    }

    /**
     * 方法一：哈希表
     * 思路
     * 我们知道出现次数最多的元素大于⌊2/n⌋ 次，所以可以用哈希表来快速统计每个元素出现的次数。
     * 算法
     * 我们使用哈希映射（hashmap）来存储每个元素以及出现的次数。
     * 对于哈希映射中的每个键值对，键表示一个元素，值表示该元素出现的次数。
     * 我们用一个循环遍历数组nums并将数组中的每个元素加入哈希映射表中。
     * 在这之后，我们遍历哈希映射的所有键值对，返回值最大的键。
     * 我们同样也可以遍历数组nums时候使用打擂台的方法，维护最大的值，这样省去了最后对哈希映射的遍历。
     *
     * @param nums
     * @return
     */
    public int majorityElement_HashMap(int[] nums) {

        Map<Integer, Integer> counts = countNums(nums);
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue())
                majorityEntry = entry;
        }
        return majorityEntry.getKey();
    }

    private Map<Integer, Integer> countNums(int[] nums) {

        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num))
                counts.put(num, 1);
            else
                counts.put(num, counts.get(num) + 1);
        }
        return counts;
    }

    /**
     * 方法二：排序
     * 思路
     * 如果将数组 nums 中的所有元素按照单调递增或单调递减的顺序排序，那么下标为 ⌊2/n⌋ 的元素（下标从 0 开始）一定是众数。
     * 算法
     * 对于这种算法，我们先将 nums 数组排序，然后返回上文所说的下标对应的元素。
     * 下面的图中解释了为什么这种策略是有效的。在下图中，第一个例子是 n为奇数的情况，第二个例子是 n为偶数的情况。
     * 对于每种情况，数组下面的线表示如果众数是数组中的最小值时覆盖的下标，数组下面的线表示如果众数是数组中的最大值时覆盖的下标。对于其他的情况，这条线会在这两种极端情况的中间。
     * 对于这两种极端情况，它们会在下标为⌊2/n⌋ 的地方有重叠。因此，无论众数是多少，返回 ⌊2/n⌋ 下标对应的值都是正确的。
     *
     * @param nums
     * @return
     */
    public int majorityElement_Sort(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement_Randomization(int[] nums) {
        return 1;
    }

    public int majorityElement_DivideAndRule(int[] nums) {
        return 1;
    }

    /**
     * 方法五：Boyer-Moore 投票算法
     * 思路
     * 如果我们把众数记为 +1，把其他数记为 -1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
     * 算法的详细步骤：
     * 我们维护一个候选众数 candidate 和它出现的次数 count。初始时 candidate 可以为任意值，count 为 0；
     * 我们遍历数组 nums 中的所有元素，对于每个元素 x，在判断 x 之前，如果 count 的值为 0，
     * 我们先将 x 的值赋予 candidate，随后我们判断 x：
     * 如果 x 与 candidate 相等，那么计数器 count 的值增加 1；
     * 如果 x 与 candidate 不等，那么计数器 count 的值减少 1。
     * 在遍历完成后，candidate 即为整个数组的众数。
     * 我们举一个具体的例子，例如下面的这个数组：
     * [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7]
     * 在遍历到数组中的第一个元素以及每个在 | 之后的元素时，
     * candidate 都会因为 count 的值变为 0 而发生改变。最后一次 candidate 的值从 5 变为 7，也就是这个数组中的众数。
     *
     * @param nums
     * @return
     */
    public int majorityElement_Boyer_Moore(int[] nums) {

        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0)
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }


}

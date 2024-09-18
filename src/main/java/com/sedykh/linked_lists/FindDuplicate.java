package com.sedykh.linked_lists;

public class FindDuplicate {
    public static int findDuplicateNaive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static int findDuplicateAdditionalMemory(int[] nums) {
        boolean[] exist = new boolean[nums.length];
        for (int num : nums) {
            if (exist[num]) {
                return num;
            }
            exist[num] = true;
        }
        return -1;
    }

    public static int findDuplicate(int[] nums) {
      int slow = 0;
      int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while (slow != fast);

        int slow2 = 0;

        do {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        while (slow != slow2);

        return slow2;
    }
}

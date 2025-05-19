class Solution {
    public String triangleType(int[] nums) {
        // to check if the triangle can be formed or not
        if(nums[0]+nums[1]<=nums[2] || nums[0]+nums[2]<=nums[1] || nums[1]+nums[2]<=nums[0])
            return "none";
        else
            if(nums[0]==nums[1] && nums[1]==nums[2])
                return "equilateral";
            else if (nums[0]==nums[1] || nums[1]==nums[2] || nums[2]==nums[0])
                return "isosceles";
            else
                return "scalene";
    }
}
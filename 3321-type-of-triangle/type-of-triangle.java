class Solution {
    public String triangleType(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        // to check if the triangle can be formed or not
        if(a+b<=c || a+c<=b || b+c<=a)
            return "none";
        else
        {
            if(a==b && b==c)
                return "equilateral";
            else if (a==b || b==c || c==a)
                return "isosceles";
            else
                return "scalene";
        }
    }
}
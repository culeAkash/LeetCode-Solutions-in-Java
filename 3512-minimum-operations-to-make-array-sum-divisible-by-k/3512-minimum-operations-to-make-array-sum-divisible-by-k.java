class Solution {
    public int minOperations(int[] nums, int k) {
        return (Arrays.stream(nums).boxed().collect(Collectors.summingInt(x->x)) % k);
        // return sum;
    }
}
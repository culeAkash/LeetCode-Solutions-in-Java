class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> st = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        while(st.contains(original)){
            original *= 2;
        }

        return original;
    }
}
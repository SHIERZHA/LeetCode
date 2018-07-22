class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);                			//sort to omit the duplicating number 
        backtrack(nums, new ArrayList(), ans, 0);
        return ans;

    }
    
    public void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> ans, int start){
        if(temp.size() > nums.length){
            return;
        }
        else{
            ans.add(new ArrayList(temp));
            for(int i = start;i < nums.length;i++){
                if(i > start && (nums[i] == nums[i-1])) continue;  //omit the duplicated number
                temp.add(nums[i]);
                backtrack(nums, temp, ans, i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
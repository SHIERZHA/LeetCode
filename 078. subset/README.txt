class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0) return null;
        List<List<Integer>> ans = new ArrayList();
        //ans.add(new ArrayList());
        backtrack(nums,new ArrayList(),0,ans);
        return ans;
    }
    
    public void backtrack(int[] nums, List<Integer> temp,int start, List<List<Integer>> ans){

        ans.add(new ArrayList(temp));
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(nums,temp,i+1,ans);
            temp.remove(temp.size()-1);
        }
        
    }
}

/*
 * merge sort with index[]
 **/

public class Solution {
    public List<Integer> countSmaller(int[] nums) {

        List<Integer> rs = new ArrayList<Integer>();
        
        // corner cases
        if(nums.length == 0) return rs;
        if(nums.length == 1){
            rs.add(0);
            return rs;
        }
        
        //initiatiom
        int[] indexs = new int[nums.length];
        int[] count = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            indexs[i] = i;
        }
        
        mergeSort(nums, 0, nums.length - 1, indexs, count);
        
        //output
        for(int i = 0; i < nums.length; i++){
            rs.add(count[i]);
        }
        return rs;
    }

    public void mergeSort(int[] nums, int start, int end, int[] indexs, int[] count){

        int mid = (start + end) / 2;

        if(start == end){
            return;
        }
        else{
            mergeSort(nums, start, mid, indexs, count);
            mergeSort(nums, mid + 1, end, indexs, count);
            merge(nums, start, end, indexs, count);
        }

    }

    //merge two int[]  [start, mid], [mid + 1, end]
    public void merge(int[] nums, int start, int end, int[] indexs, int[] count){

        int leftIndex = start;
        int mid = (start + end) / 2;
        int rightIndex = mid + 1;
        int length = nums.length;
        int[] newIndex = new int[end - start + 1];

        for(int i = start; i <= end; i++){
            if(leftIndex <= mid && rightIndex <= end){
                if(nums[indexs[leftIndex]] <= nums[indexs[rightIndex]]){// similar to merge sort, index[leftIndex] to find the sorted nums
                    newIndex[i - start] = indexs[leftIndex];//set the updated index to newIndex and apply the update after for loop
                    count[indexs[leftIndex]] += rightIndex - (mid + 1);// how merge sort help to get the count; still, find the sorted nums
                    leftIndex++;
                }
                else{
                    newIndex[i - start] = indexs[rightIndex];
                    rightIndex++;
                }
            }
            else{
                if(leftIndex > mid){
                    newIndex[i - start] = indexs[rightIndex];
                    rightIndex++;
                }
                else{
                    newIndex[i - start] = indexs[leftIndex];
                    count[indexs[leftIndex]] += rightIndex - (mid + 1);// how merge sort help to get the count
                    leftIndex++;
                }
            }
        }

        for(int i = start; i <= end; i++){
            indexs[i] = newIndex[i - start];
        }

    }

 
}
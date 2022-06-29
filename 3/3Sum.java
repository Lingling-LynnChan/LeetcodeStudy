/*
https://leetcode.com/problems/3sum/
考虑到去重,可以用Set解决掉这个问题
以及用喜闻乐见的双指针法把复杂度降低到O(N^2)
*/
class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		Set<List<Integer>> set=new HashSet<>();
		for(int i=0;i<nums.length-1;i++){
			int target=-nums[i];
			int left=i+1;
			int right=nums.length-1;
			while (left<right){
				int sum=nums[left]+nums[right];
				if(sum==target){
					set.add(Arrays.asList(nums[i],nums[left],nums[right]));
					left++;
					right--;
				}else if(sum>target){
					right--;
				}else {
					left++;
				}
			}
		}
		return new ArrayList<>(set);
	}
}

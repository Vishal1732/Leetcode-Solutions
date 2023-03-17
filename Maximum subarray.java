class Solution {
    public int maxSubArray(int[] A) {
int newsum=A[0];
int max=A[0];
for(int i=1;i<A.length;i++){
newsum=Math.max(newsum+A[i],A[i]);
max= Math.max(max, newsum);
}
return max;
}
}

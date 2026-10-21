class Solution {
    public int kthFactor(int n, int k) {
        //List<Integer> list=new ArrayList<>();
        int count=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                count++;

            }
            if(count==k){
                return i;
            }
        }
        //return list.get(k-1);
        return -1;
        
    }
}
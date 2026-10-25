class Solution {
    public int calculateScore(int a, int b) {
        int s1=0;
        int s2=0;
        String b1=Integer.toBinaryString(a);
        String b2=Integer.toBinaryString(b);
        for(int i=0;i<b1.length();i++){
            if(b1.charAt(i)=='1')
                s1++;
        }
        for(int i=0;i<b2.length();i++){
            if(b2.charAt(i)=='1')
                s2++;
        }
        
        if(s1>=s2){
            return s1*s2;
            
        }else{
            return s2/s1;
            
        }
          
        
    }
}
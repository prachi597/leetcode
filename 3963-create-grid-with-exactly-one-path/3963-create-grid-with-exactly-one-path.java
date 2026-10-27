class Solution {
    public String[] createGrid(int m, int n) {
        
        String str[] = new String[m];

        for(int i=0;i<m;i++)
        {
            StringBuilder sb = new StringBuilder();

            for(int j= 0; j < n ; j++ )
            {
                if(i==0 || j == n-1)
                {
                    sb.append('.');
                }else
                {
                    sb.append('#');
                }
            }
            //return back to the string 
            str[i]=sb.toString();
        }
        return str;
    }
}
import java.util.*;

class Solution {
    
    public Solution(){}
    
    public int pickIndex(int sum, ArrayList<Integer> w_cum){
        // for (Integer str : w_cum){ 		      
        //     System.out.print(str+", "); 		
        // }
        int idx = (int)(Math.random() * sum);
        return binarySearch(idx+1, w_cum);
    }
    
    private int binarySearch(int val, ArrayList<Integer> w_cum){  //O(logn)
        int l =0;
        int r = w_cum.size() -1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(w_cum.get(mid) < val){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return l; 
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] w = new int[]{40,10,20,30};
        int sum = 0;
        ArrayList<Integer> w_cum = new ArrayList<Integer>();
        
        for(int i=0;i<w.length;++i){
            sum +=w[i];
            w_cum.add(sum);
        }
        int totalWinner = sum;
        
        for(int i=1; i<=totalWinner; i++){ //O(n) => n=total number of winners
            int index = s.pickIndex(sum, w_cum);
            System.out.println("User:"+i+", NFT Index:"+index+"\n");
            w[index] = w[index]-1;
            w_cum.clear();
            sum=0;
            for(int a=0;a<w.length;++a){ //O(m) => m = total number of NFT
                sum +=w[a];
                w_cum.add(sum);
            }
            System.out.print("\n");
        }
    }
}

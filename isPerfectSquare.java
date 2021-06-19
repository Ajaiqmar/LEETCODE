class Solution {
    public boolean isPerfectSquare(int num) {
        long v = 0,i = 1;
        
        while(v<num)
        {
            v += i;
            i += 2;
        }
        
        if(v!=num)
        {
            return false;
        }
        return true;
    }
}

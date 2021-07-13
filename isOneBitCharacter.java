class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int index = 0;
        
        while(index < bits.length-1)
        {
            if(bits[index] == 1)
            {
                index += 2;
            }
            else
            {
                index += 1;
            }
        }
        
        return index == bits.length-1;   
    }
}

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxDuration = releaseTimes[0];
        char key = keysPressed.charAt(0);
        
        for(int i=1;i<releaseTimes.length;i++)
        {
            int duration = releaseTimes[i]-releaseTimes[i-1];
            
            if(duration > maxDuration)
            {
                maxDuration = duration;
                key = keysPressed.charAt(i);
            }
            else if(duration == maxDuration && keysPressed.charAt(i) > key)
            {
                key = keysPressed.charAt(i);
            }
        }
        
        return key;
    }
}

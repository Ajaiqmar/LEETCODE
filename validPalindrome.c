
bool validPalindrome(char * s)
{
    int left = 0,right = strlen(s)-1;
    
    while(left<right)
    {
        if(s[left] != s[right])
        {
            bool ans = false;
            int tleft = left+1,tright = right,flag = 0;
            
            while(tleft<tright)
            {
                if(s[tleft] != s[tright])
                {
                    flag = 1;
                    break;
                }
                tleft++;
                tright--;
            }
            
            if(flag == 0)
            {
                ans = true;
            }
            
            tleft = left;
            tright = right-1;
            flag = 0;
            
            while(tleft<tright)
            {
                if(s[tleft] != s[tright])
                {
                    flag = 1;
                    break;
                }
                tleft++;
                tright--;
            }
            
            if(flag == 0)
            {
                ans = true;
            }
            
            return ans;
        }
        left++;
        right--;
    }
    
    return true;
}

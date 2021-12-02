// THE PROBLEM STATEMENT IS TO CHECK WHETHER THE GIVEN STRING IS A PALINDROME AFTER REMOVING ATMOST ONE CHARACTER FROM THE STRING.

// MY APPROACH IS USE TWO POINTER APPROACH AND CHECK IF THE STRING IS A PALINDROME, WHILE TRAVERSING IF THE TWO POINTER VALUES DON'T MATCH
// THEN CHECK WHETHER THE REST OF THE STRING IS PALINDROME BY SKIPPING EITHER THE LEFT POINTER OR THE RIGHT POINTER, IF IT IS RETURN TRUE ELSE FALSE.

bool validPalindrome(char * s)
{
    int left = 0,right = strlen(s)-1;
    // CHECKING WHETHER THE GIVEN STRING IS A PALINDROME. 
    while(left<right)
    {
        if(s[left] != s[right])
        {
            bool ans = false;
            int tleft = left+1,tright = right,flag = 0;
            
            // CHECKING WHETHER THE GIVEN STRING IS A PALINDROME BY SKIPPING THE LEFT POINTER.
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
            
            // CHECKING WHETHER THE GIVEN STRING IS A PALINDROME BY SKIPPING THE RIGHT POINTER.
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

// TIME COMPLEXITY : O(N) WHERE N IS THE LENGTH OF THE GIVEN STRING.
// SPACE COMPLEXITY : O(1)

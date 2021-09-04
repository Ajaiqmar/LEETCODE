// THE PROBLEM STATEMENT IS RETURN A UNIQUE BINARY STRING OF LENGTH N WHICH IS NOT PRESENT IN THE GIVEN ARRAY NUMS, N IS ALSO THE LENGTH
// OF THE GIVEN ARRAY NUMS.

// MY APPROACH IS TO TRAVERSE THE GIVEN STRING ARRAY COLUMN WISE, IN EACH COLUMN CHECK THE NUMBER OF OCCURRENCES OF ONES AND ZEROS IF THEY AREN'T
// MARKED IN THE BOOLEAN ARRAY YET, IF THE 
// ONES ARE HIGHER, ADD ZERO TO THE ANS STRING AND MARK ALL THE ROWS TRUE IN THE BOOLEAN ARRAY WHICH HAS THE VALUE ONE, ELSE ADD ONE RO THE ANS STRING AND 
// MARK ALL THE ROWS TRUE IN THE BOOLEAN ARRAY WHICH HAS THE VALUE ONE. 

class Solution 
{
    public String findDifferentBinaryString(String[] nums) 
    {
        int n = nums.length;
        String ans = "";
        
        Boolean[] flag = new Boolean[n];
            
        // TRAVERSING THE NUMS ARRAY.
        for(int i=0;i<n;i++)
        {
            int countOfZeros = 0,countOfOnes = 0;
            
            for(int j=0;j<n;j++)
            {
                if(flag[j] == null)
                {
                    if(nums[j].charAt(i) == '0')
                    {
                        countOfZeros += 1;
                    }
                    else
                    {
                        countOfOnes += 1;
                    }
                }
            }
            
            if(countOfZeros < countOfOnes)
            {
                ans += '0';
                
                for(int j=0;j<n;j++)
                {
                    if(nums[j].charAt(i) == '1')
                    {
                        flag[j] = true;
                    }
                }
            }
            else
            {
                ans += '1';
                
                for(int j=0;j<n;j++)
                {
                    if(nums[j].charAt(i) == '0')
                    {
                        flag[j] = true;
                    }
                }
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(N)

// ANOTHER APPROACH I SAW ON THE DISCUSSION BOARD WAS THAT THIS PROBLEM COULD ALSO BE SOLVED IN O(N) TIME COMPLEXITY AND O(1) SPACE COMPLEXITY IT SEEMS.
// SO IN THIS APPROACH WE TRAVERSE FROM 0 TO N AS I , WE CHECK THE I-TH ROW AND I-TH CHARACTER, IF IT IS 1 WE ADD ZERO TO THE ANSWER, ELSE ONE TO THE ANSWER.
// THEREBY, MAKING IT THE UNIQUE ONE AMONG ALL THE CHARACTERS.

class Solution 
{
    public String findDifferentBinaryString(String[] nums) 
    {
        int n = nums.length;
        String ans = "";
        
        for(int i=0;i<n;i++)
        {
            if(nums[i].charAt(i) == '1')
            {
                ans += '0';
            }
            else
            {
                ans += '1';
            }
        }
        return ans;
    }
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)


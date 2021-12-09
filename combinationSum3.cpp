// THE PROBLEM STATEMENT IS TO RETURN AN ARRAY OF DIFFERENT COMBINATIONS OF LENGTH K WHOSE SUM IS EQUAL TO N. THE COMBINATIONS CAN CONTAIN ONLY NUMBERS FROM 0 TO 9.
// EACH NUMBERS CAN BE USED ATMOST ONCE.

// MY APPROACH IS TO USE A RECURSIVE FUNCTION CALLED "validCombination" FUNCTION WHERE WE WILL CHECK ALL THE COMBINATIONS OF LENGTH K AND WHETHER ITS SUM
// IS EQUAL TO N. IF IT IS APPEND THE ARRAY IN THE ANS 2D ARRAY. THEN FINALLY RETURN THE ANS ARRAY.

class Solution 
{
public:
    // RECURSIVE FUNCTION TO CHECK ALL THE COMBINATIONS OF LENGTH K.
    void validCombination(vector<vector<int>> &ans,int* arr,int ind,int k,int n,int sum)
    {
        if(ind == k)
        {
            if(sum == n)
            {
                vector<int> a;
                
                for(int i=0;i<k;i++)
                {
                    a.push_back(arr[i]);
                }
                
                ans.push_back(a);
            }
        }
        else
        {
            int s = -1;
            
            if(ind == 0)
            {
                s = 1;
            }
            else
            {
                s = arr[ind-1]+1;
            }
            
            for(int i=s;i<=9;i++)
            {
                arr[ind] = i;
                    
                validCombination(ans,arr,ind+1,k,n,sum+i);
            }
        }
    }
    
    vector<vector<int>> combinationSum3(int k, int n) 
    {
        vector<vector<int>> ans;
        int arr[k];
        int visited[10] = {0};
        
        validCombination(ans,arr,0,k,n,0);
        
        return ans;
    }
};

// TIME COMPLEXITY : O(K!/(9-K)!) 
// SPACE COMPLEXITY : O(K*M) WHERE M IS THE NUMBER OF COMBINATIONS OF LENGTH K WHOSE SUM IS EQUAL TO N.

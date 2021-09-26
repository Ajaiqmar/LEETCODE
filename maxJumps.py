# THE PROBLEM STATEMENT IS TO FIND THE MAXMUM NUMBER OF INDICES THAT CAN BE VISITED STARTING FROM ANY INDEX. FROM ANY INDEX I, WE CAN TRAVEL TO AN INDEX
# FROM I-D TO I+D, IF (I-D) >= 0 AND (I+D) < LENGTH OF THE GIVEN ARRAY AND WE CAN TRAVEL ONLY IF ALL THE VALUES OF THE INDICES IN BETWEEN ARE LESS THE THAN
# THE CURRENT INDEX VALUE. 

# MY APPROACH IS TO USE DYNAMMIC PROGRAMMING APPROACH WHERE DP[I] REPRESENTS THE MAXIMUM NUMBER OF INDICES THAT CAN BE VISITED FROM THE CURRENT INDEX
# FOLLOWING THE ABOVE RULES. FIRSTLY, WE NEED TO SORT ARRAY ALONG WITH THEIR CURRENT INDEX IN ASCENDING ORDER BECAUSE WE NEED FIND THE ONES WHICH CANNOT
# VISIT ANY INDICES OTHER THAN ITSELF AND WORK OUR WAY UP. FOR EACH INDEX, WE TRAVERSE THE SURROUNDING ONES, AND FIND THE ONE WHICH HAS VISITED MAXIMUM
# INDICES AND THEN ADD THAT TO THE CURRENT INDEX.

class Solution:
    def maxJumps(self, arr: List[int], d: int) -> int:
        n = len(arr)
        dp = [0 for i in range(n)]
        a = []
        ans = 0
        
        # TRAVERSING THE GIVEN ARRAY TO FORM A NEW ARRAY CONTAINING THE VALUE AND THEIR CORRESPONDING INDEX. 
        for i in range(n):
            a.append([arr[i],i])
        
        # SORTING THE ARRAY.
        a = sorted(a,key =(lambda x : x[0]))
        
        # TRAVERSING THE SORTED ARRAY TO FIND THE DP[I]
        for i in range(n):
            belowSkips = 0
            ind = a[i][1]
            
            for j in range(1,d+1):
                
                if((ind+j) < n and arr[ind+j] < arr[ind]):
                    belowSkips = max(belowSkips,dp[ind+j])
                else:
                    break
            
            for j in range(1,d+1):
                
                if((ind-j) >= 0 and arr[ind+-j] < arr[ind]):
                    belowSkips = max(belowSkips,dp[ind-j])
                else:
                    break
            
            dp[ind] = belowSkips+1
            ans = max(ans,dp[ind])
        
        return ans
      
# TIME COMPLEXITY : O(MAX(N*LOG N, N*D))
# SPACE COMPLEXITY : O(N)

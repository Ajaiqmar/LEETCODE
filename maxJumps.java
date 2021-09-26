// THE PROBLEM STATEMENT IS TO FIND THE MAXMUM NUMBER OF INDICES THAT CAN BE VISITED STARTING FROM ANY INDEX. FROM ANY INDEX I, WE CAN TRAVEL TO AN INDEX
// FROM I-D TO I+D, IF (I-D) >= 0 AND (I+D) < LENGTH OF THE GIVEN ARRAY AND WE CAN TRAVEL ONLY IF ALL THE VALUES OF THE INDICES IN BETWEEN ARE LESS THE THAN
// THE CURRENT INDEX VALUE.

// MY APPROACH IS TO USE RECURSION TO FIND THE MAXMIMUM INDICES A PARTICULAR INDEX CAN VISIT BY FOLLOWING THE ABOVE RULES AND THEN STORE THEM IN AN ARRAY TO AVOID,
// REPETITION OF THE SAME FUNCTION CALLS (MEMOIZATION). FIRSTLY, WE WILL BE INITIALISING MEM INTEGER ARRAY AND THE FLAG BOOLEAN ARRAY, FOR SAVING THE MAXIMUM
// INDICES THAT CAN BE VISITED IN MEM ARRAY AND MARKING THAT INDEX IN THE FLAG ARRAY. THEN MAKE THE FUNCTION CALLS FOR EACH INDEX, IF IT HASN'T BEEN
// ALREADY VISITED, THEN WE COULD DEDUCE THE MAXIMUM NUMBER OF INDICES THAT CAN BE VISITED IN THE ARRAY. IN THE FINDJUMPS FUNCTION, WE WILL
// BE TRAVERSING A DISTANCE OF D ON BOTH SIDES AND THEN RETURN VALUE OF THE INDEX THAT VISITS MAXMIMUM NODES.

class Solution {
    int[] mem = null;
    Boolean[] flag = null;
    
    // FUNCTION USED TO DEDUCE THE MAXIMUM VISITS MADE BY A PARTICULAR INDEX.
    public int findJumps(int ind,int d,int noOfSkips,int[] arr)
    {
        int skips = 0;
        
        for(int i=1;i<=d;i++)
        {
            if((ind+i) < arr.length && arr[ind+i] < arr[ind])
            {
                if(flag[ind+i] != null)
                {
                    skips = Math.max(skips,mem[ind+i]+noOfSkips+1);
                }
                else
                {
                    int jumps = findJumps(ind+i,d,noOfSkips+1,arr);
                    mem[ind+i] = jumps-(noOfSkips+1);
                    flag[ind+i] = true;
                    skips = Math.max(skips,jumps);
                }
            }
            else
            {
                break;
            }
        }
        
        for(int i=1;i<=d;i++)
        {
            if((ind-i) >= 0 && arr[ind-i] < arr[ind])
            {
                if(flag[ind-i] != null)
                {
                    skips = Math.max(skips,mem[ind-i]+noOfSkips+1);
                }
                else
                {
                    int jumps = findJumps(ind-i,d,noOfSkips+1,arr);
                    mem[ind-i] = jumps-(noOfSkips+1);
                    flag[ind-i] = true;
                    skips = Math.max(skips,jumps);
                }
            }
            else
            {
                break;
            }
        }
        
        return Math.max(skips,(noOfSkips+1));
    }
    public int maxJumps(int[] arr, int d) 
    {
        int ans = 0;
        mem = new int[arr.length];
        flag = new Boolean[arr.length];
        
        // TRAVERSING THE GIVEN ARRAY TO FIND MAXIMUM INDICES THAT CAN BE VISITED BY EACH INDEX.
        for(int i=0;i<arr.length;i++)
        {
            if(flag[i] == null)
            {
                int jumps = findJumps(i,d,0,arr);
                mem[i] = jumps;
                flag[i] = true;
                ans = Math.max(ans,jumps);
            }
            else
            {
                ans = Math.max(ans,mem[i]);
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N*V) WHERE V IS THE RECURSION DEPTH OR V IS THE MAXIMUM NUMBER OF INDICES THAT CAN BE VISITED BY ANY INDEX IN THE GIVEN ARRAY.
// SPACE COMPLEXITY : O(MAX(N,V))

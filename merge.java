// THE PROBLEM STATEMENT IS TO MERGE THE TWO SORTED ARRAYS AND FORM A SINGLE SORTED ARRAY. THE TOTAL LENGTH OF ARRAY NUMS1 IS M+N, IT CONTAINS
// VALUES ONLY TILL M AND THE REST OF THE VALUES IS INITIALISED TO ZERO.

// FOLLOW UP QUESTION IS TO SOLVE THEM IN O(M+N) TIME.

// MY APPROACH IS TO TRAVERSE BOTH THE ARRAY FROM REVERSE USING TWO POINTERS, WHILE TRAVERSING WE CHECK WHICH INTEGER IS GREATER FROM THE TWO POINTERS.
// IF THE INTEGER IS FROM NUMS1, THEN WE SWAP WITH THE VALUE IN INDEX IND ELSE IF THE INTEGER IS FROM NUMS2 THEN WE SET THE VALUE AT INDEX IND EQUAL TO THAT INTEGER.
// IF THERE ARE RESIDUAL INTEGERS IN THE NUMS2 ARRAY, THEN WE SET THE REST OF THE VALUES TO THEIR CORRESONDING IND VALUE IN THE NUMS1 ARRAY.

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ind = (m+n)-1,l = m-1,r = n-1;
        
        // TRAVERSING THE NUMS1 AND NUMS2 ARRAY FROM THE RIGHT TO LEFT.
        while(l >= 0 && r >= 0)
        {
            if(nums1[l] >= nums2[r])
            {
                int temp = nums1[l];
                nums1[l] = nums1[ind];
                nums1[ind] = temp;
                l -= 1;
                ind -= 1;
            }
            else
            {
                nums1[ind] = nums2[r];
                r -= 1;
                ind -= 1;
            }
        }
        
        while(r >= 0)
        {
            nums1[ind] = nums2[r];
            r -= 1;
            ind -= 1;
        }
    }
}

// TIME COMPLEXITY : O(M+N)
// SPACE COMPLEXITY : O(1)

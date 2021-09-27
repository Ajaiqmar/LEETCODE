// THE PROBLEM STATEMENT IS TO RETURN COUNT OF PALINDROMIC SUBSTRINGS PRESENT IN THE GIVEN STRING.

// MY APPROACH IS THAT EVERY PALINDROMIC STRING HAS ONE OR TWO CENTER DEPENDING ON WHETHER THE LENGTH IS ODD OR EVEN RESPECTIVELY, SO
// WE WILL BE TRAVERSING THE ARRAY AND CONSIDERING EACH INDEX TO BE THE CENTER OF AN ODD LENGTH PALINDROMIC STRING AND WE WILL ALSO BE
// CONSIDERING EACH INDEX AND THEIR NEXT INDEX TO BE THE CENTER OF AN EVEN LENGTH PALINDROMIC STRING, THEN TRAVERSING IT ON BOTH SIDES UNTIL BOTH
// CHARACTERS ARE EQUAL, FOR EACH INCREMENT OF LEFT AND RIGHT POINTER, WE WILL BE INCREMENTING THE ANSWER AS IT CAN BE CONSIDERED
// AS A SEPERATE PALINDROMIC SUBSTRING.

class Solution 
{
    public int countSubstrings(String s) 
    {
        int n = s.length();
        int ans = 0;
        
        // TRAVERSING THE GIVEN STRING.
        for(int i=0;i<n;i++)
        {
            int left = i,right = i;
            
            // CONSIDERING THE ODD LENGTH PALINDROMIC SUBSTRING.
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right))
            {
                ans += 1;
                left-=1;
                right+=1;
            }
            
            left = i;
            right = i+1;
            
            // CONSIDERING THE EVEN LENGTH PALINDROMIC SUBSTRING.
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right))
            {
                ans += 1;
                left-=1;
                right+=1;
            }
        }
        
        return ans;
    }
}

// TIME COMPLEXITY : O(N*M) WHERE M IS THE MAX LENGTH OF SUBSTRING.
// SPACE COMPLEXITY : O(1)

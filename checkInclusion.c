// THE PROBLEM STATEMENT IS TO CHECK WHETHER ANY PERMUTATION OF STRING S1 IS A SUBSTRING OF STRING S2.

// MY APPROACH IS TO USE A COMBINATION OF HASHTABLE AND SLIDING WINDOW TECHNIQUE, FIRST WE CHECK IF THE LENGTH OF STRING S1 IS LESSER THAN STRING S2 IF IT IS NOT
// WE RETURN FALSE, ELSE
// THEN WE SAVE ALL THE CHARACTER OCCURRENCES OF STRING S1 IN A HASHTABLE. WE ALSO NEED TO STORE THE CHARACTER OCCURRENCES OF STRING S2 UPTO THE LENGTH OF
// STRING S1 IN A SEPERATE HASHTABLE. THEN WE TRAVERSE THE REST OF THE STRING , WHILE TRAVERSING WE CHECK WHETHER BOTH THE HASHTABLES ARE EQUAL.
// IF IT IS RETURN TRUE. ELSE INSERT THE NEW CHARACTER ONTO THE HASHTABLE AND REMOVE THE CHARACTER FROM THE BEGINNING FROM THE HASH TABLE.

bool checkInclusion(char * s1, char * s2)
{
    // CHECKING WHETHER THE LENGTH OF STRING S1 IS LESSER THAN STRING S2
    if(strlen(s1) > strlen(s2))
    {
        return false;
    }
    
    int hs1[26] = {0};
    
    // STORING THE VALUES OF STRING S1 ONTO THE HASHTABLE.
    for(int i=0;i<strlen(s1);i++)
    {
        hs1[s1[i]-'a'] += 1;
    }
    
    int hs2[26] = {0};
    
    // STORING THE VALUES OF STRING S2 ONTO THE HASHTABLE.
    for(int i=0;i<strlen(s1);i++)
    {
        hs2[s2[i]-'a'] += 1;
    }
    
    int ind = strlen(s1),slidingIndex = 0;
    
    // TRAVERSING THE REMAINING CHARACTERS OF STRING S2.
    while(ind < strlen(s2))
    {
        for(int i=0;i<26;i++)
        {
            if(hs1[i] != hs2[i])
            {
                return true;
            }
        }
        
        hs2[s2[slidingIndex]-'a'] -= 1;
        hs2[s2[ind]-'a'] += 1;
        ind += 1;
        slidingIndex += 1;
    }
    
    for(int i=0;i<26;i++)
    {
        if(hs1[i] != hs2[i])
        {
            return true;
        }
    }
    
    return false;
}

// TIME COMPLEXITY : O(26 * LENGTH OF STRING S2)
// SPACE COMPLEXITY : O(1)

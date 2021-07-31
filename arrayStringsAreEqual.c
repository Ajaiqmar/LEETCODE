// THE PROBLEM STATEMENT IS TO CHECK IF THE TWO ARRAYS REPRESENT THE SAME STRING AND RETURN TRUE OR FALSE.
// THE STRING IS REPRESENTED BY AN ARRAY IF THE ARRAY ELEMENTS CONCATENATED IN ORDER FORMS THE STRING.

// MY APPROACH IS TO SIMPLY TRAVERSE THROUGH THE CHARACTER MATRIX USING A WHILE LOOP AND CHECK WHETHER THEY ARE EQUAL.
// AT THE END, WE ALSO NEED TO CHECK THE INDEX POSTITION OF THE VARIABLES IN THE MATRIX.

bool arrayStringsAreEqual(char ** word1, int word1Size, char ** word2, int word2Size)
{
    int i = 0,j = 0,k = 0,l = 0;
    
    // TRAVERSING THE CHARACTER MATRIX TO CHECK FOR EQUALITY. 
    while(i<word1Size && k<word2Size)
    {
        if(word1[i][j] != word2[k][l])
        {
            return false;
        }
        j++;
        l++;
        
        if(strlen(word1[i]) == j)
        {
            i++;
            j = 0;
        }
        
        if(strlen(word2[k]) == l)
        {
            k++;
            l = 0;
        }
    }
    
    // CONDITION TO CHECK THE INDEX POSITION OF THE VARIABLES.
    if(i == word1Size && k == word2Size)
    {
        return true;
    }
    
    return false;
}

// TIME COMPLEXITY : O(N) WHERE N IS THE LENGTH OF THE STRING.
// SPACE COMPLEXITY : O(1)

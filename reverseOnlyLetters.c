// TWO-POINTER APPROACH

char * reverseOnlyLetters(char * s)
{
    int i=0,j=strlen(s)-1;
    
    while(i<j)
    {
        if(isalpha(s[i]) && isalpha(s[j]))
        {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            
            i++;
            j--;
        }
        if(!isalpha(s[i]))
        {
            i++;
        }
        if(!isalpha(s[j]))
        {
            j--;
        }
    }
    
    return s;
}

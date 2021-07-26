bool areOccurrencesEqual(char * s)
{
    int alphabets[26]={0};
    
    for(int i=0;i<strlen(s);i++)
    {
        alphabets[s[i]-'a']++;
    }
    
    for(int i=1;i<strlen(s);i++)
    {
        if(alphabets[s[i]-'a'] != alphabets[s[i-1]-'a'])
        {
            return false;
        }
    }
    
    return true;
}

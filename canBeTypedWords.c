int canBeTypedWords(char * text, char * brokenLetters)
{
    int flag = 1,ans = 0;
    int alphabets[26] = {0};
    
    for(int i=0;i<strlen(brokenLetters);i++)
    {
        alphabets[brokenLetters[i]-'a'] = 1;
    }
    
    for(int i=0;i<=strlen(text);i++)
    {
        if(text[i] == ' ' || text[i] == '\0')
        {
            if(flag)
            {
                ans++;
            }
            flag = 1;
        }
        else if(alphabets[text[i]-'a'] && flag)
        {
            flag = 0;
        }
    }
    
    return ans;
}

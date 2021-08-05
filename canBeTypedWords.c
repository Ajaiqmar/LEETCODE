// THE PROBLEM STATEMENT IS TO CHECK HOW MANY WORDS CAN BE TYPED IN A MALFUNCTIONING KEYBOARD WHERE SOME LETTER KEYS DO NOT WORK.

// MY APPROACH IS TO TRAVERSE THE BROKENLETTERS STRING AND MARK ALL THE CHARCTERS WHICH ARE BROKEN IN A HASHTABLE. AND THEN TRAVERSE THE TEXT STRING TO CHECK HOW MANY WORDS
// CAN BE TYPED USING THE BROKEN KEYBOARD.

int canBeTypedWords(char * text, char * brokenLetters)
{
    int flag = 1,ans = 0;
    int alphabets[26] = {0};
    
    // TRAVERSING THE BROKENLETTERS STRING
    for(int i=0;i<strlen(brokenLetters);i++)
    {
        alphabets[brokenLetters[i]-'a'] = 1;
    }
    
    // TRAVERSING THE TEXT STRING
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

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)

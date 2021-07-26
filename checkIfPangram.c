bool checkIfPangram(char * sentence)
{
    int alphabets[26] = {0},countOfAlphabets = 0;
    
    for(int i=0;i<strlen(sentence);i++)
    {
        if(alphabets[sentence[i]-'a'] == 0)
        {
            alphabets[sentence[i]-'a']++;
            countOfAlphabets++;
        }
    }
    
    return (countOfAlphabets == 26);
}

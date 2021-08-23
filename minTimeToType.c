// THE PROBLEM STATEMENT IS TO RETURN THE MINIMUM TIME REQUIRED TO TYPE OUT THE GIVEN WORD USING A CIRCULAR TYPE WRITER.
// IN A SECOND, YOU COULD EITHER MOVE THE POINTER IN CLOCKWISE OR ANTI-CLOCKWISE DIRECTION ELSE YOU COULD PRINT THE CURRENT CHARACTER.

// MY APPROACH IS TO FIRST SET THE MIN TIME VARIABLE TO THE LENGTH OF THE WORD BECAUSE IT TAKES ONE SECOND TO TYPE UP ALL THE WORDS, NOW INORDER
// TO CALCULATE THE MINIMUM NUMBER OF MOVEMENTS WE HAVE TO CALCULATE WHICH DISTANCE IS SHORTER CLOCKWISE OR ANTI-CLOCKWISE AND THEN TAKE THAT PATH AND INCREMENT THE
// THE MIN TIME VARIABLE.

int minTimeToType(char * word)
{
    char currWord = 'a';
    int minTime = strlen(word);
    
    // TRAVERSING THE GIVEN WORD TO CALCULATE THE MINIMUM NUMBER OF CHARACTERS.
    for(int i=0;i<strlen(word);i++)
    {
        int cd,acd;
        
        if(word[i] >= currWord)
        {
            cd = word[i]-currWord;
            acd = (currWord-'a')+('z'-word[i])+1;
        }
        else
        {
            cd = (word[i]-'a')+('z'-currWord)+1;
            acd = currWord-word[i];
        }
        
        currWord = word[i];
        
        minTime += ((cd<acd)?cd:acd);
    }
    
    return minTime;
}

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)

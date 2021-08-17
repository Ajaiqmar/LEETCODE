// THE PROBLEM STATEMENT IS TO CHECK IF THE GIVEN SENTENCE IS A PANGRAM. A SENTENCE IS SAID TO BE A PANGRAM IF IT CONTAINS
// ALL THE LOWERCASE LETTERS IN THE SENTENCE.

// MY APPROACH IS TO USE A HASH TABLE AND NOTE THE OCCURRENCE OF EACH NEW CHARACTER USING THE HASH TABLE AND ALSO INCREMENTING THE COUNT OF ALPHABETS VALUE.
// IF THE VALUE IS EQUAL TO 26 RETURN TRUE ELSE RETURN FALSE.

bool checkIfPangram(char * sentence)
{
    int alphabets[26] = {0},countOfAlphabets = 0;
    
    // TRAVERSING THE GIVEN SENTENCE TO CHECK IF IT IS A PANGRAM.
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

// TIME COMPLEXITY : O(N)
// SPACE COMEPLEXITY : O(1) SINCE THE NUMBER OF LETTERS IN THE ALPHABETS DOESN'T GROW LINEARLY.

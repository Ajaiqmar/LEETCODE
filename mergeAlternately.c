char * mergeAlternately(char * word1, char * word2){
    char* ans = (char*)malloc(sizeof(char)*(strlen(word1)+strlen(word2)+1));
    int ansIndex = 0,word1Index = 0,word2Index = 0;
    
    while(word1Index!=strlen(word1) && word2Index!=strlen(word2))
    {
        ans[ansIndex++] = word1[word1Index++];
        ans[ansIndex++] = word2[word2Index++];
    }
    
    while(word1Index!=strlen(word1))
    {
        ans[ansIndex++] = word1[word1Index++];
    }
    
    while(word2Index!=strlen(word2))
    {
        ans[ansIndex++] = word2[word2Index++];
    }
    
    ans[ansIndex++] = '\0';
    
    return ans;
}

int firstUniqChar(char * s){
    int hashTable[26] = {0};
    
    for(int i=0;i<strlen(s);i++)
    {
        hashTable[s[i]-'a'] += 1;
    }
    
    for(int i=0;i<strlen(s);i++)
    {
        if(hashTable[s[i]-'a'] == 1)
        {
            return i;
        }
    }
    
    return -1;
}

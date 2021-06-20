bool canConstruct(char * ransomNote, char * magazine){
    int hashTable[26]={0};
    
    for(int i=0;i<strlen(magazine);i++)
    {
        hashTable[magazine[i]-'a'] += 1;
    }
    
    for(int i=0;i<strlen(ransomNote);i++)
    {
        if(hashTable[ransomNote[i]-'a'] == 0)
        {
            return false;
        }
        hashTable[ransomNote[i]-'a'] -= 1;
    }
    
    return true;
}

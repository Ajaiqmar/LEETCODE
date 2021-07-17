int numSpecialEquivGroups(char ** words, int wordsSize){
    int flag[1001] = {0},groups = 0;
    
    for(int i=0;i<wordsSize;i++)
    {
        if(flag[i] == 0)
        {
            flag[i] = 1;
            groups++;
            int evenIndex[26]={0},oddIndex[26]={0};
            
            for(int j=0;j<strlen(words[i]);j++)
            {
                if(j%2 == 0)
                {
                    evenIndex[words[i][j]-'a']++;
                }
                else
                {
                    oddIndex[words[i][j]-'a']++;
                }
            }
            
            for(int j=0;j<wordsSize;j++)
            {
                if(flag[j] == 0)
                {
                    int tempEvenIndex[26]={0},tempOddIndex[26]={0},f=0;
                
                    for(int k=0;k<strlen(words[j]);k++)
                    {
                        if(k%2 == 0)
                        {
                            tempEvenIndex[words[j][k]-'a']++;
                        }
                        else
                        {
                            tempOddIndex[words[j][k]-'a']++;
                        }
                    }
                    
                    for(int k=0;k<26;k++)
                    {
                        if(evenIndex[k] != tempEvenIndex[k] || oddIndex[k] != tempOddIndex[k])
                        {
                            f = 1;
                            break;
                        }
                    }
                    
                    if(f == 0)
                    {
                        flag[j] = 1;
                    }
                }
            }
        }
    }
    
    return groups;
}

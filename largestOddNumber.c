char * largestOddNumber(char * num){
    
    char* ans = (char*)malloc(sizeof(char)*strlen(num)+1);
    
    int endIndex = strlen(num)-1;
    
    while(endIndex>=0 && num[endIndex]!='1' && num[endIndex]!='3' && num[endIndex]!='5' && num[endIndex]!='7' && num[endIndex]!='9')
    {
        endIndex--;
    }
    
    if(endIndex == -1)
    {
        ans[0] = '\0';
    }
    else
    {
        for(int i=0;i<=endIndex;i++)
        {
            ans[i] = num[i];
        }
        ans[endIndex+1] = '\0';
    }
    
    return ans;
}

int* shortestToChar(char * s, char c, int* returnSize)
{
    int* ans = (int*)malloc(sizeof(int)*strlen(s));
    int* occurrence = (int*)malloc(sizeof(int)*strlen(s));
    *returnSize = strlen(s);
    int index = 0;
    
    for(int i=0;i<strlen(s);i++)
    {
        if(s[i] == c)
        {
            occurrence[index++] = i;
        }
    }
    
    int i=0,j=0;
    
    while(i<strlen(s))
    {
        if(j == index)
        {
            ans[i] = abs(occurrence[j-1]-i);
            i++;
        }
        else if(j == 0)
        {
            ans[i] = abs(occurrence[j]-i);
            i++;
        }
        else
        {
            int a = abs(occurrence[j]-i);
            int b = abs(occurrence[j-1]-i);
            
            ans[i] = ((a<b)?a:b);
            i++;
        }
        
        if(j<index && i > occurrence[j])
        {
            j++;
        }
    }
    
    return ans;
}

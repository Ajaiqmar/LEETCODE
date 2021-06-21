int countSegments(char * s)
{
    int ans = 0;
    char* words = strtok(s," ");
    
    while(words!=NULL)
    {
        ans+=1;
        words = strtok(NULL," ");
    }
    return ans;
}

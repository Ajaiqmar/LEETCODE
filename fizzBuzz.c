char ** fizzBuzz(int n, int* returnSize){
    
    *returnSize = n;
    char** ans = (char**)malloc(sizeof(char*)*n);
    
    for(int i=0;i<n;i++)
    {
        ans[i] = (char*)malloc(sizeof(char)*10);
        strcpy(ans[i],"");
        
        char f[] = "Fizz";
        char b[] = "Buzz";
        
        if((i+1)%3==0)
        {
            strcat(ans[i],f);
        }
        
        if((i+1)%5==0)
        {
            strcat(ans[i],b);
        }
        
        if(strcmp(ans[i],"")==0)
        {
            sprintf(ans[i],"%d",(i+1));
        }
        
    }
    
    return ans;
}

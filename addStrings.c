char * addStrings(char * num1, char * num2){
    
    int l1 = strlen(num1)-1, l2 = strlen(num2)-1,r = 0,i = 0;
    char* ans = (char*)malloc(sizeof(char)*10002);
    
    
    while(l1>=0 && l2>=0)
    {
        int x = num1[l1]-'0';
        int y = num2[l2]-'0';
        
        ans[i] = '0'+((x+y+r)%10);
        r = (x+y+r)/10;
        
        l1 -= 1;
        l2 -= 1;
        i += 1;
    }
    
    while(l1>=0)
    {
        int x = num1[l1]-'0';
        
        ans[i] = '0'+((x+r)%10);
        r = (x+r)/10;
        
        l1 -= 1;
        i += 1;
    }
    
    while(l2>=0)
    {
        int y = num2[l2]-'0';
        
        ans[i] = '0'+((y+r)%10);
        r = (y+r)/10;
        
        l2 -= 1;
        i += 1;
    }
    
    if(r!=0)
    {
        ans[i] = '0'+r;
        i+=1;
    }
    
    for(int j=0,k=i-1;j<k;j++,k--)
    {
        char temp = ans[j];
        ans[j] = ans[k];
        ans[k] = temp;
    }
    
    ans[i] = '\0';
    i += 1;
    
    return ans;
}

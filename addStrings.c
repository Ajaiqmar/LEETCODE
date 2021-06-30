char * addStrings(char * num1, char * num2){
    
    int num1Length = strlen(num1)-1, num2Length = strlen(num2)-1,carry = 0,index = 0;
    char* ans = (char*)malloc(sizeof(char)*10002);
    
    
    while(num1Length>=0 && num2Length>=0)
    {
        int x = num1[num1Length]-'0';
        int y = num2[num2Length]-'0';
        
        ans[i] = '0'+((x+y+carry)%10);
        carry = (x+y+carry)/10;
        
        num1Length -= 1;
        num2Length -= 1;
        index += 1;
    }
    
    while(num1Length>=0)
    {
        int x = num1[num1Length]-'0';
        
        ans[index] = '0'+((x+carry)%10);
        carry = (x+carry)/10;
        
        num1Length -= 1;
        index += 1;
    }
    
    while(num2Length>=0)
    {
        int y = num2[num2Length]-'0';
        
        ans[index] = '0'+((y+carry)%10);
        carry = (y+carry)/10;
        
        num2Length -= 1;
        index += 1;
    }
    
    if(carry!=0)
    {
        ans[index] = '0'+carry;
        index+=1;
    }
    
    for(int j=0,k=i-1;j<k;j++,k--)
    {
        char temp = ans[j];
        ans[j] = ans[k];
        ans[k] = temp;
    }
    
    ans[index] = '\0';
    index += 1;
    
    return ans;
}

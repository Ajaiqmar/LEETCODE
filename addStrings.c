// THE PROBLEM STATEMENT IS TO ADD THE STRINGS WHICH ARE IN INTEGER FORMAT AND RETURN THE SUM.
// TEST CASE 1: S1 = "123" , S2 = "1" , ANSWER = "124"

// MY APPROACH IS TO TRAVERSE THE TWO STRINGS FROM THE LAST INDEX, AT EACH INDEX ADD THE VALUES ALONG WITH THE CARRY OVER VALUE, AND STORE IT IN CHARACTER FORMAT FROM INDEX 0.
// AT THE END REVERSE THE STRING WHICH CONTAINS THE SUM.

char * addStrings(char * num1, char * num2){
    
    int num1Length = strlen(num1)-1, num2Length = strlen(num2)-1,carry = 0,index = 0;
    char* ans = (char*)malloc(sizeof(char)*10002);
    // ANS VARIABLE WILL CONTAIN THE SUM VALUE.
    
    //TRAVERSING FROM THE LAST INDEX OF STRING 1 AND STRING 2.
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
    
    // CHECKING FOR ANY RESIDUAL INDEX IN STRING 1
    while(num1Length>=0)
    {
        int x = num1[num1Length]-'0';
        
        ans[index] = '0'+((x+carry)%10);
        carry = (x+carry)/10;
        
        num1Length -= 1;
        index += 1;
    }
    
    // CHECKING FOR ANY RESIDUAL INDEX IN STRING 2
    while(num2Length>=0)
    {
        int y = num2[num2Length]-'0';
        
        ans[index] = '0'+((y+carry)%10);
        carry = (y+carry)/10;
        
        num2Length -= 1;
        index += 1;
    }
    
    // CHECKING FOR ANY RESIDUAL CARRY OVER VALUE
    if(carry!=0)
    {
        ans[index] = '0'+carry;
        index+=1;
    }
    
    // REVERSE THE SUM VALUE
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

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)

int isSelfDividing(int x)
{
    int n = x;
    
    while(n!=0)
    {
        if(n%10 == 0 || (x%(n%10)) != 0)
        {
            return 0;
        }
        n = n/10;
    }
    
    return 1;
}

int* selfDividingNumbers(int left, int right, int* returnSize){
    int* ans = (int*)malloc(sizeof(int)*10001);
    int index = 0;
    
    for(int i=left;i<=right;i++)
    {
        if(isSelfDividing(i))
        {
            ans[index++] = i;
        }
    }
    
    *returnSize = index;
    
    return ans;
}

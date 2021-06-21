int thirdMax(int* nums, int numsSize){
    int fm = INT_MIN,sm = INT_MIN,tm = INT_MIN,c = 0,flag = 0;
    
    for(int i=0;i<numsSize;i++)
    {
        if(nums[i]>fm)
        {
            tm = sm;
            sm = fm;
            fm = nums[i];
            c += 1;
        }
        else if(nums[i]>sm && nums[i]<fm)
        {
            tm = sm;
            sm = nums[i];
            c += 1;
        }
        else if(nums[i]>tm && nums[i]<fm && nums[i]<sm)
        {
            tm = nums[i];
            c += 1;
        }
        else if(nums[i] == INT_MIN && flag == 0)
        {
            c += 1;
            flag = 1;
        }
    }
    
    if(c < 3)
    {
        return fm;
    }
    else
    {
        return tm;
    }
}

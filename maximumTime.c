char * maximumTime(char * time)
{
    if(time[0] == '?' && time[1] == '?')
    {
        time[0] = '2';
        time[1] = '3';
    }
    else if(time[0] == '?' && isdigit(time[1]))
    {
        int val = time[1]-'0';
        if(val > 3)
        {
            time[0] = '1';
        }
        else
        {
            time[0] = '2';
        }
    }
    else if(isdigit(time[0]) && time[1] == '?')
    {
        int val = time[0]-'0';
        if(val == 2)
        {
            time[1] = '3';
        }
        else
        {
            time[1] = '9';
        }
    }
    
    if(time[3] == '?' && time[4] == '?')
    {
        time[3] = '5';
        time[4] = '9';
    }
    else if(time[3] == '?' && isdigit(time[4]))
    {
        time[3] = '5';
    }
    else if(isdigit(time[3]) && time[4] == '?')
    {
        time[4] = '9';
    }
    
    return time;
}

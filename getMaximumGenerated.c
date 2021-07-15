

int getMaximumGenerated(int n)
{
    int* sequence = (int*)malloc(sizeof(int)*(n+1));
    int max = 0;
    
    for(int i=0;i<=n;i++)
    {
        if(i == 0)
        {
            sequence[i] = 0;
        }
        else if(i == 1)
        {
            sequence[i] = 1;
        }
        else
        {
            if(i%2 == 0)
            {
                sequence[i] = sequence[i/2];
            }
            else
            {
                sequence[i] = sequence[i/2]+sequence[(i/2)+1];
            }
        }
        
        if(sequence[i] > max)
        {
            max = sequence[i];
        }
    }
    
    return max;
}

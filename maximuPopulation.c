int maximumPopulation(int** logs, int logsSize, int* logsColSize){
    
    int totalYears[2051] = {0},maxPopulation = 0,year = 0;
    
    for(int i=0;i<logsSize;i++)
    {
        for(int j=logs[i][0];j<logs[i][1];j++)
        {
            totalYears[j] += 1;
        }
    }
    
    for(int i=1950;i<=2050;i++)
    {
        if(totalYears[i] > maxPopulation)
        {
            maxPopulation = totalYears[i];
            year = i;
        }
    }
    
    return year;
}

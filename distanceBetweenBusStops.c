int distanceBetweenBusStops(int* distance, int distanceSize, int start, int destination){
    int s = start,d = destination;
    int clockWiseCost = 0,antiClockWiseCost = 0;
    
    while(s != d)
    {
        clockWiseCost += distance[s];
        s++;
        if(s == distanceSize)
        {
            s = 0; 
        }
    }
    
    s = start;
    
    while(d != s)
    {
        antiClockWiseCost += distance[d];
        d++;
        if(d == distanceSize)
        {
            d = 0; 
        }
    }
    
    return ((clockWiseCost < antiClockWiseCost)?clockWiseCost:antiClockWiseCost);
}

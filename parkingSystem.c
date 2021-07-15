typedef struct 
{
    int* carType;
} ParkingSystem;


ParkingSystem* parkingSystemCreate(int big, int medium, int small) 
{
    ParkingSystem* obj = (ParkingSystem*)malloc(sizeof(ParkingSystem));
    obj->carType = (int*)malloc(sizeof(int)*4);
    
    obj->carType[1] = big;
    obj->carType[2] = medium;
    obj->carType[3] = small;
    
    return obj;
}

bool parkingSystemAddCar(ParkingSystem* obj, int carType) 
{
    if(obj->carType[carType] == 0)
    {
        return false;
    }
    obj->carType[carType] -= 1;
    return true;
}

void parkingSystemFree(ParkingSystem* obj) 
{
    free(obj);
}

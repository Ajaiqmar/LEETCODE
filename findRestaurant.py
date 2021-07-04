class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        restaurants = {}
        minimumIndexSum = sys.maxsize
        
        for i in range(len(list1)):
            restaurants[list1[i]] = i
        
        for i in range(len(list2)):
            if list2[i] in restaurants:
                restaurants[list2[i]] += i
                if(restaurants[list2[i]] < minimumIndexSum):
                    minimumIndexSum = restaurants[list2[i]]
                restaurants[list2[i]] = -restaurants[list2[i]]
                
        return [i for i in restaurants if restaurants[i] == -minimumIndexSum]

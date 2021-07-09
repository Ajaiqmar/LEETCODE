class Solution:
    def traversal(self,employees,id):
        importanceValue = 0
        for i in range(len(employees)):
            if(employees[i].id == id):
                importanceValue += employees[i].importance
                
                for j in employees[i].subordinates:
                    importanceValue += self.traversal(employees,j)
                
        return importanceValue
    
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        return self.traversal(employees,id)
                

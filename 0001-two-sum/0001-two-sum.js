var twoSum = function(nums, target) {
    const tempMap = new Map();
    
    for (let i = 0; i < nums.length; i++) {
        let result = target - nums[i];
        
        if (tempMap.has(result)) {
            return [i, tempMap.get(result)];
        }
        
        tempMap.set(nums[i], i);
    }
};
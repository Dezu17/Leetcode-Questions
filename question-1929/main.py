def getConcatenation(nums: List[int]) -> List[int]:
    result = [0] * len(nums) * 2
    for index in range(len(nums)):
        result[index] = nums[index]
        result[index + len(nums)] = nums[index]
    return result

print(getConcatenation([1,2,3]))
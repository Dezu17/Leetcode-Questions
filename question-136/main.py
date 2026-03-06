def singleNumber(nums: List[int]) -> int:
    result = nums[0]
    for index in range(1, len(nums)):
        result ^= nums[index]
    return result

nums = [2,2,1]
print(singleNumber(nums))
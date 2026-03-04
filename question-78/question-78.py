def backtrack(count: int, currentIndex: int, currentList:list[int], nums: list[int], result: list[list[int]]) -> List[List[int]]:
    for index in range(currentIndex, len(nums)):
        currentList.append(nums[index])
        result.append(currentList.copy())
        backtrack(count, index + 1, currentList, nums, result)
        currentList.pop()
    return result


def subsets(nums: List[int]) -> List[List[int]]:
    return [[]] + backtrack(len(nums), 0, [], nums, []).copy()

result = subsets(nums=[0])
print(result)
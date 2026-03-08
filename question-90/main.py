def pivot(nums: list[int], left: int, right: int) -> int:
    pivotIndex = left - 1
    pivot = nums[right]
    for index in range(left, right):
        if nums[index] < pivot:
            pivotIndex += 1
            nums[pivotIndex], nums[index] = nums[index], nums[pivotIndex]
    pivotIndex += 1
    nums[pivotIndex], nums[right] = nums[right], nums[pivotIndex]
    return pivotIndex

def quickSort(nums: list[int], left: int, right: int):
    if left < right:
        p = pivot(nums, left, right)
        quickSort(nums, left, p - 1)
        quickSort(nums, p + 1, right)

def backtrack(count: int, currentIndex: int, currentList:list[int], addedLists: dict, nums: list[int], result: list[list[int]]) -> List[List[int]]:
    for index in range(currentIndex, len(nums)):
        currentList.append(nums[index])
        if tuple(currentList) not in addedLists:
            result.append(currentList.copy())
            addedLists[tuple(currentList)] = 1
        backtrack(count, index + 1, currentList, addedLists, nums, result)
        currentList.pop()
    return result


def subsetsWithDup(nums: List[int]) -> List[List[int]]:
    quickSort(nums, 0, len(nums) - 1)
    return [[]] + backtrack(len(nums), 0, [], {}, nums, [])

result = subsetsWithDup(nums=[4,4,4,1,4])
print(result)
def containsDuplicate(nums: list[int]) -> bool:
    seenNumbers = {}
    for index in range(0, len(nums)):
        if nums[index] in seenNumbers:
            return True
        else:
            seenNumbers[nums[index]] = 1
    return False

print(containsDuplicate([2, 1, 3, 6, 7, 5, 2, 4]))
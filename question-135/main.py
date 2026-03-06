def candy(ratings: List[int]) -> int:
    left = [1] * len(ratings)
    right = [1] * len(ratings)
    for index in range(1, len(ratings)):
        if ratings[index - 1] < ratings[index]:
            left[index] = left[index - 1] + 1
    for index in range(len(ratings) - 2, -1, -1):
        if ratings[index] > ratings[index + 1]:
            right[index] = right[index + 1] + 1
    result = 0
    for index in range(0, len(ratings)):
        if left[index] > right[index]:
            result += left[index]
        else:
            result += right[index]
    return result

ratings = [1,0,2]
print(candy(ratings))
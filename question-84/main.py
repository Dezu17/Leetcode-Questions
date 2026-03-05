def largestRectangleArea(heights: List[int]) -> int:
    maxArea = 0
    stack = []
    for index in range(0, len(heights)):
        while len(stack) != 0 and heights[index] <= heights[stack[len(stack) - 1]]:
            top = stack.pop()
            if len(stack) != 0:
                width = index - stack[len(stack) - 1] - 1
            else:
                width = index
            if width * heights[top] > maxArea:
                maxArea = width * heights[top]
        stack.append(index)
    while len(stack) != 0:
            top = stack.pop()
            if len(stack) != 0:
                width = len(heights) - stack[len(stack) - 1] - 1
            else:
                width = len(heights)
            if width * heights[top] > maxArea:
                maxArea = width * heights[top]
    return maxArea

arr = [60, 20, 50, 40, 10, 50, 60]
print(largestRectangleArea(arr))
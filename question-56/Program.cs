using System.Collections;

public class Program
{
    private static int Pivot(int[][] nums, int low, int high)
    {
        int pivot = nums[high][0];
        int pivotIndex = low - 1;
        int[] aux = new int[2];
        for (int i = low; i < high; i++) 
            if (nums[i][0] < pivot)
            {
                aux = nums[++pivotIndex];
                nums[pivotIndex] = nums[i];
                nums[i] = aux;
            }
        aux = nums[++pivotIndex];
        nums[pivotIndex] = nums[high];
        nums[high] = aux;
        return pivotIndex;
    }
    private static void QuickSort(int[][] nums, int low, int high)
    {
        if (low < high)
        {
            int pivotIndex = Pivot(nums, low, high);
            QuickSort(nums, low, pivotIndex - 1);
            QuickSort(nums, pivotIndex + 1, high);
        }
    }
    public static int[][] Merge(int[][] intervals) {
        ArrayList mergedIntervals =  new ArrayList();
        QuickSort(intervals, 0, intervals.Length - 1);
        int currentLowerBound = intervals[0][0], currentUpperBound = intervals[0][1];
        for (int index = 1; index < intervals.Length; index++)
            if (intervals[index][0] <= currentUpperBound ) {
                if (intervals[index][1] >= currentUpperBound)
                    currentUpperBound = intervals[index][1];
            }
            else
            {
                mergedIntervals.Add(new int[] {currentLowerBound, currentUpperBound});
                currentLowerBound = intervals[index][0];
                currentUpperBound = intervals[index][1];
            }
        mergedIntervals.Add(new int[] {currentLowerBound, currentUpperBound});
        int[][] result = new int[mergedIntervals.Count][];
        for (int index = 0; index < mergedIntervals.Count; index++)
            result[index] = (int[])mergedIntervals[index];
        return result;
    }
    public static void Main(string[] args)
    {
        int[][] intervals = new int[][] { new int[] { 1, 4 }, new int[] { 1, 5 } };
        int[][] mergedIntervals = Merge(intervals);
        foreach (int[] interval in mergedIntervals)
            Console.WriteLine($"[{interval[0]}, {interval[1]}]");
    }
}
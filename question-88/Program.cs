public class Program
{
    public static void Merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        Array.Copy(nums1, nums1Copy, m);
        int index1 = 0, index2 = 0, indexMerged = 0;
        while (index1 < m && index2 < n)
            if (nums1Copy[index1] < nums2[index2])
                nums1[indexMerged++] = nums1Copy[index1++];
            else
                nums1[indexMerged++] = nums2[index2++];
        while (index1 < m)
            nums1[indexMerged++] = nums1Copy[index1++];
        while (index2 < n)
            nums1[indexMerged++] = nums2[index2++];
    }
    public static void Main(string[] args)
    {
        int[] nums1 = new int[] { 1, 3, 5, 0, 0, 0 };
        int[] nums2 = new int[] { 2, 4, 6 };
        Merge(nums1, 3, nums2, 3);
        for (int i = 0; i < nums1.Length; i++)
        {
            Console.Write(nums1[i] + " ");
        }
    }
}
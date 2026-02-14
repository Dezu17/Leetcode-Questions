public class App {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int low = 0, high = nums1.length;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = (nums1.length + nums2.length + 1) / 2 - mid1;
            int left1 = (mid1 <= 0 ? Integer.MIN_VALUE : nums1[mid1 - 1]);
            int right1 = (mid1 >= nums1.length ? Integer.MAX_VALUE : nums1[mid1]);
            int left2 = (mid2 <= 0 ? Integer.MIN_VALUE : nums2[mid2 - 1]);
            int right2 = (mid2 >= nums2.length ? Integer.MAX_VALUE : nums2[mid2]);
            if (left1 <= right2 && left2 <= right1) {
                if ((nums1.length + nums2.length) % 2 == 0)
                    return ((Math.max(left1, left2) + Math.min(right1, right2)) / 2.0);
                else
                    return Math.max(left1, left2);
            } else if (left1 > right2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int[] a = { 1, 2 };
        int[] b = { 3, 4 };
        System.out.print("Result: " + findMedianSortedArrays(a, b));
    }
}

package inflearn;

public class BinarySearchBound {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5, 6, 7};
        int target = 3;

        int lower = lowerBound(arr, target);
        int upper = upperBound(arr, target);
        int count = countTarget(arr, target);

        System.out.println("Lower bound index: " + lower);
        System.out.println("Upper bound index: " + upper);
        System.out.println("Count of target: " + count);
    }

    // Lower Bound: target 이상의 값이 처음 나타나는 위치
    public static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Upper Bound: target 초과의 값이 처음 나타나는 위치
    public static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int countTarget(int[] arr, int target) {
        return upperBound(arr, target) - lowerBound(arr, target);
    }
}

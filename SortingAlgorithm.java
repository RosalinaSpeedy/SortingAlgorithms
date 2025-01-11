import java.lang.reflect.Array;
import java.util.Arrays;

public class SortingAlgorithm {

	// Q1
	// Time O(N^2) | Space O(1)
	private static int[] hybridSort(int[] array) {// Do not edit
		// Your Answer
		int minVal = 0;
		boolean swap = false;
		for (int i = 0; i < array.length; i++) {
			minVal = i;
			for (int j = i; j < array.length - 1; j++) {
				if (array[j + 1] < array[j]) {
					swap = true;
					swap(array, j, j + 1);
				}
				if (array[j] < array[minVal]) {
					minVal = j;
				}
			}
			if (!swap) {
				break;
			}
			swap = !swap;
			if (i != minVal && array[i] > array[minVal]) {
				swap(array, i, minVal);
			}
		}
		return array;
	}

	// Q2
	// Time O(M*N) | Space O(1)
	private static int[] organiserSort(int[] array, int[] order) {// Do not edit
		// Your Answer
		int count = 0;
		int lastPos = 0;
		for (int i = 0; i < order.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[j] == order[i]) {
					count++;
					swap(array, count + lastPos - 1, j);
				}
			}
			lastPos += count;
			count = 0;
		}
		return array;
	}

	// Q3
	// Time O(N + k) | Space O(N + k)
	private static int[] modifiedCountingSort(int[] array) {// Do not edit
		// Your Answer
		int max = 0;
		int min = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
			if (array[i] < min) {
				min = array[i];
			}
		}
		int zeroPoint = 0;
		// create count array
		int[] count;
		if (min < 0) {
			count = new int[-min + max + 1];
			zeroPoint = (-1) * min;
		} else {
			count = new int[max + 1];
		}
		// populate count array
		for (int i = 0; i < array.length; i++) {
			count[array[i] + zeroPoint]++;
		}
		// sort array
		int arrayIdx = 0, countIdx = 0;
		while (countIdx < -min + max + 1) {
			if (count[countIdx] > 0) {
				array[arrayIdx++] = -zeroPoint + countIdx;
				count[countIdx]--;
			} else {
				countIdx++;
			}
		}
		return array;
	}

	// Q4
	// Time O(N + k) | Space O(n + k)
	private static int[] mountainSort(int[] array) {// Do not edit
		// Your Answer
		int max = 0;
		int min = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
			if (array[i] < min) {
				min = array[i];
			}
		}
		int zeroPoint = 0;
		// create count array
		int[] count;
		if (min < 0) {
			count = new int[-min + max + 1];
			zeroPoint = (-1) * min;
		} else {
			count = new int[max + 1];
		}
		// populate count array
		for (int i = 0; i < array.length; i++) {
			count[array[i] + zeroPoint]++;
		}
		// sort array
		int arrayIdx = 0, countIdx = 0;
		while (countIdx < (-min + max + 1) / 2 && arrayIdx <= array.length / 2 - 1) {
			if (count[countIdx] > 0) {
				array[arrayIdx++] = -zeroPoint + countIdx;
				count[countIdx]--;
			} else {
				countIdx++;
			}
		}
		countIdx = -min + max;
		while (countIdx > 0 && arrayIdx > array.length / 2 - 1) {
			if (count[countIdx] > 0) {
				array[arrayIdx++] = -zeroPoint + countIdx;
				count[countIdx]--;
			} else {
				countIdx--;
			}
		}
		return array;
	}

	private static void swap(int[] array, int i, int j) {// Do not edit
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}

	public static void main(String[] args) {
		// You can edit here for your own testing
		int[] array = { 12, 12, 24, -12, 44, 0, -1, 5, 1, 45, 45, 46, 7 };
		int[] array2 = { 9, 8, 7, 6 };
		int[] array3 = { -1, -1, 2, 12, 4, 5, 4, 12, 0, 1, 12, 1, 0, -1, 2, -1, 2, 2, 13, 2 };
		int[] array4 = { 12, 12, 24, -12, 44, 0, -1, 5, 1, 45, 45, 46, 7 };
		int[] array5 = { 2, 4, 6, 5, 4, 67, 65, -9, -100, 45, 45, -100, 23, 23, 5, 67 };
		int[] array6 = { 34, 12, 7, 43, 55, 97, 41, 28, 2, 62 };
		int[] array7 = { 1, 123, 55, 22, 55, 5, 232, 28, 2, 62, 89, 45 };
		int[] array8 = { 34, 24, 7, 43, 55, 97, 41, 28 };
		int[] array9 = { 34, 12, 7, 7, 7, 97 };
		int[] array10 = { };
		int[] array11 = { 12 };
		int[] array12 = { 4, 4, 4, 4, 4, 4 };
		int[] order1 = { 0, 2, -1, 4, 5, 12 };
		System.out.println("Hybrid sort tests:");
		System.out.println(Arrays.toString(hybridSort(array)));
		System.out.println(Arrays.toString(hybridSort(array2)));
		System.out.println(Arrays.toString(hybridSort(array10)));
		System.out.println(Arrays.toString(hybridSort(array11)));
		System.out.println(Arrays.toString(hybridSort(array12)));
		System.out.println("Organiser sort tests (0,2,-1,4,5,12):");
		System.out.println(Arrays.toString(organiserSort(array3, order1)));
		System.out.println(Arrays.toString(organiserSort(array10, order1)));
		System.out.println(Arrays.toString(organiserSort(array11, order1)));
		System.out.println(Arrays.toString(organiserSort(array12, order1)));
		System.out.println("Modified counting sort tests:");
		System.out.println(Arrays.toString(modifiedCountingSort(array4)));
		System.out.println(Arrays.toString(modifiedCountingSort(array5)));
		System.out.println(Arrays.toString(modifiedCountingSort(array10)));
		System.out.println(Arrays.toString(modifiedCountingSort(array11)));
		System.out.println(Arrays.toString(modifiedCountingSort(array12)));
		System.out.println("Mountain sort tests:");
		System.out.println(Arrays.toString(mountainSort(array6)));
		System.out.println(Arrays.toString(mountainSort(array7)));
		System.out.println(Arrays.toString(mountainSort(array8)));
		System.out.println(Arrays.toString(mountainSort(array9)));
		System.out.println(Arrays.toString(mountainSort(array10)));
		System.out.println(Arrays.toString(mountainSort(array11)));
		System.out.println(Arrays.toString(mountainSort(array12)));
	}
}
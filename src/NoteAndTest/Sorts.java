package NoteAndTest;

/**
 * (1)空间占用 不占用额外内存或者占用常数内存：插入排序、选择排序、冒泡排序、堆排序、快速排序 占用的：归并排序、计数排序、基数排序、通排序，
 * 当对大量排序时，不占内存优势会大 (2)是否稳定排序 稳定：插入排序、冒泡排序、归并排序、基数排序 不稳定：选择排序、堆排序、快速排序、计数排序
 * 参考：(1)http://blog.csdn.net/guanhang89/article/details/51902378
 * (2)http://blog.csdn.net/pzhtpf/article/details/7560294
 * (3)http://blog.csdn.net/hello_word2/article/details/54929308
 */
public class Sorts {

	private boolean Less(int k, int j) {
		// TODO Auto-generated method stub
		return k < j;
	}

	private void exChange(int[] a, int i, int n) {
		// TODO Auto-generated method stub
		int temp = a[i];
		a[i] = a[n];
		a[n] = temp;
	}

	/**
	 * 冒泡排序
	 * 
	 * @param array
	 * @return
	 */
	public int[] BubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				// 降序
				if (array[i] > array[j]) {
					exChange(array, i, j);
				}
				// 升序
				// if(array[i]<array[j]) {
				// exChange(array,i,j);
				// }
			}
		}
		return array;
	}

	/**
	 * 选择排序,每次选择一个最大或最小的数值
	 * 
	 * @param array
	 * @return
	 */
	public int[] SelectSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (array[j] < array[min])
					min = j;
			}
			exChange(array, i, min);
		}
		return array;
	}

	/**
	 * 希尔排序
	 * 
	 * @param array
	 * @return
	 */
	public int[] ShellSort(int[] array) {
		int n = array.length;
		int h = 1;
		while (h < n / 3) {
			h = 3 * h + 1;
		}
		while (h >= 1) {
			for (int i = h; i < n; i++) {
				for (int j = i; j >= h && (array[j] < array[j - h]); j -= h) {
					exChange(array, j, j - h);
				}
			}
			h /= 3;
		}
		return array;
	}

	/**
	 * 快速排序
	 * 
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	public int[] QuickSort(int[] array, int low, int high) {
		if (high > low) {
			int key = Partition(array, low, high);
			QuickSort(array, low, key - 1);
			QuickSort(array, key + 1, high);
		}
		return array;
	}

	/**
	 * 一次划分
	 * 
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	private int Partition(int[] array, int low, int high) {
		int i = low;
		int j = high + 1;
		int v = array[low];
		while (true) {
			while (array[++i] < v)
				if (i == high)
					break;
			while (v < array[--j])
				if (j == low)
					break;
			if (i >= j) {
				break;
			}
			exChange(array, i, j);
		}
		exChange(array, low, j);
		return j;
	}

	public void HeapSort(int[] a) {
		int N = a.length;
		int[] keys = new int[N + 1];
		// 注意，堆的数据结构是从1开始的，0不用
		for (int i = 1; i < keys.length; i++) {
			keys[i] = a[i - 1];
		}
		// //构造堆,使得堆是有序的
		for (int k = N / 2; k >= 1; k--)
			sink(keys, k, N);
		// 排序，相当于毁掉堆
		while (N > 1) {
			exChange(keys, 1, N--);
			sink(keys, 1, N);
		}
		// 重新写回数组
		for (int i = 0; i < a.length; i++) {
			a[i] = keys[i + 1];
		}
	}

	private void sink(int[] a, int k, int N) {
		// TODO Auto-generated method stub
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && a[j] < a[j + 1])
				j++;
			if (a[j] < a[k])
				break;
			exChange(a, k, j);
			k = j;
		}
	}
}

package NoteAndTest;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

/**
 * (1)空间占用 不占用额外内存或者占用常数内存：插入排序、选择排序、冒泡排序、堆排序、快速排序 占用的：归并排序、计数排序、基数排序、通排序，
 * 当对大量排序时，不占内存优势会大 (2)是否稳定排序 稳定：插入排序、冒泡排序、归并排序、基数排序 不稳定：选择排序、堆排序、快速排序、计数排序
 * 参考：(1)http://blog.csdn.net/guanhang89/article/details/51902378
 * (2)http://blog.csdn.net/pzhtpf/article/details/7560294
 * (3)http://blog.csdn.net/hello_word2/article/details/54929308
 */
public class Sorts {

	/**
	 * 根据数组位置进行交换
	 * @param a
	 * @param i
	 * @param n
	 */
	private void exChange(int[] a, int i, int n) {
		// TODO Auto-generated method stub
		int temp = a[i];
		a[i] = a[n];
		a[n] = temp;
	}

	/**
	 * 冒泡排序1
	 * 外层循环每进行一次，有一个最大或最小值放到最后，知道排序完毕
	 * 步骤：
	 * 1）输入数组 ：int [] in= {4,7,2,1,5,8,6,15,4};
	 * 2）每一步输出数组：
	 * 		4 7 2 1 5 8 6 15 4
	 *		4 2 1 5 7 6 8 4 15
	 *		2 1 4 5 6 7 4 8 15
	 *		1 2 4 5 6 4 7 8 15
	 *		1 2 4 5 4 6 7 8 15
	 *		1 2 4 4 5 6 7 8 15
	 *		1 2 4 4 5 6 7 8 15
	 *		1 2 4 4 5 6 7 8 15
	 *		1 2 4 4 5 6 7 8 15
	 * @param array
	 * @return
	 */
	public int[] BubbleSort1(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				// 升序
				if (array[j] > array[j + 1]) {
					exChange(array, j, j + 1);
				}
			}
		}
		return array;
	}
	
	/**
	 * 冒泡排序2
	 * 每一步，使最外层i之前的有序，最后整个数组有序
	 * 步骤：
	 * 1）输入数组 ：int [] in= {4,7,2,1,5,8,6,15,4};
	 * 2）每一步输出数组：
	 * 		4 7 2 1 5 8 6 15 4
	 * 		4 7 2 1 5 8 6 15 4
	 * 		4 7 2 1 5 8 6 15 4
	 * 		2 4 7 1 5 8 6 15 4
	 * 		1 2 4 7 5 8 6 15 4
	 * 		1 2 4 5 7 8 6 15 4
	 * 		1 2 4 5 7 8 6 15 4
	 * 		1 2 4 5 6 7 8 15 4
	 * 		1 2 4 5 6 7 8 15 4
	 * 		1 2 4 4 5 6 7 8 15
	 * @param array
	 * @return
	 */
	public int[] BubbleSort2(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				// 升序
				if (array[i] < array[j]) {
					exChange(array, i, j);
				}
			}
		}
		return array;
	}

	/**
	 * 冒泡排序3 改进的冒泡排序
	 * 外层循环每进行一次，有一个最大或最小值放到最后，知道排序完毕
	 * 在方法BubbleSort1的基础上加上交换标志，
	 * 如果在这次循环中没有发生过交换，即所有的元素都有序了，则不用进行下一次循环，结束排序
	 * 步骤：
	 * 1）输入数组 ：int [] in= {4,7,2,1,5,8,6,15,4};
	 * 2）每一步输出数组：
	 * 		4 7 2 1 5 8 6 15 4
	 *		4 2 1 5 7 6 8 4 15
	 *		2 1 4 5 6 7 4 8 15
	 *		1 2 4 5 6 4 7 8 15
	 *		1 2 4 5 4 6 7 8 15
	 *		1 2 4 4 5 6 7 8 15
	 * 由此可以看出，比较次数减少
	 * @param array
	 * @return
	 */
	public int[] BubbleSort3(int[] array) {
		boolean isSort = true;
		for (int i = 0; i < array.length; i++) {
			isSort = false;
			for (int j = 0; j < array.length - i - 1; j++) {
				// 升序
				if (array[j] > array[j + 1]) {
					exChange(array, j, j + 1);
					isSort = true;
				}
			}
			if (!isSort) {
				break;
			}
		}
		return array;
	}
	/**
	 * 冒泡排序3 改进的冒泡排序
	 * 外层循环每进行一次，有一个最大或最小值放到最后，知道排序完毕
	 * 在方法BubbleSort3的基础上进一步思考：
	 * 如果R[0..i]已是有序区间，上次的扫描区间是R[i..n]，
	 * 记上次扫描时最后 一次执行交换的位置为lastSwapPos，
	 * 则lastSwapPos在i与n之间，不难发现R[i..lastSwapPos]区间也是有序的，
	 * 否则这个区间也会发生交换；所以下次扫描区间就可以由R[i..n]缩减到[lastSwapPos..n]。
	 * 步骤：
	 * 1）输入数组 ：int [] in= {4,7,2,1,5,8,6,15,4};
	 * 2）每一步输出数组：
	 * 		4 7 2 1 5 8 6 15 4
	 *		4 2 1 5 7 6 8 4 15
	 *		2 1 4 5 6 7 4 8 15
	 *		1 2 4 5 6 4 7 8 15
	 *		1 2 4 5 4 6 7 8 15
	 *		1 2 4 4 5 6 7 8 15
	 * 由此可以看出，比较次数减少
	 * @param array
	 * @return
	 */
	public int[] BubbleSort4(int[] array) {
		int lastSwapPos = 0, lastSwapPosTemp = 0;
		for (int i = 0; i < array.length; i++) {
			lastSwapPos = lastSwapPosTemp;
			for (int j = 0; j < array.length - i - 1; j++) {
				// 升序
				if (array[j] > array[j + 1]) {
					exChange(array, j, j + 1);
					lastSwapPosTemp = j;
				}
			}
			if (lastSwapPos == lastSwapPosTemp) {
				break;
			}
		}
		return array;
	}
	/**
	 * 冒泡排序3 改进的冒泡排序
	 * 传统的冒泡算法每次排序只确定了最大值，我们可以在每次循环之中进行正反两次冒泡，
	 * 分别找到最大值和最小值，如此可使排序的轮数减少一半。
	 * 步骤：
	 * 1）输入数组 ：int [] in= {4,7,2,1,5,8,6,15,4};
	 * 2）每一步输出数组：
	 * 		1 4 2 4 5 7 6 8 15
	 *		1 2 4 4 5 6 7 8 15
	 *		1 2 4 4 5 6 7 8 15
	 *		1 2 4 4 5 6 7 8 15
	 * 由此可以看出，比较次数减少一半
	 * @param array
	 * @return
	 */
	public int[] BubbleSort5(int[] array) {
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			
			// 正向冒泡，确定最大值
			for (int i = low; i < high; ++i) {
				// 如果前一位大于后一位，交换位置
				if (array[i] > array[i + 1]) {
					exChange(array, i, i + 1);
				}
			}
			high--;

			// 反向冒泡，确定最小值
			for (int j = high; j > low; --j) {
				// 如果前一位大于后一位，交换位置
				if (array[j] < array[j - 1]) {
					exChange(array, j, j - 1);
				}
			}
			low++;
		}
		return array;
	}

	/**
	 * 选择排序,每次选择一个最大或最小的数值
	 * 从i+1到n选出最小或最大值与第i位数值交换，直到遍历完成
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
	 * 选择排序优化,
	 * 每次同时选择一个最大和最小的数值，直到遍历完成
	 * @param array
	 * @return
	 */
	public int[] SelectSort1(int[] array) {
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			int min = low;
			int max = high;
			for (int i = low; i <= high; i++) {
				if (array[i] < array[min])
					min = i;
				if (array[i] > array[max])
					max = i;
			}
			// 考虑修正的情况，最大值在最小位置，最小值在最大位置。
			exChange(array, max, high);

			if (min == high) {
				min = max;
			}
			exChange(array, min, low);
			low++;
			high--;
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
	 * 快速排序 自身递归版
	 * 
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	public void QuickSort(int[] array, int low, int high) {
		int i, j, index;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        index = array[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && array[j] >= index) {
            	j--;
            }
            //用比基准小的记录替换低位记录,比基准小的移
            if (i < j) {
            	array[i++] = array[j];
            }
            	
            while (i < j && array[i] < index) {
            	i++;
            }
            //用比基准大的记录替换高位记录    
//            if (i < j) {
            	array[j--] = array[i];
//            } 
        }
        array[i] = index;// 将基准数值替换回 array[i]
        QuickSort(array, low, i - 1); // 对低子表进行递归排序
        QuickSort(array, i + 1, high); // 对高子表进行递归排序
	}
	
	/**
	 * 快速排序
	 * 
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	public int[] QuickSort1(int[] array, int low, int high) {
		if (high > low) {
			int key = Partition(array, low, high);
			QuickSort(array, low, key - 1);
			QuickSort(array, key + 1, high);
		}
		return array;
	}
	
	/**
	 * 一次划分
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	private int Partition(int[] array,int low,int high) {
		int i=low;
		int j=high;
		int index=array[i];
		while(i<j) {
			while(i<j&&array[j]>=index) {
				j--;
			}
			if(i<j) {
				array[i++] = array[j];
			}
			while(i<j&&array[i]<index) {
				i++;
			}
			array[j--] = array[i];
		}
		array[i] = index;
		return i;
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

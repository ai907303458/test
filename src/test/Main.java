package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import com.sun.org.apache.bcel.internal.generic.ReturnaddressType;
import com.sun.swing.internal.plaf.basic.resources.basic;

import jdk.nashorn.internal.ir.ReturnNode;

public class Main {
	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);
		// int count = in.nextInt();
		// int sum=0;
		// int [] tmp=new int[count];
		// int [] tree=new int[count];
		//
		// for(int i=0;i<count;i++) {
		// tree[i]=in.nextInt();
		// }
		// for(int i=0;i<count;i++) {
		// tmp[i]=0;
		// for(int j=i;j<count;j++) {
		// if(i==j) {
		// tmp[i]++;
		// continue;
		// }
		// if(tree[i]<tree[j]) {
		// if(tree[j]>tree[j++]) {
		// tmp[i]=tmp[i]+1;
		// }
		// }
		// }
		// if(sum<tmp[i]) {
		// sum=tmp[i];
		// }
		// }
		int [][] tmp2= {{426,306,641,372,477,409},
						{223,172,327,586,363,553},
						{292,645,248,316,711,295},
						{127,192,495,208,547,175},
						{131,448,178,264,207,676},
						{655,407,309,358,246,714}};
		int [][] tmp= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int [] a= {5,7,6,9,11,10,8};
		int [] s= {3,5,7,2,7,6};
		String [] test= {"i am a coder","Coder Coder","Code"};
//		System.out.println(findMaxGap(s,6));
//		int [] te=printMatrix(tmp,4,4);
//		System.out.println(findLCS("1A2C3D4B56",10,"B1D23CA45B6A",12));
//		for(int i=0;i<te.length;i++) {
//			for(int j=0;j<te[0].length;j++) {
//				System.out.print(te[i]+",");
//			}
//			System.out.print("\n");
//		}
//		for(int i=0;i<test.length-1;i++) {
//			System.out.println("left:"+getMax(test,0,i));
//			System.out.println("right:"+getMax(test,i+1,test.length-1));
//		}
//		System.out.println(getMax(test,0,2));
//		System.out.println(getMax(test,3,4));
//		System.out.print(Arrays.toString(findCoder(test,3)));
//		System.out.println(findCoder(test, 3));
		Map<String, Integer> map=findCoder(test, 3);
		for(Map.Entry<String, Integer> entry : map.entrySet()){  
		    System.out.println(entry.getKey()+","+entry.getValue());  
		} 
	}

	public static String[] findCoder1(String[] A, int n) {
		// write code here
		return A;
	}
	
	public static Map<String, Integer> findCoder(String[] A, int n) {
		// write code here
		Map<String, Integer> map = new HashMap<String, Integer>();
		int count = 0;
		int start = 0;
		for (int i = 0; i < n; i++) {
			String str = A[i].toLowerCase();
			if (str.contains("coder")) {
				while (str.indexOf("coder", start) >= 0 && start < str.length()) {
					count++;
					start = str.indexOf("coder", start) + "coder".length();
				}
				map.put(str, count);
			}
		}
		
//		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
//		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//				return (o2.getValue()-o1.getValue());
//			}
//		});
//		Set<String> sets = map.keySet();
//		return (String[]) sets.toArray(new String[sets.size()]);
		return map;
	}
	public static int getPos(int[] A, int n, int val) {
        // write code here
        if(n<=0){
            return -1;
        }
        int low=0;
        int high=n;
        while(low<high) {
        	int mid=(low+high)/2;
        	if(A[mid]==A[low]) {
        		return low;
        	}
        	if(A[mid]==val) {
        		return mid;
        	}else if(A[mid]>val){
        		high=mid;
        	}else {
        		low=mid;
        	}
        }
        return -1;
        
    }
	public static char findFirstRepeat(String A, int n) {
        // write code here
		 HashSet hs=new HashSet();
	        for(int i=0;i<n;i++){
	            if(!hs.add(A.charAt(i))){
	                return A.charAt(i);
	            }
	        }
	        return 0;
    }
	
	public static int[] gifts(int[] gifts,int n){
		int tmp=0;
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1;j++) {
				if(gifts[j]>gifts[j+1]) {
					tmp=gifts[j+1];
					gifts[j+1]=gifts[j];
					gifts[j]=tmp;
				}
			}
		}
		return gifts;
	}
	public static int getValue(int[] gifts, int n) {
        // write code here
		if(n<=0) {
			return 0;
		}
		int tmp;
        int count=0;
        int sum=0;
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1;j++) {
				if(gifts[j]>gifts[j+1]) {
					tmp=gifts[j+1];
					gifts[j+1]=gifts[j];
					gifts[j]=tmp;
				}
			}
		}
        tmp=gifts[0];
        for(int i=0;i<n;i++){
            if(tmp==gifts[i]){
                count++;
                if(sum<count){
                    sum=count;
                }
            }else{
                tmp=gifts[i];
                count=0;
            }
        }
        if(sum<(n/2)){
            return 0;
        }
		if(n%2==1) {
			return gifts[n/2];
		}
		return (gifts[(n-1)/2]+gifts[(n+1)/2])/2;
    }
	
	public static String rotateString(String A, int n, int p) {
        // write code here
        char [] B=new char[n];
        char [] tmp=new char[p+1];
        for(int i=0;i<n;i++) {
        	if(i<=p) {
        		B[n-p+i-1]=A.charAt(i);
        	}else {
        		B[i-p-1]=A.charAt(i);
        	}

        }
//        for(int i=0;i<=p;i++) {
//        	B[n-p+i-1]=tmp[i];
//        }
        return String.valueOf(B);
    }
	
	 public static int[] printMatrix(int[][] mat, int n, int m) {
	        // write code here
		 int[] A = new int[n*m];
		 int p=0;
		 for(int i=0;i<n;i++) {
			 if(i%2==0) {
				 for(int j=0;j<m;j++) {
					 A[p++]=mat[i][j];
				 }
			 }else {
				 for(int j=m-1;j>=0;j--) {
					 A[p++]=mat[i][j];
				 }
			 }
		 }
		 return A;
	    }
	public static int[] arrayPrint(int[][] arr, int n) {
	      // write code here
		int[] A = new int[n*n];
        int p = 0;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n-i;j++){
                A[p] = arr[j][i+j];
                A[n*n-1-p] = arr[n-1-j][n-1-i-j];
                p++;
            } 
        }
        return A;
	  }
	public static int[][] findLCS(String A, int n, String B, int m) {
        // 行对应A，比A长1，原因是0作为初始化。列同理。dp[n][m]指A[n-1],B[m-1]
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }
        //事实上，数组默认也是0
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //如果是字符串，用equals，由于charAt()是字符，可以运算，故可以用==
                if(A.charAt(i-1)==B.charAt(j-1)){//A[0]==B[0],对应dp[1][1]
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp;
    }
	public static int getMost(int[][] board) {
        // write code here
        int [][] tmp=new int[6][6];
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
            	int c=board[i][j];
                if(i==0&&j==0){
                    tmp[i][j]=c;
                }else if(i==0){
                    tmp[i][j]=tmp[i][j-1]+c;
                }else if(j==0){
                    tmp[i][j]+=tmp[i-1][j]+c;
                }else{
                    tmp[i][j]+=Math.max(tmp[i][j-1],tmp[i-1][j])+c;
                }
            }
          }
        return tmp[5][5];
    }
	
	public static int findLongest(String A, int n, String B, int m) {
        // write code here
		char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if(a[i]==b[j])
                {
                    dp[i+1][j+1]=dp[i][j]+1;
                    if(max<dp[i+1][j+1])
                        max=dp[i+1][j+1];
                }
            }
        }//for
        return max;
    }
	public static int findMaxGap(int[] A, int n) {
		if (A.length <= 0) {
			return 0;
		}
		int max = 0;
		for (int i = 0; i < n - 1; i++) {
			int left = getMax(A, 0, i);
			int right = getMax(A, i+1, n - 1);
			if (max < Math.abs(left-right)) {
				max = Math.abs(left-right);
			}
		}
		return max;
//		int max=A[0],min;
//        for(int i=0;i<n;i++) {
//        	if(A[i]>max)
//                max=A[i];
//        }
//        min=A[0]>A[n-1]?A[n-1]:A[0];  
//        return max-min;
	}

	public static int getMax(int[] A, int start, int end) {
		if (A.length <= 0) {
			return 0;
		}
		int max = A[start];
		for (int i = start; i <=end; i++) {
			if (max < A[i]) {
				max = A[i];
			}
		}
		return max;
		// write code here
	}
	
	public static int countBitDiff(int m, int n) {
//		if(m) {}
		String str=Integer.toBinaryString(m^n);
		int count=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='1') {
				count++;
			}
		}
		return count;

    }
	public static int calcDistance(int A, int B, int C, int D) {
		return calHigh(A)+calHigh(B)+calHigh(C)+calHigh(D);
        // write code here
    }
	public static int calHigh(int high) {
		int sum=0;
		while(high>0) {
			sum+=(high);
			high/=2;
			
		}
		return sum;
	}
	/**
	 * 二叉搜索树的后序遍历
	 * @param sequence
	 * @return
	 */
	public static boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence.length<=0) {
			return false;
		}
		if(sequence.length==1) {
			return true;
		}
        return isBSF(sequence,0,sequence.length-1);
    }
	public static boolean isBSF(int [] sequence,int start,int end) {
		if(start>end) {
			return true;
		}
		int count=end;
		while(count>start&&sequence[count-1]>sequence[end]) {
			count--;
		}
		for(int i=0;i<count-1;i++) {
			if(sequence[i]>sequence[end]) {
				return false;
			}
		}
		
		return isBSF(sequence,start,count-1)&&isBSF(sequence,count,end-1);
	}
	/*public static boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) {
			return false;
		}
		Stack<Integer> st = new Stack<Integer>();
		int i = 0;
		int j = 0;

		st.push(pushA[i++]);
		while (j <= popA.length - 1) {
			while (popA[j] != st.peek()) {
				if (i == pushA.length)
					return false;
				st.push(pushA[i++]);
			}
			j++;
			st.pop();
		}
		return true;
	}*/
	/*public static ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int rows = matrix.length;
		int columns = matrix[0].length;
		if (rows <= 0) {
			return list;
		}
		int start = 0;
		while (columns > start * 2 && rows > start * 2) {
			print(matrix, columns, rows, start,list);
			start++;
		}
		return list;
	}

	public static ArrayList<Integer> print(int[][] matrix, int columns, int rows, int start,ArrayList<Integer> list) {
		int endx = columns - 1 - start;
		int endy = rows - 1 - start;
		for (int i = start; i <= endx; ++i) {
			list.add(matrix[start][i]);
		}
		if (start < endy) {
			for (int i = start + 1; i <= endy; ++i) {
				list.add(matrix[i][endx]);
			}
		}
		if (start < endy && start < endx) {
			for (int i = endx - 1; i >= start; --i) {
				list.add(matrix[endy][i]);
			}
		}
		if (start < endy - 1 && start < endx) {
			for (int i = endy - 1; i >= start+1; --i) {
				list.add(matrix[i][start]);
			}
		}
		return list;
	}*/
	/**
	 * 1的个数，用位与运算
	 * @param n
	 * @return
	 */
	 /*public static int NumberOf1(int n) {
		 if(n==0) {
			 return 0;
		 }
		 int res=0;
		 String string=Integer.toBinaryString(n);
		 for(int i=0;i<string.length();i++) {
			 if(string.charAt(i)=='1') {
				 res++;
			 }
		 }
		return res;

	    }*/
	
	/**
	 * Fibonacci数列
	 * @param n
	 * @return
	 */
	/*public static int Fibonacci(int n) {
		if(n>39||n<=0){
            return 0;
        }
		if(n==1) {
			return 1;
		}
		int res=0;
		int one=0;
		int two=1;
		for(int i=2;i<=n;i++) {
			res=one+two;
			one=two;
			two=res;
		}
		return res;
        
    }
	public static int Fibonacci1(int n) {
		if(n>39||n<=0){
            return 0;
        }
		if(n==1) {
			return 1;
		}
		return Fibonacci1(n-1)+Fibonacci1(n-2);  
    }*/
	
	/**
	 * 二分查找旋转数组最小值
	 * @param array
	 * @return
	 */
	/*public static int Find(int[] array) {
		int low=0;
		int high=array.length-1;
		int mid=0;
		while(array[low]>=array[high]) {
			if(high-low==1) {
				mid=high;
				break;
			}
			mid=(low+high)/2;
			if(array[low]<=array[mid]) {
				low=mid;
			}else if(array[low]>=array[mid]){
				high=mid;
			}
		}
		return array[mid];
	}*/
	/**
	 * 二分查找,适合有序数列.
	 * @param target
	 * @param array
	 * @return
	 */
/*	public static Boolean Find(int target, int[] array) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == array[mid]) {
				return true;
			} else if (target > array[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}*/
	
	/**
	 * 二维数组查找
	 * @param target
	 * @param array
	 * @return
	 */
 	/*public static Boolean Find(int target, int[][] array) {

		int rows = array.length;
		int columns = array[0].length;
		int row = 0;
		int colum = columns - 1;
		while (row < array.length && colum >= 0) {
			if (target == array[row][colum]) {
				return true;
			} else if (target > array[row][colum]) {
				row++;
			} else {
				colum--;
			}
		}
		return false;
	}*/
	
	/**
	 * 快速排序
	 * @param s
	 * @param l
	 * @param r
	 */
	/*static void quick_sort(int s[], int l, int r)  
	{  
	    if (l < r)  
	    {  
	        //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1  
	        int i = l, j = r, x = s[l];  
	        while (i < j){  
	            while(i < j && s[j] >= x) // 从右向左找第一个小于x的数 
	            {
	            	j--; 
	            }       
	            if(i < j)   
	            {
	            	s[i++] = s[j];
	            } 
	            while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数 
	            {
	            	i++; 
	            }
	                   
	            if(i < j){
	            	s[j--] = s[i];
	            }     
	        }  
	        s[i] = x;  
	        quick_sort(s, l, i - 1); // 递归调用   
	        quick_sort(s, i + 1, r);  
	    }  
	}  */
}

package NoteAndTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import Basic.TreeNode;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			StringBuffer sb=new StringBuffer();
			String n = sc.nextLine();
			String[] num=n.split(" ");
			int []arr=new int[num.length];
			for(int i=0;i<num.length;i++) {
				arr[i]=Integer.valueOf(num[i]);
//				System.out.println(arr[i]);
			}
			ArrayList<Integer> list=FindNumbersWithSum(arr,0);
			System.out.println(list.toString());
//			int low=0;
//			int high=arr.length-1;
//			System.out.println(low+" "+high);
//			while(low<high) {
//				if(arr[low]+arr[high]>15) {
//					high--;
//					System.out.println(high);
//				}else if(arr[low]+arr[high]<15){
//					low++;
//					System.out.println(low);
//				}else {
//					break;
//				}
//			}
//			System.out.println(arr[low]+" "+arr[high]);
		}
		sc.close();
	}
	public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		int low=0;
		int high=array.length-1;
		while(low<high) {
			if(array[low]+array[high]>sum) {
				high--;
			}else if(array[low]+array[high]<sum){
				low++;
			}else {
				break;
			}
		}
		if(low>=high) {
			return list;
		}
		list.add(array[low]);
		list.add(array[high]);
		return list;
    }
	public static int[] FindNumsAppearOnce(int[] array) {
		int[] num = new int[2];
		if (array == null || array.length < 2) {
			return null;
		}
		int len = array.length, index = 0, sum = 0;
		for (int i = 0; i < len; i++) {
			sum ^= array[i];
		}
		for (index = 0; index < 32; index++) {
			if ((sum & (1 << index)) != 0)
				break;
		}
		for (int i = 0; i < len; i++) {
			if ((array[i] & (1 << index)) != 0) {
				num[0] ^= array[i];
			} else {
				num[1] ^= array[i];
			}
		}
		return num;
	}
	public static String bankStr(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) + "").matches("[a-zA-Z]+")) {
				if (i != 0 && !(str.charAt(i - 1) + "").matches("[a-zA-Z]+")) {
					sb.append("<>");
				}
				sb.append(str.charAt(i));
			} else {
				if (i != 0 && (str.charAt(i - 1) + "").matches("[a-zA-Z]+")) {
					sb.append("<>");
				}
				sb.append(str.charAt(i));
			}
		}
		if (!(str.charAt(str.length() - 1) + "").matches("[a-zA-Z]+")) {
			sb.append("<>");
		}

		return sb.toString();
	}
	public static int FindGreatestSumOfSubArray(int[] array) {
		if(array.length==0) {
			return 0;
		}
		int total=array[0],maxSum=array[0];
		for(int i=1;i<array.length;i++){
			if(total>=0) {
				total+=array[i];
			}
			else {
				total=array[i];
			}
			if(total>maxSum) {
				maxSum=total;
			}
		}
		return maxSum;
	}
	public static String avgJ(int n) {
		int sum = 0;
		for (int i = 2; i < n; i++) {
			int temp = n;
			while (temp != 0) {
				sum += temp % i;
				temp = temp / i;
			}
		}
		int count = n - 2;
		int a = sum;
		int b = count;
		while (a % b != 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return sum / b + "/" + count / b + "";
	}
	public static String stringSum(String str1,String str2) {
		Stack<Integer> stack=new Stack<Integer>();
		StringBuffer sb=new StringBuffer();
		int len1=str1.length()-1;
		int len2=str2.length()-1;
		int p=0;
		while(len1>=0&&len2>=0) {
			if(str1.charAt(len1)>'9'||str1.charAt(len1)<'0'||str2.charAt(len2)>'9'||str2.charAt(len2)<'0') {
				return "Error";
			}
			int bsum=Integer.valueOf(str1.charAt(len1)-48)+Integer.valueOf(str2.charAt(len2)-48)+p;
			p=bsum/10;
			stack.push(bsum%10);
			len1--;
			len2--;
		}
		if(len1>=0) {
			for(int i=len1;i>=0;i--) {
				stack.push(Integer.valueOf(str1.charAt(i)-48)+p);
				p=0;
			}
		}
		if(len2>=0){
			for(int i=len2;i>=0;i--) {
				stack.push(Integer.valueOf(str2.charAt(i)-48)+p);
				p=0;
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}
	public static String stayMax(String str,int n) {
		StringBuffer sb=new StringBuffer();
		if(n>str.length()||str.length()>1000) {
			return "0";
		}
		char[] ch=str.toCharArray();
		char[] tmp=str.toCharArray();
		Arrays.sort(tmp);
		int j=0;
		while(j<n) {
			for(int i=0;i<ch.length;i++) {
				if(ch[i]==tmp[j]) {
					ch[i]='a';
					break;
				}
			}
			j++;
		}
		for(int i=0;i<ch.length;i++) {
			if(ch[i]!='a') {
				sb.append(ch[i]);
			}
		}
		return sb.toString();
	}
	public static int toutiao1(int[] A) {
		Arrays.sort(A);
		int count = 1, sum = 0;
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i + 1] - A[i] <= 10) {
				if (count < 3) {
					count++;
				} else {
					count = 1;
				}
			} else {
				sum += (3 - count);
				count = 1;
			}
		}
		sum += (3 - count);
		return sum;
	}
	public static int[] fan(Deque<Integer> deque) {
		int [] res=new int[deque.size()];
		int i=0;
		while(deque.size()>0){
            int temp = deque.poll();
            res[i++]=temp;
//            System.out.print(temp+" ");
        }
		return res;
	}
	
	public static TreeNode treeInit() {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2, null, a);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4, b, c);
		TreeNode e = new TreeNode(5);
		TreeNode i = new TreeNode(6);
		TreeNode f = new TreeNode(7, e, i);
		TreeNode g = new TreeNode(8, null, f);
		TreeNode h = new TreeNode(9, d, g);
		return h;// root
	}
	
	public static ArrayList<Integer> preorderTraversa(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null) {
			stack.push(root);
			while (!stack.isEmpty()) {
				TreeNode tN = stack.pop();
				list.add(tN.getIntVal());
				if (tN.getRight() != null) {
					stack.push(tN.getRight());
				}
				if (tN.getLeft() != null) {
					stack.push(tN.getLeft());
				}
			}
		}
		return list;

	}
	public static ArrayList<Integer> inorderTraversa(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode tN = root;
		while (!stack.isEmpty() || tN != null) {
			while (tN != null) {
				stack.push(tN);
				tN = tN.getLeft();
			}
			if (!stack.isEmpty()) {
				tN = stack.pop();
				list.add(tN.getIntVal());
				tN = tN.getRight();
			}
		}
		return list;
	}

	public static ArrayList<Integer> postorderTraversa(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode tN = root, prev = root;
		while (!stack.isEmpty() || tN != null) {
			while (tN != null) {
				stack.push(tN);
				tN = tN.getLeft();
			}
			if (!stack.isEmpty()) {
				TreeNode tmp = stack.peek().getRight();
				if (tmp == null || prev == tmp) {
					tN = stack.pop();
					list.add(tN.getIntVal());
					prev = tN;
					tN = null;
				} else {
					tN = tmp;
				}
			}
		}
		return list;
	}
	public static String geoHash(int n){
    	int low=-90;
        int high=90;
        int count=0;
        StringBuffer sb=new StringBuffer();
        while(count++<6){
        	int mid=(low+high)/2;
        	if(mid>n){
        		high=mid;
        		sb.append(0);
        	}else {
        		low=mid;
        		sb.append(1);
        	}
        }
        return sb.toString();
    }
	public static boolean iscon(char str){
        if(str=='A'||str=='B'||str=='C'||str=='D'||str=='E'){
        	return true;
        }
        return false;
    }
	public static String insertSpace(String str,int start) {
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<=str.length();i++) {
			if(i<start) {
				sb.append(str.charAt(i));
			}else if(i==start) {
				sb.append(" ");
			}else {
				sb.append(str.charAt(i-1));
			}
		}
		return sb.toString();
	}
	public static boolean isCon(String string,char ch) {
		for(int i=0;i<string.length();i++) {
			if(ch==string.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	public static int count(String str) {
		
		return "345678910JQKA2jokerJOKER".indexOf(str);
	}
	public static boolean isBomb(String str) {
		if(str.equals("joker JOKER")||str.equals("joker")||str.equals("JOKER")) {
			return true;
		}
		return false;
	}
	public static void update(int[] array,int pos,int tar){
        array[pos]=tar;
    }
    public static int getMaxs(int[] array,int start,int end){
        int max=0;
        if(start>end) {
        	int tmp=start;
        	start=end;
        	end=tmp;
        }
        for(int i=start;i<=end;i++){
            if(max<array[i]){
                max=array[i];
            }
        }
        return max;
    }
public static int getNum(int A) {
	int count=0;
	int cnt=A;
	while(cnt>=3) {
		count+=cnt/3;
		cnt=cnt/3+cnt%3;
	}
	if(cnt==2) {
		count++;
	}
	return count;
}
	public static int XtoD(char ch) {
		int num=0;
		switch(ch) {
		case 'A':
			num=10;
			break;
		case 'B':
			num=11;
			break;
		case 'C':
			num=12;
			break;
		case 'D':
			num=13;
			break;
		case 'E':
			num=14;
			break;
		case 'F':
			num=15;
			break;
		default:
			num=(int)ch-48;
			break;
		}
		return num;
	}

	public static double count(int num) {
		double sum=1;
		for(int i=1;i<=num;i++) {
			sum*=i;
		}
		return sum;
	}
	public static int[] suger(int [] arr) {
		int []res=new int[3];
		int A1,B1,B2,C1;
		A1=(arr[0]+arr[2])/2;
		B1=(arr[2]-arr[0])/2;
		B2=(arr[1]+arr[3])/2;
		C1=(arr[3]-arr[1])/2;
		if(B1==B2) {
			res[0]=A1;
			res[1]=B1;
			res[2]=C1;
		}
		return res;
	}
	
	public static int rev(int num) {
		String str=String.valueOf(num);
		String tmp = "";
		for(int i=str.length()-1;i>=0;i--) {
			tmp+=str.charAt(i);
		}
		return Integer.parseInt(tmp);
//		int qian=num/1000;
//		int bai=(num%1000)/100;
//		int shi=((num%1000)%100)/10;
//		int ge=((num%1000)%100)%10;
//		if(qian!=1) {
//			return ge*100+shi*10+bai;
//		}else {
//			return ge*1000+shi*100+bai*10+qian;
//		}		
	}
	public static void order(TreeNode tn) {
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(tn);
		while(!queue.isEmpty()) {
			TreeNode tmp=queue.poll();
			visitInt(tmp);
			if(tmp.getLeft()!=null) {
				queue.add(tmp.getLeft());
			}
			if(tmp.getRight()!=null) {
				queue.add(tmp.getRight());
			}
		}
	}
	public static void preOrder(TreeNode tn) {
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode node=tn;
		while(node!=null||!stack.isEmpty()) {
			
			while(node!=null) {
				visit(node);
				stack.push(node);
				node=node.getLeft();
			}
			if(!stack.isEmpty()) {
				node=stack.pop();
				node=node.getRight();
			}
		}
	}
	public static void inOrder(TreeNode tn) {
		Stack<TreeNode> stack =new Stack<TreeNode>();
		TreeNode tmp=tn;
		while(tmp!=null||!stack.isEmpty()) {
			while(tmp!=null) {
				stack.push(tmp);
				tmp=tmp.getLeft();
			}
			if(!stack.isEmpty()) {
				tmp=stack.pop();
				visit(tmp);
				tmp=tmp.getRight();
			}
		}
	}
	public static void postOrder(TreeNode tn) {
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode node=tn,prev=tn;
		while(node!=null||!stack.isEmpty()) {
			while(node!=null) {
				stack.push(node);
				node=node.getLeft();
			}
			if(!stack.isEmpty()) {
				TreeNode tmp=stack.peek().getRight();
				if(tmp==null||tmp==prev) {
					node=stack.pop();
					visit(node);
					prev=node;
					node=null;
				}
				else {
					node=tmp;
				}
			}
		}
	}
	public static void visit(int [] array) {
		for(int i=0;i<array.length-1;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println(array[array.length-1]);
	}
	/**
	 * 访问节点
	 */
	public static void visit(TreeNode p) {
		System.out.print(p.getCharVal() + " ");
	}
	/**
	 * 访问节点
	 */
	public static void visitInt(TreeNode p) {
		System.out.print(p.getIntVal() + " ");
	}
	public static int[] SelectSort(int[] array) {
		int l=array.length;
		for(int i=0;i<l-1;i++) {
			for(int j=i+1;j<l;j++) {
				if(array[i]<array[j]) {
					exChange(array,i,j);
				}
			}
		}
		return array;
	}
	
	private static void exChange(int[] a, int i, int n) {
		// TODO Auto-generated method stub
		int temp = a[i];
		a[i] = a[n];
		a[n] = temp;
	}

	public static String like(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'))
				return "Dislikes";
			if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1))
				return "Dislikes";
			if (i + 4 < s.length() && s.charAt(i) == s.charAt(i + 3) && s.charAt(i + 2) == s.charAt(i + 4))
				return "Dislikes";
		}
		return "Likes";
	}

	public static boolean isHui(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static long getH(long l) {
		int count = 0;
		long q = (long) Math.sqrt(l) - 1;
		while (q * q + q <= l) {
			q++;
		}
		return q - 1;
	}

	public static int pailie(int[] A, int sum) {
		if (sum % A.length != 0) {
			return -1;
		}
		int count = 0;
		int avg = sum / A.length;
		int[] tmp = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			tmp[i] = A[i] - avg;
			if (tmp[i] % 2 != 0) {
				return -1;
			}
		}
		Arrays.sort(tmp);
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i] >= 0) {
				break;
			}
			while (tmp[i] < 0) {
				count++;
				tmp[i] += 2;
			}
		}
		return count;
	}

	public static int bSum(int n) {
		int sum = 0;
		String str = Integer.toBinaryString(n);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				sum++;
			}
		}
		return sum;
	}

	public static int dSum(int n) {
		int sum = 0;
		String str = String.valueOf(n);
		for (int i = 0; i < str.length(); i++) {
			sum += Integer.parseInt(String.valueOf(str.charAt(i)));
		}
		return sum;
	}

	public static boolean isZhishu(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isZidian(String[] A) {
		String[] B = new String[A.length];
		for (int i = 0; i < A.length; i++) {
			B[i] = A[i];
		}
		Arrays.sort(B);
		for (int i = 0; i < A.length; i++) {
			if (!A[i].equals(B[i])) {
				return false;
			}
		}
		return true;
	}

	public static boolean isLongth(String[] A) {
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i].length() > A[i + 1].length()) {
				return false;
			}
		}
		return true;
	}

	public static int getInitial(int n) {
		// write code here
		if (n == 1) {
			return 1;
		}
		int i = 2;
		int sum = 0;
		int count = 1;
		while (i <= n) {
			sum = i * count + 1;
			count = sum;
			i++;
		}
		return sum;
	}

	public static String formatString(String A, int n, char[] arg, int m) {
		// write code here
		int count = 0;
		String tmp = "";
		String res = "";
		char[] ch = new char[A.length()];
		ch = A.toCharArray();
		for (int i = 0; i < ch.length - 1; i++) {
			if (ch[i] == '%' && ch[i + 1] == 's') {
				ch[i] = arg[count++];
				ch[i + 1] = ' ';
			}
		}
		if (count < arg.length) {

			for (int i = count; i < arg.length; i++) {
				tmp += arg[i];
			}
		}
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] != ' ') {
				res += ch[i];
			}
		}
		res += tmp;
		return res;
	}

	public static int[][] flipChess(int[][] A, int[][] f) {
		// write code here
		for (int i = 0; i < f.length; i++) {
			int h = 0;
			int v = 0;
			for (int j = 0; j < f[0].length; j++) {
				if (j == 0) {
					h = f[i][j] - 1;
				} else {
					v = f[i][j] - 1;
				}
			}
			if (h > 0 && h < 3) {
				A[h - 1][v] = flip(A[h - 1][v]);
				A[h + 1][v] = flip(A[h + 1][v]);
			} else if (h == 3) {
				A[h - 1][v] = flip(A[h - 1][v]);
			} else {
				A[h + 1][v] = flip(A[h + 1][v]);
			}
			if (v > 0 && v < 3) {
				A[h][v - 1] = flip(A[h][v - 1]);
				A[h][v + 1] = flip(A[h][v + 1]);
			} else if (v == 3) {
				A[h][v - 1] = flip(A[h][v - 1]);
			} else {
				A[h][v + 1] = flip(A[h][v + 1]);
			}
			System.out.println("");
		}
		return A;
	}

	public static int flip(int A) {
		if (A == 0) {
			return 1;
		}
		return 0;
	}

	public static String[] findCoder1(String[] A, int n) {
		// write code here
		return A;
	}

	public static String[] findCoder(String[] A, int n) {
		// write code here
		String coder = "coder";
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < n; i++) {
			int count = 0;
			int start = 0;
			String str = A[i].toLowerCase();
			if (str.contains(coder)) {
				while (str.indexOf(coder, start) >= 0 && start < str.length()) {
					count++;
					start = str.indexOf(coder, start) + coder.length();
					// map.put(str, count);
				}
				map.put(str, count);
			}
		}

		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue() - o1.getValue());
			}
		});
		Set<String> sets = map.keySet();
		return (String[]) sets.toArray(new String[sets.size()]);
		// return map;

		/*
		 * ArrayList<String> reList=new ArrayList<String>(); int[] recount=new int[n];
		 * String coder="Coder".toLowerCase(); for(int i=0;i<n;i++){ int
		 * count=0;//保存每个字符串包含Coder的次数 int start=0; String str=A[i].toLowerCase();
		 * while(str.indexOf(coder, start)>=0&&start<A[i].length()){ count++;
		 * start=str.indexOf(coder, start)+coder.length(); } recount[i]=count; } for(int
		 * i=0;i<recount.length-1;i++){ for(int j=i+1;j<recount.length;j++){
		 * if(recount[i]<recount[j]&&recount[i]!=0&&recount[j]!=0){ int
		 * tempCo=recount[i]; String temp=A[i]; recount[i]=recount[j]; A[i]=A[j];
		 * for(int k=j;k>=i+2;k--){ recount[k]=recount[k-1]; A[k]=A[k-1]; }
		 * recount[i+1]=tempCo; A[i+1]=temp; } } } for(int i=0;i<recount.length;i++){
		 * if(recount[i]!=0){ reList.add(A[i]); } } String[] reStr = new
		 * String[reList.size()]; for(int i=0;i<reList.size();i++){
		 * reStr[i]=reList.get(i); } return reStr;
		 */
	}

	public static int getPos(int[] A, int n, int val) {
		// write code here
		if (n <= 0) {
			return -1;
		}
		int low = 0;
		int high = n;
		while (low < high) {
			int mid = (low + high) / 2;
			if (A[mid] == A[low]) {
				return low;
			}
			if (A[mid] == val) {
				return mid;
			} else if (A[mid] > val) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return -1;

	}

	public static char findFirstRepeat(String A, int n) {
		// write code here
		HashSet hs = new HashSet();
		for (int i = 0; i < n; i++) {
			if (!hs.add(A.charAt(i))) {
				return A.charAt(i);
			}
		}
		return 0;
	}

	public static int[] gifts(int[] gifts, int n) {
		int tmp = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (gifts[j] > gifts[j + 1]) {
					tmp = gifts[j + 1];
					gifts[j + 1] = gifts[j];
					gifts[j] = tmp;
				}
			}
		}
		return gifts;
	}

	public static int getValue(int[] gifts, int n) {
		// write code here
		if (n <= 0) {
			return 0;
		}
		int tmp;
		int count = 0;
		int sum = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (gifts[j] > gifts[j + 1]) {
					tmp = gifts[j + 1];
					gifts[j + 1] = gifts[j];
					gifts[j] = tmp;
				}
			}
		}
		tmp = gifts[0];
		for (int i = 0; i < n; i++) {
			if (tmp == gifts[i]) {
				count++;
				if (sum < count) {
					sum = count;
				}
			} else {
				tmp = gifts[i];
				count = 0;
			}
		}
		if (sum < (n / 2)) {
			return 0;
		}
		if (n % 2 == 1) {
			return gifts[n / 2];
		}
		return (gifts[(n - 1) / 2] + gifts[(n + 1) / 2]) / 2;
	}

	public static String rotateString(String A, int n, int p) {
		// write code here
		char[] B = new char[n];
		char[] tmp = new char[p + 1];
		for (int i = 0; i < n; i++) {
			if (i <= p) {
				B[n - p + i - 1] = A.charAt(i);
			} else {
				B[i - p - 1] = A.charAt(i);
			}

		}
		// for(int i=0;i<=p;i++) {
		// B[n-p+i-1]=tmp[i];
		// }
		return String.valueOf(B);
	}

	public static int[] printMatrix(int[][] mat, int n, int m) {
		// write code here
		int[] A = new int[n * m];
		int p = 0;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < m; j++) {
					A[p++] = mat[i][j];
				}
			} else {
				for (int j = m - 1; j >= 0; j--) {
					A[p++] = mat[i][j];
				}
			}
		}
		return A;
	}

	public static int[] arrayPrint(int[][] arr, int n) {
		// write code here
		int[] A = new int[n * n];
		int p = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < n - i; j++) {
				A[p] = arr[j][i + j];
				A[n * n - 1 - p] = arr[n - 1 - j][n - 1 - i - j];
				p++;
			}
		}
		return A;
	}

	public static int[][] findLCS(String A, int n, String B, int m) {
		// 行对应A，比A长1，原因是0作为初始化。列同理。dp[n][m]指A[n-1],B[m-1]
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = 0;
		}
		// 事实上，数组默认也是0
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				// 如果是字符串，用equals，由于charAt()是字符，可以运算，故可以用==
				if (A.charAt(i - 1) == B.charAt(j - 1)) {// A[0]==B[0],对应dp[1][1]
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		return dp;
	}

	public static int getMost(int[][] board) {
		// write code here
		int[][] tmp = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				int c = board[i][j];
				if (i == 0 && j == 0) {
					tmp[i][j] = c;
				} else if (i == 0) {
					tmp[i][j] = tmp[i][j - 1] + c;
				} else if (j == 0) {
					tmp[i][j] += tmp[i - 1][j] + c;
				} else {
					tmp[i][j] += Math.max(tmp[i][j - 1], tmp[i - 1][j]) + c;
				}
			}
		}
		return tmp[5][5];
	}

	public static int findLongest(String A, int n, String B, int m) {
		// write code here
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		int[][] dp = new int[n + 1][m + 1];
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i] == b[j]) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
					if (max < dp[i + 1][j + 1])
						max = dp[i + 1][j + 1];
				}
			}
		} // for
		return max;
	}

	public static int findMaxGap(int[] A, int n) {
		if (A.length <= 0) {
			return 0;
		}
		int max = 0;
		for (int i = 0; i < n - 1; i++) {
			int left = getMax(A, 0, i);
			int right = getMax(A, i + 1, n - 1);
			if (max < Math.abs(left - right)) {
				max = Math.abs(left - right);
			}
		}
		return max;
		// int max=A[0],min;
		// for(int i=0;i<n;i++) {
		// if(A[i]>max)
		// max=A[i];
		// }
		// min=A[0]>A[n-1]?A[n-1]:A[0];
		// return max-min;
	}

	public static int getMax(int[] A, int start, int end) {
		if (A.length <= 0) {
			return 0;
		}
		int max = A[start];
		for (int i = start; i <= end; i++) {
			if (max < A[i]) {
				max = A[i];
			}
		}
		return max;
		// write code here
	}

	public static int countBitDiff(int m, int n) {
		// if(m) {}
		String str = Integer.toBinaryString(m ^ n);
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				count++;
			}
		}
		return count;

	}

	public static int calcDistance(int A, int B, int C, int D) {
		return calHigh(A) + calHigh(B) + calHigh(C) + calHigh(D);
		// write code here
	}

	public static int calHigh(int high) {
		int sum = 0;
		while (high > 0) {
			sum += (high);
			high /= 2;

		}
		return sum;
	}

	/**
	 * 二叉搜索树的后序遍历
	 * 
	 * @param sequence
	 * @return
	 */
	public static boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence.length <= 0) {
			return false;
		}
		if (sequence.length == 1) {
			return true;
		}
		return isBSF(sequence, 0, sequence.length - 1);
	}

	public static boolean isBSF(int[] sequence, int start, int end) {
		if (start > end) {
			return true;
		}
		int count = end;
		while (count > start && sequence[count - 1] > sequence[end]) {
			count--;
		}
		for (int i = 0; i < count - 1; i++) {
			if (sequence[i] > sequence[end]) {
				return false;
			}
		}

		return isBSF(sequence, start, count - 1) && isBSF(sequence, count, end - 1);
	}
	/*
	 * public static boolean IsPopOrder(int[] pushA, int[] popA) { if (pushA == null
	 * || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length !=
	 * popA.length) { return false; } Stack<Integer> st = new Stack<Integer>(); int
	 * i = 0; int j = 0;
	 * 
	 * st.push(pushA[i++]); while (j <= popA.length - 1) { while (popA[j] !=
	 * st.peek()) { if (i == pushA.length) return false; st.push(pushA[i++]); } j++;
	 * st.pop(); } return true; }
	 */
	/*
	 * public static ArrayList<Integer> printMatrix(int[][] matrix) {
	 * ArrayList<Integer> list = new ArrayList<Integer>(); int rows = matrix.length;
	 * int columns = matrix[0].length; if (rows <= 0) { return list; } int start =
	 * 0; while (columns > start * 2 && rows > start * 2) { print(matrix, columns,
	 * rows, start,list); start++; } return list; }
	 * 
	 * public static ArrayList<Integer> print(int[][] matrix, int columns, int rows,
	 * int start,ArrayList<Integer> list) { int endx = columns - 1 - start; int endy
	 * = rows - 1 - start; for (int i = start; i <= endx; ++i) {
	 * list.add(matrix[start][i]); } if (start < endy) { for (int i = start + 1; i
	 * <= endy; ++i) { list.add(matrix[i][endx]); } } if (start < endy && start <
	 * endx) { for (int i = endx - 1; i >= start; --i) { list.add(matrix[endy][i]);
	 * } } if (start < endy - 1 && start < endx) { for (int i = endy - 1; i >=
	 * start+1; --i) { list.add(matrix[i][start]); } } return list; }
	 */
	/**
	 * 1的个数，用位与运算
	 * 
	 * @param n
	 * @return
	 */
	/*
	 * public static int NumberOf1(int n) { if(n==0) { return 0; } int res=0; String
	 * string=Integer.toBinaryString(n); for(int i=0;i<string.length();i++) {
	 * if(string.charAt(i)=='1') { res++; } } return res;
	 * 
	 * }
	 */

	/**
	 * Fibonacci数列
	 * 
	 * @param n
	 * @return
	 */
	/*
	 * public static int Fibonacci(int n) { if(n>39||n<=0){ return 0; } if(n==1) {
	 * return 1; } int res=0; int one=0; int two=1; for(int i=2;i<=n;i++) {
	 * res=one+two; one=two; two=res; } return res;
	 * 
	 * } public static int Fibonacci1(int n) { if(n>39||n<=0){ return 0; } if(n==1)
	 * { return 1; } return Fibonacci1(n-1)+Fibonacci1(n-2); }
	 */

	/**
	 * 二分查找旋转数组最小值
	 * 
	 * @param array
	 * @return
	 */
	/*
	 * public static int Find(int[] array) { int low=0; int high=array.length-1; int
	 * mid=0; while(array[low]>=array[high]) { if(high-low==1) { mid=high; break; }
	 * mid=(low+high)/2; if(array[low]<=array[mid]) { low=mid; }else
	 * if(array[low]>=array[mid]){ high=mid; } } return array[mid]; }
	 */
	/**
	 * 二分查找,适合有序数列.
	 * 
	 * @param target
	 * @param array
	 * @return
	 */
	/*
	 * public static Boolean Find(int target, int[] array) { int low = 0; int high =
	 * array.length - 1; while (low <= high) { int mid = (low + high) / 2; if
	 * (target == array[mid]) { return true; } else if (target > array[mid]) { low =
	 * mid + 1; } else { high = mid - 1; } } return false; }
	 */

	/**
	 * 二维数组查找
	 * 
	 * @param target
	 * @param array
	 * @return
	 */
	/*
	 * public static Boolean Find(int target, int[][] array) {
	 * 
	 * int rows = array.length; int columns = array[0].length; int row = 0; int
	 * colum = columns - 1; while (row < array.length && colum >= 0) { if (target ==
	 * array[row][colum]) { return true; } else if (target > array[row][colum]) {
	 * row++; } else { colum--; } } return false; }
	 */

	/**
	 * 快速排序
	 * 
	 * @param s
	 * @param l
	 * @param r
	 */
	/*
	 * static void quick_sort(int s[], int l, int r) { if (l < r) { //Swap(s[l],
	 * s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1 int i = l, j = r, x = s[l]; while (i <
	 * j){ while(i < j && s[j] >= x) // 从右向左找第一个小于x的数 { j--; } if(i < j) { s[i++] =
	 * s[j]; } while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数 { i++; }
	 * 
	 * if(i < j){ s[j--] = s[i]; } } s[i] = x; quick_sort(s, l, i - 1); // 递归调用
	 * quick_sort(s, i + 1, r); } }
	 */
}

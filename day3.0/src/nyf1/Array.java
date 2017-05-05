package nyf1;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义数组和变量
		int[] array = new int[99];
		int[] array1 = new int[]{3,5,2,1,9,6};
		//int[] array2 = {6,3,7,2,0,8,1};
		int max = 0;
		int exchange = 0;
		//依次将数据存入数组中
		for(int i = 0;i < 5; i++) {
			array[i] = i;
		}
		//依次输出数组中的数据
		for(int i = 0;i < 5; i++) {
			System.out.print(array[i]);
		}
		System.out.println("");
		//取数组中的最大数
		for(int i = 0; i < 4; i++) {
			if(array1[i] > array[i+1]) {
				max = array1[i];
			}else {
				max = array1[i+1];
			}
		}
		System.out.println(max);
		//逆向存储方法一：利用空的数组
		for(int i = 0;i < array1.length;i++) {
			array[i] = array1[array1.length-1-i];
			System.out.print(array[i]);
		}
		System.out.println("");
		//逆向存储方法二：利用变量交换
		for(int i = 0; i < array1.length / 2; i++) {
			exchange = array1[i];
			array1[i] = array1[array1.length - i - 1];
			array1[array1.length - i - 1] = exchange;
		}
		for(int i = 0;i <array1.length; i++) {
			System.out.print(array1[i]);
		}
		System.out.println("");

		//冒泡排序
		for(int i = 1; i < array1.length; i++) {
			for(int j = 0; j < array1.length - 1; j++) {
				if(array1[j] > array1[j + 1]) {
					exchange = array1[j];
					array1[j] = array1[j + 1];
					array1[j + 1] = exchange;
				}
			}
		}
		for(int i = 0;i < array1.length; i++) {
			System.out.print(array1[i]);
		}

	}

}

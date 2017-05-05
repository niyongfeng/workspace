package com.test;

public class Test10 {

	public static void main(String[] args) {
		int[][] nums = {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};
		clockwisePrint(nums,5,3);
	}
	static int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        int[] nums = new int[n * m];
        int xmin = 0, xmax = n - 1, ymin = 0, ymax = m - 1;
        int l = 0;
        while(xmin <= xmax && ymin <= ymax) {
        	//从左往右
            if(ymin <= ymax) {
                for(int a = ymin; a <= ymax; a++) {
                    nums[l] = mat[xmin][a];
                    System.out.println(nums[l]);
                    l++;
                }
            }
            //从上到下
            if(xmin < xmax) {
                for(int a = xmin + 1; a <= xmax; a++) {
                    nums[l] = mat[a][ymax];
                    System.out.println(nums[l]);
                    l++;
                }
            }
            //从右往左
            if(xmin < xmax && ymin < ymax) {
                for(int a = ymax - 1; a >= ymin; a--) {
                    nums[l] = mat[xmax][a];
                    System.out.println(nums[l]);
                    l++;
                }
            }
            //从下往上
            if(ymin < ymax && xmin < xmax) {
                for(int a = xmax - 1; a > xmin; a--) {
                    nums[l] = mat[a][ymin];
                    System.out.println(nums[l]);
                    l++;
                }
            }
            xmin++;
            xmax--;
            ymin++;
            ymax--;
        }
        for(int arr : nums) {
        	System.out.print(arr + " , ");
        }
        return nums;
    }
}

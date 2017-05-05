package nyf2;

public class Array {
	public static void main(String[] arges) {
		int[] array1 = new int[]{1, 3, 2, 9, 5, 10};
		int t;
		for(int i = 0; i < array1.length; i++) {
			for(int j = 0; j < array1.length - 1 - i; j++){
				if(array1[j] > array1[j + 1]) {
					t = array1[j];
					array1[j] = array1[j + 1];
					array1[j + 1] = t;
				}
			}
		}
		
		for(int i = 0; i < array1.length; i++) {
			System.out.println(array1[i]);
		}
	}

}

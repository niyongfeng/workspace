package test;

public class Puker implements Comparable<Puker>{
	public String color = "";
	public int num = 0;
	public Puker() {
		
	}
	
	public Puker(String color) {
		this.color = color;
	}
	
	public Puker(String color, int num) {
		this.color = color;
		this.num = num;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public String toString() {
		String str1 = "";
		switch(num) {
		case 17 : str1 = "小王";break;
		case 18 : str1 = "大王";break;
		case 11 : str1 = color + "J";break;
		case 12 : str1 = color + "Q";break;
		case 13 : str1 = color + "K";break;
		case 14 : str1 = color + "A";break;
		case 15 : str1 = color + "2";break;
		default : str1 = color + num;
		}
		return str1;
	}

	public int compareTo(Puker o) {
		if(o.num == num) {
			return o.color.compareTo(color);
		}
		if(o.num > num) {
			return -1;
		}
		return 1;
	}


}


package nyf1;

public class Cat extends Animals{
	
	private String name = "mike";
	private int age = 2;
	private String color = "black";
	private int bathMonth = 1;
	private int bathDay = 1;
    private int nextBathDay = 8;
    private int nextBathMonth = 1;
    
    public Cat() {
    	
    }
    
    public Cat(String name, int age,String color,int bathMonth,int bathDay) {
    	this.name = name;
    	this.age = age;
    	this.color = color;
    	this.bathDay = bathDay;
    }
    
    public String getName(String name) {
    	return name;
    }

    public int getAge() {
    	return age;
    }
    
    public String getColor() {
    	return color;
    }
    
    
    public void setBathDay(int bathDay) {
    	this.bathDay = bathDay;
    }
    public void setBathMonth(int bathMonth) {
    	this.bathMonth = bathMonth;
    }
    
    public void nextBath() {
    	if(bathMonth % 2 == 1) {
    		if(bathDay <= 24) {
    			nextBathDay = bathDay + 7;
    			nextBathMonth = bathMonth;
    		}else {
    			nextBathDay = bathDay + 7 - 31;
    			nextBathMonth = bathMonth + 1;
    		}
    	}else if(bathMonth == 12) {
    		if(bathDay <= 23) {
    			nextBathDay = bathDay + 7;
    			nextBathMonth = bathMonth;
    		}else {
    			nextBathDay = bathDay + 7 - 30;
    			nextBathMonth = 1;
    		}
    	}else {
    		if(bathDay <= 23) {
    			nextBathDay = bathDay + 7;
    			nextBathMonth = bathMonth;
    		}else {
    			nextBathDay = bathDay + 7 - 30;
    			nextBathMonth = bathMonth + 1;
    		}
    	}
    	
    }
    
    public String toPrint(){
    	return "您家" + age + "的" + color + name + "上次洗澡时间是：" + bathMonth + "月" + bathDay + "日" + ','
        + "下次洗澡时间是：" + nextBathMonth + "月" + nextBathDay + "日";
    }
    
    
    
    
}

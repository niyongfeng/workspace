package niyongfeng;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Test {
	
	public static void main(String[] args) {
//		Addition addition1 = new Addition(1, 2);
//		Addition addition2 = new Addition(1.0f, 2.0f);
//		Addition addition3 = new Addition(1.00, 2.00);
//		Addition addition4 = new Addition("AB", "CD");
		
		ArrayList list=new ArrayList();
		int x = 0;
        list.add("a");
        list.add("b");
        list.add("a");
        Set set=new HashSet();
        set.add("a");
        set.add("b");
        set.add("a");
        System.out.print(x);
        System.out.println(list.size()+","+set.size());
		
	}

}

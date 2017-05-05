package com.dao;

import com.actionForm.BookCaseForm;
import com.core.ConnDB;


public class BookCaseDAO {
    private ConnDB conn=new ConnDB();
    //��ѯ����
    public Collection query(String strif){
        BookCaseForm bookCaseForm1=null;
        Collection bookcaseColl=new ArrayList();
        String sql="";
        if(strif!="all" && strif!=null && strif!=""){
            sql="select * from tb_bookcase where "+strif+"";
        }else{
            sql="select * from tb_bookcase";
        }
        ResultSet rs=conn.executeQuery(sql);
        try {
            while (rs.next()) {
                bookCaseForm1=new BookCaseForm();
                bookCaseForm1.setId(Integer.valueOf(rs.getString(1)));
                bookCaseForm1.setName(rs.getString(2));
                bookcaseColl.add(bookCaseForm1);
            }
        } catch (SQLException ex) {
        }
        conn.close();
        return bookcaseColl;
    }
    //�����޸ĵĲ�ѯ
    public BookCaseForm queryM(BookCaseForm bookCaseForm){
        BookCaseForm bookCaseForm1=null;
        String sql="select * from tb_bookcase where id="+bookCaseForm.getId()+"";
        System.out.println("�޸�ʱ��SQL��"+sql);
        ResultSet rs=conn.executeQuery(sql);
        try {
            while (rs.next()) {
                bookCaseForm1=new BookCaseForm();
                bookCaseForm1.setId(Integer.valueOf(rs.getString(1)));
                bookCaseForm1.setName(rs.getString(2));
            }
        } catch (SQLException ex) {
        }
        conn.close();
        return bookCaseForm1;
    }
   //�������
    public int insert(BookCaseForm bookCaseForm){
    String sql1="SELECT * FROM tb_bookcase WHERE name='"+bookCaseForm.getName()+"'";
    ResultSet rs = conn.executeQuery(sql1);
    String sql = "";
    int falg = 0;
    try {
        if (rs.next()) {
            falg = 2;
        } else {
            sql ="Insert into tb_bookcase (name) values('"+bookCaseForm.getName()+"')";
            falg = conn.executeUpdate(sql);
            System.out.println("��������Ϣ��SQL��" + sql);
            conn.close();
        }
    } catch (SQLException ex) {
        falg = 0;
    }
    System.out.println("falg:"+falg);
    return falg;
}

    //�޸�����
    public int update(BookCaseForm bookCaseForm){
    String sql="Update tb_bookcase set name='"+bookCaseForm.getName()+"' where id="+bookCaseForm.getId()+"";
    int falg=conn.executeUpdate(sql);
    System.out.println("�޸�����ʱ��SQL��"+sql);
    conn.close();
    return falg;
}
    //ɾ������
    public int delete(BookCaseForm bookCaseForm){
    	String sql_1="SELECT * FROM tb_bookcase WHERE bookcase="+bookCaseForm.getId()+"";
    	ResultSet rs=conn.executeQuery(sql_1);
    	int falg=0;
    	try {
    		if(!rs.next()){
    			String sql="Delete from tb_bookcase where id="+bookCaseForm.getId()+"";
    			falg=conn.executeUpdate(sql);
    			System.out.println("ɾ��ʱ��SQL��"+sql);
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}	
    	return falg;
    }

}

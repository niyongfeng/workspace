package mall.demo.mybatis.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


//单实例模式获得session factory
public class MybatisSessionUtil {
	private SqlSessionFactory factory;
	
	private static MybatisSessionUtil _instance = null;

	private MybatisSessionUtil() {
		// TODO Auto-generated constructor stub
		String resource = "mybatis_config.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        //下面这个方式，很值得琢磨琢磨，
        InputStream is = MybatisSessionUtil.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂，mybatis的类，基于输入流去构建
        factory = new SqlSessionFactoryBuilder().build(is);
        //is.close();
	}
	
	public static MybatisSessionUtil getInstance() {
		if (_instance == null) {
			_instance = new MybatisSessionUtil();
		}
		return _instance;
	}
	
	public SqlSession openSession() {
		return this.factory.openSession();
	}

}

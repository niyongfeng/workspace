package com.qk.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qk.Object.Answer;
import com.qk.Object.Player;
import com.qk.Object.Question;
import com.qk.util.MyConsole;

public class BesuperDao {
	private static Connection con = null;
	private static JDBConnection jdbc = null;
	private static PreparedStatement psta = null;
	private static Answer answer = null;
	private static ResultSet res = null;
	private static Player player = null;
	private static Question question = null;

	static {
		jdbc = JDBConnection.getInstance();
		con = jdbc.getConnection();
	}

	public static List<Answer> searchAnswerALL() {
		String sql = "select * from answer";
		List<Answer> list = new ArrayList<Answer>();
		try {
			psta = con.prepareStatement(sql);
			res = psta.executeQuery();
			while (res.next()) {
				answer = new Answer();
				answer.setId(res.getInt(1));
				answer.setValue(res.getString(2));
				answer.setBest(res.getString(3));
				answer.setPlayer_id(res.getInt(4));
				answer.setQuestion_id(res.getInt(5));
				list.add(answer);
			}
			if (list.size() > 0) {
				return list;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static List<Answer> searchAnswerMINE(int player_id) {
		String sql = "select * from answer where player_id=?";
		List<Answer> list = new ArrayList<Answer>();
		try {
			psta = con.prepareStatement(sql);
			psta.setInt(1, player_id);
			res = psta.executeQuery();
			while (res.next()) {
				answer = new Answer();
				answer.setId(res.getInt(1));
				answer.setValue(res.getString(2));
				answer.setBest(res.getString(3));
				answer.setPlayer_id(res.getInt(4));
				answer.setQuestion_id(res.getInt(5));
				list.add(answer);
			}
			if (list.size() > 0) {
				return list;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static List<Answer> searchQuestionAllAnswer(int question_id) {
		String sql = "select * from answer where question_id=?";
		List<Answer> list = new ArrayList<Answer>();
		try {
			psta = con.prepareStatement(sql);
			psta.setInt(1, question_id);
			res = psta.executeQuery();
			while (res.next()) {
				answer = new Answer();
				answer.setId(res.getInt(1));
				answer.setValue(res.getString(2));
				answer.setBest(res.getString(3));
				answer.setPlayer_id(res.getInt(4));
				answer.setQuestion_id(res.getInt(5));
				list.add(answer);
			}
			if (list.size() > 0) {
				return list;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static Answer searchAnswerByID(int answer_id) {
		String sql = "select * from answer where id=?";
		try {
			psta = con.prepareStatement(sql);
			psta.setInt(1, answer_id);
			res = psta.executeQuery();
			answer = null;
			if (res.next()) {
				answer = new Answer();
				answer.setId(res.getInt(1));
				answer.setValue(res.getString(2));
				answer.setBest(res.getString(3));
				answer.setPlayer_id(res.getInt(4));
				answer.setQuestion_id(res.getInt(5));
			}

			return answer;

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static int insertAnswer(Answer an) {
		String sql = "insert into answer(value,best,player_id,question_id) values(?,?,?,?)";
		try {
			psta = con.prepareStatement(sql);
			psta.setString(1, an.getValue());
			psta.setString(2, an.getBest());
			psta.setInt(3, an.getPlayer_id());
			psta.setInt(4, an.getQuestion_id());

			con.setAutoCommit(false);
			int n = psta.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		return 0;
	}

	public static int updateAnswer(Answer an) {
		String sql = "update answer set value=?,best=?,player_id=?,question_id=? where id =?";
		try {
			psta = con.prepareStatement(sql);
			psta.setString(1, an.getValue());
			psta.setString(2, an.getBest());
			psta.setInt(3, an.getPlayer_id());
			psta.setInt(4, an.getQuestion_id());
			psta.setInt(5, an.getId());
			con.setAutoCommit(false);
			int n = psta.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		return 0;
	}

	public static boolean acceptAnswer(Question qu, Answer an) {
		if (an.getBest().equalsIgnoreCase("y")) {
			MyConsole.println("已经被接受，不能重复接受！");
			return false;
		}
		if (qu.getId() != answer.getQuestion_id()) {
			return false;
		}
		if (qu.getIsOpen().equalsIgnoreCase("n")){
			MyConsole.println("该问题已经被解决！");
			return false;
		}
		qu.setIsOpen("n");
		an.setBest("y");
		Player pla = searchPlayer(an.getPlayer_id());
		pla.setScore(qu.getCredit() + pla.getScore());
		updateQuestion(qu);
		updateAnswer(an);
		updatePlayer(pla);
		return true;
	}
	public static Player toLogin(String username, String password) {

		String sql = "select * from player where username=? and password=?";
		try {
			psta = con.prepareStatement(sql);
			psta.setString(1, username);
			psta.setString(2, password);
			res = psta.executeQuery();
			if (res.next()) {
				player = new Player();
				player.setId(res.getInt(1));
				player.setName(res.getString(2));
				player.setScore(res.getInt(3));
				player.setPassword(password);
				player.setUsername(username);
			}
			return player;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (res != null) {
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public static boolean isUserExist(String username) {

		String sql = "select * from player where username=?";
		try {
			psta = con.prepareStatement(sql);
			psta.setString(1, username);
			res = psta.executeQuery();
			if (res.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (res != null) {
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public static Player searchPlayer(int id) {

		String sql = "select * from player where id=?";
		try {
			psta = con.prepareStatement(sql);
			psta.setInt(1, id);
			res = psta.executeQuery();
			player = null;
			if (res.next()) {
				player = new Player();
				player.setId(res.getInt(1));
				player.setName(res.getString(2));
				player.setScore(res.getInt(3));
				player.setUsername(res.getString(4));
				player.setPassword(res.getString(5));
			}
			return player;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (res != null) {
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public static Player SignUp(String name, String username, String password) {

		String sql = "insert into player(name,username,password) values(?,?,?)";
		try {
			psta = con.prepareStatement(sql);
			psta.setString(1, name);
			psta.setString(2, username);
			psta.setString(3, password);
			psta.executeUpdate();
			return toLogin(username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public static boolean updatePlayer(Player player) {
		String sql = "update player set name=?,password=?,score=? where id=?";
		try {
			psta = con.prepareStatement(sql);
			psta.setString(1, player.getName());
			psta.setString(2, player.getPassword());
			psta.setInt(3, player.getScore());
			psta.setInt(4, player.getId());
			int i = psta.executeUpdate();
			if (i == 1) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public static List<Question> searchQuestionALL() {
		String sql = "select * from question";
		List<Question> list = new ArrayList<Question>();
		try {
			psta = con.prepareStatement(sql);
			res = psta.executeQuery();
			while (res.next()) {
				question = new Question();
				question.setId(res.getInt(1));
				question.setValue(res.getString(2));
				question.setCredit(res.getInt(3));
				question.setPlayer_id(res.getInt(4));
				question.setIsOpen(res.getString(5));
				list.add(question);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static List<Question> searchQuestionOpen() {
		String sql = "select * from question where isOpen='y'";
		List<Question> list = new ArrayList<Question>();
		try {
			psta = con.prepareStatement(sql);
			res = psta.executeQuery();
			while (res.next()) {
				question = new Question();
				question.setId(res.getInt(1));
				question.setValue(res.getString(2));
				question.setCredit(res.getInt(3));
				question.setPlayer_id(res.getInt(4));
				question.setIsOpen(res.getString(5));
				list.add(question);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static List<Question> searchQuestionMINE(int player_id) {
		String sql = "select * from question where player_id=?";
		List<Question> list = new ArrayList<Question>();
		try {
			psta = con.prepareStatement(sql);
			psta.setInt(1, player_id);
			res = psta.executeQuery();
			while (res.next()) {
				question = new Question();
				question.setId(res.getInt(1));
				question.setValue(res.getString(2));
				question.setCredit(res.getInt(3));
				question.setPlayer_id(res.getInt(4));
				question.setIsOpen(res.getString(5));
				list.add(question);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static Question searchQuestionID(int id) {
		String sql = "select * from question where id=?";

		try {
			psta = con.prepareStatement(sql);
			psta.setInt(1, id);
			res = psta.executeQuery();
			if (res.next()) {
				question = new Question();
				question.setId(res.getInt(1));
				question.setValue(res.getString(2));
				question.setCredit(res.getInt(3));
				question.setPlayer_id(res.getInt(4));
				question.setIsOpen(res.getString(5));
			}
			return question;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static int insertQuestion(Question qu) {
		String sql = "insert into question(value,credit,player_id,isOpen) values (?,?,?,?)";
		try {
			psta = con.prepareStatement(sql);
			psta.setString(1, qu.getValue());
			psta.setInt(2, qu.getCredit());
			psta.setInt(3, qu.getPlayer_id());
			psta.setString(4, qu.getIsOpen());
			int n = psta.executeUpdate();
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public static int updateQuestion(Question qu) {
		String sql = "update question set value=?,credit=?,isOpen=? where id=?";
		try {
			psta = con.prepareStatement(sql);
			psta.setString(1, qu.getValue());
			psta.setInt(2, qu.getCredit());
			psta.setString(3, qu.getIsOpen());
			psta.setInt(4, qu.getId());
			int n = psta.executeUpdate();
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public static void close() {
		try {
			if (con != null) {
				con.close();
			}
			if (psta != null) {
				psta.close();
			}
			if (res != null) {
				res.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

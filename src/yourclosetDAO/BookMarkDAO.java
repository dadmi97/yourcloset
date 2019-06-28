package yourclosetDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import yourcloset.util.DBAgent;
import yourclosetDTO.BookMarkDTO;
import yourclosetDTO.ProductDTO;
import yourclosetDTO.UserDTO;

public class BookMarkDAO {
	protected static int bid;
	
	static {
		DBAgent agent = new DBAgent();

		try {
			PreparedStatement psmt = agent.getCon().prepareStatement("SELECT max(bid) AS `bid` FROM bookmark");
			ResultSet result = psmt.executeQuery();

			if (result.next()) {
				bid = result.getInt("bid") + 1;
			}
			else {
				bid = 0;
			}
		}
		catch (SQLException e) {
			bid = 0;
		}

	}
	
	public List<BookMarkDTO> selectBookMarkByUserId(String userId) {
		DBAgent agent = new DBAgent();
		String sql = "SELECT * FROM bookmark WHERE userid = ?";

		try {
			PreparedStatement psmt = agent.getCon().prepareStatement(sql);
			psmt.setString(1, userId);
			ResultSet rs = psmt.executeQuery();

			List<BookMarkDTO> bookMarkList = new ArrayList<>();

			while (rs.next()) {
				int bid = rs.getInt("bid");
				String pname = rs.getString("pname");
				int pid = rs.getInt("pid");
				String userid = rs.getString("userid");

				BookMarkDTO bookMark = new BookMarkDTO(bid,pname,pid,userid);
				bookMarkList.add(bookMark);
			}

			return bookMarkList;
		} catch (Exception e) {
			return null;
		} finally {
			agent.close();
		}
	}
	public int insertBookMark(BookMarkDTO bookmark) {
		DBAgent agent = new DBAgent();
		String sql = "insert into bookmark(pname, pid, userid) values(?,?,?);";
		try {
			PreparedStatement psmt = agent.getCon().prepareStatement(sql);
			psmt.setString(1, bookmark.getPname());
			psmt.setInt(2, bookmark.getPid());
			psmt.setString(3, bookmark.getUserId());
	
			return psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			agent.close();
			return 0;
		}finally {
			agent.close();
		}
	}
	public int deleteBookMark(int bid) {
		DBAgent agent = new DBAgent();
		String sql = "delete from bookmark where bid =?;";
		try {
			PreparedStatement psmt = agent.getCon().prepareStatement(sql);
			psmt.setInt(1, bid);
			return psmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			agent.close();
			return 0;
		}finally {
			agent.close();
		}
	}

	// 아래 둘은 YourClosetCustomer.java의 북마크 추가 제거에 쓰임
	public int addBookmark(UserDTO user, ProductDTO product) {
		DBAgent agent = new DBAgent();

		String sql = "INSERT INTO bookmark (bid, pname, pid, userid) VALUES (?, ?, ?, ?)";

		
		try {
			PreparedStatement psmt = agent.getCon().prepareStatement(sql);
			psmt.setInt(1, bid);
			psmt.setString(2, product.getPname());
			psmt.setInt(3, product.getPid());
			psmt.setString(4, user.getId());

			bid++;

			return psmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int deleteBookmark(int bid) {
		DBAgent agent = new DBAgent();

		String sql = "DELETE FROM bookmark WHERE bid = ?";

		try {
			PreparedStatement psmt = agent.getCon().prepareStatement(sql);
			psmt.setInt(1, bid);

			return psmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}

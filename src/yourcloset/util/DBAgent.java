/*
 * DBAgent Class
 * DBAgent���� DB�� ����ó��
 */

package yourcloset.util;

import java.sql.*;

public class DBAgent {
	private String server = "127.0.0.1:3306"; // ���� DBMS �����ּ�

	// ������ DB, ����� ID, �н����带 ����
	private String database = "yourcloset";
	private String username = "root";
	private String password = "onlyroot";

	// DBMS ����, SQL ���� ����, ��� ó���� ���� �ʿ��� ����
	private Connection con = null;

	// �ڵ���
	public DBAgent() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (java.lang.ClassNotFoundException e) {
			System.err.println("  !! <JDBC ���� > Driver load ����: " + e.getMessage());
			e.printStackTrace();
		}
		// Conncetion ��ü ���� - loadConnect �ڵ��� �ߺ��� ���� ���� �����ڿ��� ó��
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?characterEncoding=euckr",
					username, password);

			System.out.println("");

		} catch (SQLException ex) {

			System.err.println("conn ����:" + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void close() {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		;

	}

	public Connection getCon() {
		return con;
	}
}

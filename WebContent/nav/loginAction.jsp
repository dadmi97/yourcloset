<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.sql.*, yourclosetDAO.*, yourclosetDTO.*,com.yourcloset.utils.MD5"%>
<%
	request.setCharacterEncoding("euc-kr");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String password = MD5.getMd5(pass);
	
	UserDAO userDAO = new UserDAO();
	UserDTO user = null;

	if (userDAO.login(id, password) != null) {
		user = userDAO.selectUserByUserId(id);
		session.isNew();
		session.setAttribute("user", user);
		out.println("<script>alert(' �α��� ����! ����� �������� �̵��մϴ�. ')</script>");
		if (user.getPosition().equals("customer"))
			pageContext.forward("/member/profile.jsp");
		else
			pageContext.forward("/member/profileManager.jsp");

	} else{
		out.println("<script>alert(' �α��� ����! �α��� �������� �̵��մϴ�. ')</script>");
		out.println("<script>location.href='login.jsp'</script>");	
	}
%>


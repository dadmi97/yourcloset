<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.sql.*, yourclosetDAO.*, yourclosetDTO.*,com.yourcloset.utils.MD5"%>

<%
	response.setContentType("text/html; charset=euc-kr");
	
	// ȸ������ DB�� ����Ǵ� �κ�
	// ȸ������ �� �α��� �������� �Ѿ�� �ϱ� ���ؼ� ���⿡ ������
	UserDAO userDAO = new UserDAO();
	UserDTO user = null;
	
	request.setCharacterEncoding("euc-kr"); //Set encoding
	String userID = request.getParameter("userID");
	String username = request.getParameter("username");
	String password = MD5.getMd5(request.getParameter("password"));
	String address = request.getParameter("address");

	user = new UserDTO(userID, password, username, address, "customer");
	if(userDAO.SignUp(user)!=0){
		//response.getWriter().println("<script>alert(' ȸ�� ������ �Ϸ�Ǿ����ϴ�.\n �α��� �������� �̵��մϴ�!'); location.href='login.jsp';</script>");
		response.sendRedirect("login.jsp");
	}else{
		response.getWriter().println("<script>alert('ȸ�� ���Կ� �����Ͽ����ϴ�.\n ȸ������ �������� ���ư��ϴ�.');</script>");
		//response.sendRedirect("join.jsp");
	}
%>


<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.util.*, yourcloset.util.*, yourclosetDAO.*, yourclosetDTO.*"%>
<%
	ProductDAO dao = new ProductDAO();
	String id = (String) request.getAttribute("pid");
	int pid = 0;
	if (id != null) {
		pid = Integer.parseInt(id);
		if (dao.deleteProduct(pid) > 0) {
			out.println("<script>alert(' ��ǰ�� �����Ǿ����ϴ�! '); location.href='productList.jsp';</script>");
		}
	} else {
		out.println("<script>alert(' ��ǰ ���� ����! '); location.href='productList.jsp';</script>");
	}
%>
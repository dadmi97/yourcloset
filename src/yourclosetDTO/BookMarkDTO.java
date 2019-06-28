package yourclosetDTO;

public class BookMarkDTO {
	private int bid; // �ϸ�ũ ��ȣ - ����� ������ ��������
	private String pname; // ��ǰ��
	private int pid; // ��ǰ��ȣ
	private String userId; // User ID

	public BookMarkDTO() {} // default ������
	public BookMarkDTO(String pname, int pid, String userId) { // ���ã�� ����� �� ����ϴ� ������
		this.pname = pname;
		this.pid = pid;
		this.userId = userId;
	}
	public BookMarkDTO(int bid, String pname, int pid, String userId) { // ���� �޾ƿ��� ������
		this(pname,pid,userId);
		this.bid = bid;
	}

	@Override
	public String toString() {
		return " Book Mark [�ϸ�ũ ID =" + bid + ", ��ǰ �̸� =" + pname + ", �� ID=" + userId + "]";
	}
	
	public String toCustomer() {
		return " Book Mark [�ϸ�ũ ID =" + bid+", ��ǰ ID = "+pid+", ��ǰ �̸� = "+pname+"]";
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}

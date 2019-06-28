package yourclosetDTO;

public class UserDTO {
	private String id;		// User�� ID
	private String pw;		// User�� ��й�ȣ
	private String name;	// User�� �̸�
	private String address;	// User�� �ּ�
	private int point = 0;	// User�� ���� ����Ʈ
	private String position; // �����ڿ� �� �и� - staff, user
	
	public UserDTO() {} // default ������
	public UserDTO(String id, String pw, String name, String address, String position){ // ȸ�����Խ� ����ϴ� ������
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.position = position;
	}
	public UserDTO(String id, String pw, String name, String address, int point, String position){ // ������ �޾ƿö� ����ϴ� ������
		this(id,pw,name,address,position);
		this.point = point;
	}
	
	public UserDTO(String id, String pw, String name, String address, int point) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.point = point;
	}
	
	

	@Override
	public String toString() {
		return "User [���̵� = " + id + ", �̸� = " + name + ", �ּ� = " + address + ", �ܾ� ����Ʈ = " + point + "]";
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public void addPoint(int point) {
		this.point += point;
	}
	public void minusPoint(int point) { // ����Ʈ ������ ���
		this.point -= point;
	}
	public int getPoint() // point�� ���Ž� �ö� ���� ������ ���� setter ���� X
	{
		return point;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}

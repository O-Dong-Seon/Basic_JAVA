package problem.cafemember;

import java.sql.Date;

public class MemberDTO {
	
	private int bno;
	private String name;
	private String nickname;
	private String pw;
	private int point;
	private Date regdate;

	public MemberDTO() {}
	
	
	
	

	public MemberDTO(int bno, String name, String nickname, String pw) {
		super();
		this.bno = bno;
		this.name = name;
		this.nickname = nickname;
		this.pw = pw;
	}





	public MemberDTO(String nickname, String pw) {
		super();
		this.nickname = nickname;
		this.pw = pw;
	}





	public MemberDTO(String name, String nickname, String pw) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.pw = pw;
	}





	public MemberDTO(int bno, String name, String nickname, String pw, int point, Date regdate) {
		super();
		this.bno = bno;
		this.name = name;
		this.nickname = nickname;
		this.pw = pw;
		this.point = point;
		this.regdate = regdate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MemberDTO [bno=" + bno + ", name=" + name + ", nickname=" + nickname + ", pw=" + pw + ", point=" + point
				+ ", regdate=" + regdate + "]";
	} 
	
	
	
	
}

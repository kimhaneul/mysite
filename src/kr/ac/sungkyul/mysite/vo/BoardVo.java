package kr.ac.sungkyul.mysite.vo;

public class BoardVo {
	

	private Long no;
	private String title;
	private String content;
	private int view_count;
	private int group_no;
	private int order_no;
	private int depth;
	private long user_no;
	private String reg_date;
	private String User_name;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public int getGroup_no() {
		return group_no;
	}
	public void setGroup_no(int group_no) {
		this.group_no = group_no;
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public long getUser_no() {
		return user_no;
	}
	public void setUser_no(long user_no) {
		this.user_no = user_no;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}
	
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", view_count=" + view_count
				+ ", group_no=" + group_no + ", order_no=" + order_no + ", depth=" + depth + ", user_no=" + user_no
				+ ", reg_date=" + reg_date + ", User_name=" + User_name + "]";
	}

}

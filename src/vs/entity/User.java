package vs.entity;

import java.io.Serializable;
/**
 * @Description: TODO 实体类
 * @author Andrew
 * @date 2017年3月19日
 */
public class User implements Serializable{
	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String password;
	private String sex;
	private String city;
	private String hobbies;
	private String introduction;
	private int vote;
	private int userType;
	private int isCandidate;
	public String getId() {
		return id;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public User() {
		super();
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getIsCandidate() {
		return isCandidate;
	}
	public void setIsCandidate(int isCandidate) {
		this.isCandidate = isCandidate;
	}
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public User(String id, String name, String password, String sex, String city,
			 String hobbies, String introduction) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.city = city;
		this.hobbies = hobbies;
		this.introduction = introduction;
	}
	public User(String id, String name, String password, int vote, int userType, int isCandidate) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.vote = vote;
		this.userType = userType;
		this.isCandidate = isCandidate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", sex=" + sex + ", city=" + city
				+ ", hobbies=" + hobbies + ", introduction=" + introduction + ", vote=" + vote + ", userType="
				+ userType + ", isCandidate=" + isCandidate + "]";
	}
}

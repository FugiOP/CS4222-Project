package Pack;

import java.io.Serializable;

public class FacultyModel implements Serializable{
	private static final long serialVersionUID = 1L;
	String name;
	int ssn;
	int age;
	String gender;
	String rspec;
	int rank;
	
	public FacultyModel(String name, int ssn, int age, String gender, String rspec, int rank) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.age = age;
		this.gender = gender;
		this.rspec = rspec;
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRspec() {
		return rspec;
	}
	public void setRspec(String rspec) {
		this.rspec = rspec;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	

	
}

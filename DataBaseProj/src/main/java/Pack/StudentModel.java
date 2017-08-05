package Pack;

public class StudentModel {
	int ssn;
	String name;
	int age;
	char gender;
	String degree;
	String advisor;
	
	public StudentModel(int ssn, String name, int age, char gender, String degree,String advisor) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.degree = degree;
		this.advisor = advisor;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getAdvisor() {
		return advisor;
	}
	public void setAdvisor(String advisor) {
		this.advisor = advisor;
	}
	
}

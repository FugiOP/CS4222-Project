package Pack;

import java.sql.Date;
import java.io.Serializable;

public class ProjectModel implements Serializable{

	private static final long serialVersionUID = 1L;
	int pno;
	String sponsorName;
	Date startDate;
	Date endDate;
	String budget;
	String pi;
	
	
	public ProjectModel(int pno, String sponsorName, Date startDate, Date endDate, String budget,String pi) {
		super();
		this.pno = pno;
		this.sponsorName = sponsorName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.budget = budget;
		this.pi = pi;
	}
	public String getPi() {
		return pi;
	}
	public void setPi(String pi) {
		this.pi = pi;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getSponsorName() {
		return sponsorName;
	}
	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	
	
}

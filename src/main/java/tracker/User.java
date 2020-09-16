package tracker;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="users")
public class User {
	
	@Id
	private String email;
	@NotEmpty
	private String fName;
	private String lName;
	@NotEmpty
	private String manager;
	@NotEmpty
	private boolean passed;
	
	public User() {}
	
	public User(String email, String fName, String lName, String manager) {
		super();
		this.email = email;
		this.fName = fName;
		this.lName = lName;
		this.manager = manager;
		this.passed = false;
		
	}
	
	public String getPassedString() {
		if (this.passed) {
			return "Passed";
		} else {
			return "Not Passed";
		}
	}
	
	public void setPassed(boolean passed) {this.passed = passed;}
	
	
	public String getEmail() {return email;}
	public String getfName() {return fName;}
	public String getlName() {return lName;}
	public String getManager() {return manager;}
	public boolean getPassed() {return passed;}
	
	public void setEmail(String email) {this.email = email;}
	public void setfName(String fName) {this.fName = fName;}
	public void setlName(String lName) {this.lName = lName;}
	public void setManager(String manager) {this.manager = manager;}
	
	@Override
	public String toString() {
		return "User [email=" + email +
                ", fName=" + fName + ", lName=" + lName +
                ", manager=" + manager + "]";
	}
	
}

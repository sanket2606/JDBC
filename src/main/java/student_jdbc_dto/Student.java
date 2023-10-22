package student_jdbc_dto;

public class Student
{
	private int id;
	private String name;
	private String lastName;
	private String address;
	private long mobaile;
	private String dob;
	private String gender;
	private int parcentage;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobaile() {
		return mobaile;
	}
	public void setMobaile(long mobaile) {
		this.mobaile = mobaile;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getParcentage() {
		return parcentage;
	}
	public void setParcentage(int parcentage) {
		this.parcentage = parcentage;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", lastName=" + lastName + ", address=" + address + ", mobaile="
				+ mobaile + ", dob=" + dob + ", gender=" + gender + ", parcentage=" + parcentage + "]";
	}
	
	
	
	

}

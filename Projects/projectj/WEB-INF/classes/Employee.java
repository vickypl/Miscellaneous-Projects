public class Employee {
	private long id;
	private String name;
	private String job;
	private float salary;
	private float commition;
	private java.sql.Date hireDate;
	private long deptNo;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public float getCommition() {
		return commition;
	}

	public void setCommition(float commition) {
		this.commition = commition;
	}

	public java.sql.Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(java.sql.Date hireDate) {
		this.hireDate = hireDate;
	}

	public long getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(long deptNo) {
		this.deptNo = deptNo;
	}
	
}

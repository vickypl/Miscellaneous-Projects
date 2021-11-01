	public class Employee {
		
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String date;
	private long salary;
	private int comm;
	private int deptNo;

	public void setEmpno(int empno) {
		this.empno=empno;
	}

	public int getEmpNo() {
		return empno;
	}

	public void setEname(String ename) {
		this.job=job;
	}

	public String getEname() {
		return ename;
	}

	public void setJob(String job) {
		this.job=job;
	}

	public String getJob() {
		return job;
	}

	public void setMgr(int mgr) {
		this.mgr=mgr;
	}

	public int getMgr() {
		return mgr;
	}

	public void setDate(String date) {
		this.date=date;
	}

	public String getDate() {
		return date;
	}

	public void setSalary(long salary) {
		this.salary=salary;
	}

	public long getSalary() {
		return salary;
	}

	public void setComm(int comm) {
		this.comm=comm;
	}

	public int getComm() {
		return comm;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo=deptNo;
	}

	public int getDeptNo() {
		return deptNo;
	}
}
import java.util.Date;

public class ServiceRecord implements Comparable<ServiceRecord> {
    private String regNum;
    private String issue;
    private String Name;
    private Date date;
	private boolean completed = false;
	private Date completedDate = null;



    public ServiceRecord(String regNum, String issue, String Name, Date date) {
        this.regNum = regNum;
        this.issue = issue;
        this.Name = Name;
        this.date = date;
    }
	
	public String getRegNum() {
		return regNum;
	}
	
	public void markCompleted() {
		this.completed = true;
		this.completedDate = new Date();
	}

	public boolean isCompleted() {
		return completed;
	}

    public Date getDate(){ 
		return date; 
	}

    @Override
    public int compareTo(ServiceRecord other) {
        return this.date.compareTo(other.date);
    }

    @Override
	public String toString() {
		String status = completed ? "Completed on: " + completedDate : "Pending";
		return "Date: " + date + ", Reg#: " + regNum + ", Issue: " + issue + ", Mechanic: " + Name + ", Status: " + status;
	}

}
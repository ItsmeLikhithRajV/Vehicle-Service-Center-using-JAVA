public class ServiceRequest{
	
	private String reg;
	private String issue;
	
	public ServiceRequest(String reg, String issue){
		this.reg = reg;
		this.issue = issue;
	}
	
	public String getRegNum(){
		return reg;
	}
	
	public String getIssue(){
		return issue;
	}
	
	@Override
	public String toString(){
		return reg+" "+issue;
	}
}
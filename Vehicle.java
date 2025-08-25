public class Vehicle{
	
	private int id;
	private String regnum;
	private String model;
	
	public Vehicle(int id, String regnum, String model){
		this.id = id;
		this.regnum = regnum;
		this.model = model;
	}
	
	public int getId(){
		return id;
	}
	
	public String getRegNum(){
		return regnum;
	}
	
	public String getModel(){
		return model;
	}
	
	@Override
	public String toString(){
		return id+" "+regnum+" "+model;
	}
}
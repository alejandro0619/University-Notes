package database;

public class DbScheme {
	private String number;
	private String name;
	private String kind1;
	private String kind2;
	private String sex;
	private String address;
	
	public DbScheme(String number, String name, String kind1, String kind2, String sex, String address) {
		this.number = number;
		this.name = name;
		this.kind1 = kind1;
		this.kind2 = kind2;
		this.sex = sex;
		this.address = address;
	}
	
	public String getNumber() {
		return this.number;
	}
	public String getName() {
		return this.name;
	}
	public String getKind1() {
		return this.kind1;
	}
	public String getKind2() {
		return this.kind2;
	}
	public String getSex() {
		return this.sex;
	}
	public String getAddress() {
		return this.address;
	}
}

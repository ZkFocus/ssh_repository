package examples;

public class ExampleBean {

	private int years;
	private String ultimateAnswer;
	public ExampleBean(int years, String ultimateAnswer) {
		super();
		this.years = years;
		this.ultimateAnswer = ultimateAnswer;
	}
	@Override
	public String toString() {
		return "ExampleBean [years=" + years + ", ultimateAnswer=" + ultimateAnswer + "]";
	}
	
}

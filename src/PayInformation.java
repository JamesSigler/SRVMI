public class PayInformation {
	protected double amount;
	protected String method;
	
	PayInformation()
	{
		this.amount = 0.0;
		this.method = "";
	}
	
	PayInformation(double amt, String meth)
	{
		this.amount = amt;
		this.method = meth;
	}
	
	public double getAmount()
	{
		return this.amount;
	}
	
	public void setAmount(double amt)
	{
		this.amount = amt;
	}
	
	@Override
	public String toString() {
		String output = "";
		output += "The amount paid by this payment method is $" + (Math.round(this.amount * 100) / 100) + "\n";
		output += "Via a " + this.method + "\n";
		return output;
	}
}

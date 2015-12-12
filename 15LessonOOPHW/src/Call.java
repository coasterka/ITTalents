public class Call {
	
	private static double priceForAMinute = 0.30;
	private String caller;
	private String receiver;
	private double duration;
	
	public static double getPriceForAMinute() {
		return Call.priceForAMinute;
	}

	public static void setPriceForAMinute(double priceForAMinute) {
		Call.priceForAMinute = priceForAMinute;
	}

	public String getCaller() {
		return this.caller;
	}

	public void setCaller(String caller) {
		this.caller = caller;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	public double getDuration() {
		return this.duration;
	}
	
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	@Override public String toString() {
		double priceForCall = this.duration * Call.priceForAMinute;
		String s = "Caller: " + this.caller + ", Receiver: " + this.receiver +
				", Duration: " + this.duration + ", Price: " + priceForCall;
		return s;
	}
}
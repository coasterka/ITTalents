import java.util.regex.Pattern;

public class GSM {
	
	private String model;
	private boolean hasSimCard;
	private String simMobileNumber;
	private double outgoingCallsDuration;
	private Call lastIncomingCall;
	private Call lastOutgoingCall;
	
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isHasSimCard() {
		return this.hasSimCard;
	}

	public void setHasSimCard(boolean hasSimCard) {
		this.hasSimCard = hasSimCard;
	}

	public String getSimMobileNumber() {
		return this.simMobileNumber;
	}

	public void setSimMobileNumber(String simMobileNumber) {
		this.simMobileNumber = simMobileNumber;
	}

	public double getOutgoingCallsDuration() {
		return this.outgoingCallsDuration;
	}

	public void setOutgoingCallsDuration(double outgoingCallsDuration) {
		this.outgoingCallsDuration = outgoingCallsDuration;
	}

	public Call getLastIncomingCall() {
		return this.lastIncomingCall;
	}

	public void setLastIncomingCall(Call lastIncomingCall) {
		this.lastIncomingCall = lastIncomingCall;
	}

	public Call getLastOutgoingCall() {
		return this.lastOutgoingCall;
	}

	public void setLastOutgoingCall(Call lastOutgoingCall) {
		this.lastOutgoingCall = lastOutgoingCall;
	}

	public void insertSimCard(String simMobileNumber) {
		if (Pattern.matches("08[0-9]{8}", simMobileNumber) && simMobileNumber.length() == 10) {
			this.simMobileNumber = simMobileNumber;
			this.hasSimCard = true;
		}
		else {
			System.out.println("Invalid SIM mobile number!");
			return;
		}
	}
	
	public void removeSimCard() {
		this.hasSimCard = false;
		this.simMobileNumber = null;
	}
	
	public void call(GSM receiver, double duration) {
		if (!this.hasSimCard|| !receiver.hasSimCard) {
			System.out.println("Both GSMs must have their SIM cards inserted!");
			return;
		}
		if (duration <= 0) {
			System.out.println("Call duration can not be negative or = 0!");
			return;
		}
		if (this.simMobileNumber == receiver.simMobileNumber) {
			System.out.println("You can not call yourself!");
			return;
		}
		Call currentCall = new Call();
		currentCall.setDuration(duration);
		currentCall.setReceiver(receiver.simMobileNumber);;
		currentCall.setCaller(this.simMobileNumber);;
		this.lastOutgoingCall = currentCall;
		receiver.lastIncomingCall = currentCall;
		this.outgoingCallsDuration += duration;
	}
	
	public double getSumForCalls() {
		double sumForCalls = this.outgoingCallsDuration * Call.getPriceForAMinute();
		return sumForCalls;
	}
	
	public void printInfoForTheLastOutgoingCall() {
		if (this.lastOutgoingCall == null) {
			System.out.println("There is no last outgoing call for this GSM!");
			return;
		}
		else {
			System.out.println(this.lastOutgoingCall);
		}
	}
	
	public void printInfoForTheLastIncomingCall() {
		if (this.lastIncomingCall == null) {
			System.out.println("There is no last incoming call for this GSM!");
			return;
		}
		else {
			System.out.println(this.lastIncomingCall);
		}
	}
}
public class CallsProgram {
	
	public static void main(String[] args) {
		
		GSM htc = new GSM();
		htc.insertSimCard("0888998877");
		
		System.out.println("SIM mobile number: " + htc.getSimMobileNumber());
		System.out.println("Has SIM card: " + htc.isHasSimCard()); // true
		
		htc.removeSimCard();
		
		System.out.println("Has SIM card: " + htc.isHasSimCard()); // false
		
		GSM lenovo = new GSM();
		
		htc.call(lenovo, 10); // no SIM card in lenovo
		
		htc.insertSimCard("0888998877");
		lenovo.insertSimCard("0877123456");
		
		htc.call(lenovo, -12); // invalid duration
		
		htc.call(htc, 3); // invalid receiver
		
		htc.call(lenovo, 10); // valid call
		
		System.out.println(htc.getSumForCalls()); // 10 * 0.3
		
		htc.printInfoForTheLastIncomingCall(); // none
		htc.printInfoForTheLastOutgoingCall();
		
		lenovo.printInfoForTheLastIncomingCall();
		lenovo.printInfoForTheLastOutgoingCall(); // none
	}
}
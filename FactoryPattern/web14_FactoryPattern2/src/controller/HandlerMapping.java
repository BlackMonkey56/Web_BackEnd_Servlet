package controller;

public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {
		System.out.println("handler Creating...");
	}
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("register")) {
			controller = new RegisterController();
		}else if(command.equals("find")) {
			controller = new FindController();
		}
		
		return controller;
	}
}

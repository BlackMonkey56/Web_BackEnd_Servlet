package test;

import action.Action;
import factory.ActionFactory;

public class MainTest {

	public static void main(String[] args) {
		//1. command값 받는다
		String command = "INSERT";
		
		//2. Factory
		Action action = ActionFactory.getInstance().createAction(command);
		
		//3.
		action.execute();
	}

}

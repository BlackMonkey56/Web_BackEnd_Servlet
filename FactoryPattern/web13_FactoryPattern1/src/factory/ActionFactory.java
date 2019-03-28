package factory;

import action.Action;
import action.InsertAction;
import action.deleteAction;
import action.updateAction;

/*
 * Action들을 만들어내는 공장
 * ::
 * InsertAction, DeleteAction, UpdateAction
 */
public class ActionFactory {
	private static ActionFactory factory = new ActionFactory();
	private ActionFactory() {
		System.out.println("Factory Creating...");
	}
	public static ActionFactory getInstance() {
		return factory;
	}
	
	public Action createAction(String command) {
		Action action = null;
		
		if(command.equals("INSERT")) {
			action = new InsertAction();
		}else if(command.equals("DELETE")) {
			action = new deleteAction();
		}else if(command.equals("UPDATE")) {
			action = new updateAction();
		}
		
		return action;
	}
	
}

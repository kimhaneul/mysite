package kr.ac.sungkyul.mysite.web.main;


import kr.ac.sungkyul.mysite.web.user.JoinFormAction;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.ActionFactory;

public class UserActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		// TODO Auto-generated method stub
		Action action = null;
		if ("joinform".equals(actionName)) {
			action = new JoinFormAction();
		}

		return action;
	}
}

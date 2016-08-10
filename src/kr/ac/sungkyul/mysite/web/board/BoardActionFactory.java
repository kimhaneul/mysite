package kr.ac.sungkyul.mysite.web.board;

import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		// TODO Auto-generated method stub

		Action action = null;
		if ("list".equals(actionName)) { // 게시판
			action = new BoardAction();
		}else if ("view".equals(actionName)){
			action = new ViewAction();
		}else if ("writeform".equals(actionName)){
			action = new WriteFormAction();
		}else if ("write".equals(actionName)){
			action = new WriteAction();
		}else if ("modifyForm".equals(actionName)){
			action = new ModifyFromAction();
		}else if ("modify".equals(actionName)){
			action = new ModifyAction();
		}
		else {
			action = new BoardAction();
		}

		return action;
	}

}

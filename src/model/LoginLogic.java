package model;

public class LoginLogic {
	public boolean ismember(User user){
		if(user.getPass().equals("0817")){
			return true;
		}
		return false;
	}
}

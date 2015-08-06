package elevator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ElevatorRequest extends Request {
	
	
	public ElevatorRequest(String s) throws ElevatorError{
		Pattern p=Pattern.compile("([1-6])");
		Matcher m=p.matcher(s);
		if(!m.find())
			throw new ElevatorError();
		String f = m.group(1);
		setFloor(Character.digit(f.charAt(0),10));
		
	}
	
	public String getDirection() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

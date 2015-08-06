package elevator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FloorRequest extends Request {
		public FloorRequest(String s) throws ElevatorError{
			Pattern p=Pattern.compile("([1-6])\\s*,\\s*(Up|Down)");
			Matcher m=p.matcher(s);
			if(!m.find())
				throw new ElevatorError();
			String f = m.group(1);
			String d = m.group(2);
			setFloor(Character.digit(f.charAt(0),10));
			if(d.equals("Up"))
				direct = Direction.Up;
			else if(d.equals("Down"))
				direct = Direction.Down;
			if(getFloor()==1&&direct==Direction.Down||getFloor()==6&&direct==Direction.Up)
				throw	new ElevatorError();
		}
		private Direction direct;
		public String getDirection() {
			// TODO Auto-generated method stub
			return new String(direct.toString());
		}
}

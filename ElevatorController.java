package elevator;

import java.util.Scanner;
import java.util.regex.*;


public class ElevatorController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		lift=new Elevator();

		queue=new RequestQueue();
		try {
			run();
		} catch (ElevatorError e) {
			// TODO Auto-generated catch block
			System.out.println(e.message());
			System.exit(0);
		}

	}
	
	static private Elevator lift=new Elevator();;
	static private RequestQueue queue=new RequestQueue();
	static private void run() throws ElevatorError{
		int desFloor;
		Scanner sc= new Scanner(System.in);
		String 	src=sc.nextLine();
		sc.close();
		String sub,s;
		Pattern pattern=Pattern.compile("(\\s*(\\([^\\(\\)]*?\\),?){1,}\\s*?)+");
		Matcher match=pattern.matcher(src);
		if(!match.find()){
			throw new ElevatorError();
		}
		else if(match.start()!=0||match.end()!=src.length())
			throw new ElevatorError();
		pattern=Pattern.compile("(\\([^\\(\\)]*?\\),?)");
		match = pattern.matcher(src);
		while(match.find()){
			s=match.group();
			if((sub=checkFloorRequest(s))!=null){
				queue.offer(new FloorRequest(sub));
			}
			else if((sub=checkElevatorRequest(s))!=null){
				queue.offer(new ElevatorRequest(sub));
			}
			else{
				
				throw new ElevatorError();
			}
		}
		
		
		//System.out.println(queue.isEmpty());
		while(!queue.isEmpty()){
			desFloor=queue.poll().getFloor();
			lift.dispatch(desFloor);
		}
		
		return ;
	}
	static private String checkFloorRequest(String src){
		Pattern p=Pattern.compile("\\s*\\(\\s*F_R\\s*,\\s*([1-6]\\s*,\\s*(Up|Down))\\s*\\),?\\s*");
		Matcher m=p.matcher(src);
		if(!m.find()||m.end()!=src.length())
			return null;
		
		return m.group(1);
	}
	static private String checkElevatorRequest(String src){
		Pattern p=Pattern.compile("\\s*\\(\\s*E_R\\s*,\\s*([1-6])\\s*\\),?\\s*");
		Matcher m=p.matcher(src);
		if(!m.find()||m.end()!=src.length())
			return null;
		return m.group(1);
	}

}

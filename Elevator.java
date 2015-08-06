package elevator;

class Elevator {
	private enum State {
		Pass,Stop;

	}
	private int floor;
	private Direction direct;
	private State	  state;
	public Elevator(){
		floor=1;
		direct=Direction.Up;
		state=State.Stop;
	}
	
	public void dispatch(int desfloor){		//可保证请求合理
		if(desfloor<floor){
			direct=Direction.Down;
			state=State.Pass;
			do{
				floor--;
				if(floor==desfloor){
					state=State.Stop;
				}
				if(floor==1)
					direct=Direction.Up;
				show();
			}while(floor!=desfloor);
		}
		else if(desfloor>floor){
			direct=Direction.Up;
			state=State.Pass;
			do{
				floor++;
				if(floor==desfloor){
					state=State.Stop;
				}
				if(floor==6)
					direct=Direction.Down;
				show();
			}while(floor!=desfloor);
		}
		else
		show();
	}
	
	private void show(){
		System.out.println("("+floor+","+direct.toString()+","+state.toString()+")");
	}
	
}

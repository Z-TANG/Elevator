package elevator;

abstract class Request {
	private int floor;
	public int getFloor(){return floor;};
	protected void setFloor(int f) throws ElevatorError{
		if(f<1||f>6)
			throw new ElevatorError();
		floor = f;
	}
	abstract public String getDirection();
}

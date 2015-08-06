package elevator;

class ElevatorError extends Exception {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ElevatorError(){
		
	}
	
	public	String message(){
		return "Illegal Request!";
		
	}
}

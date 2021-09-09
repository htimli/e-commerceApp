package e_commerce.application;

import java.util.ArrayList;
import java.util.List;

public class CommandQueue {
	
	
	private List<Command> commands ;
	
	
	public CommandQueue() {
		this.commands= new ArrayList<>();
	}
	
	public void pushCommand(Command newcommand){
		synchronized (this.commands) {
			this.commands.add(newcommand);	
		}				
	}
	public Command getCommand() {
			return this.commands.remove(0);	
	}
	public Boolean isEmpty() {
		return this.commands.isEmpty();
	}
	public List<Command> getList(){
		return this.commands;
	}
	
	

}

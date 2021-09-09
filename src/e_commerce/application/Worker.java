package e_commerce.application;

public class Worker extends Thread {
	
	private CommandQueue queue;
	
	
	public Worker(CommandQueue commands) {
		this.queue=commands;
	}
	
	public void run() {
		while(true) {
			synchronized (queue.getList()) {
				if(!queue.isEmpty()) {
					Command command = this.queue.getCommand();
					command.execute();	
				}
			}	
		}			
	}
	


}

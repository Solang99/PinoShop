package GUI;

public class Controller {
	private static RegisterFrame 
	registerFrame;
	LoginFrame loginFrame;
	public static void main (String[] args) {
		Controller controller = new Controller ();
		 registerFrame = new RegisterFrame(controller);

		registerFrame.setVisible(true);
	}
	
	public void GoToLoginFrame() {
		registerFrame.dispose();
		loginFrame= new LoginFrame(this);
		loginFrame.setVisible(true);
		
	}
	
	public void GoToRegisterFrame() {
		loginFrame.dispose();
		registerFrame= new RegisterFrame(this);
		registerFrame.setVisible(true);
		
	}
	
}

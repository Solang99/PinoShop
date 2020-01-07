package GUI;

public class Controller {
	private static RegisterFrame 
	registerFrame;
	LoginFrame loginFrame;
	public static void main (String[] args) {
		Controller controller = new Controller ();
<<<<<<< HEAD

		MainFrame mainframe = new MainFrame();
	 mainframe.setVisible(true);

		registerFrame = new RegisterFrame(controller);
		registerFrame.setVisible(true);

=======

		MainFrame mainframe = new MainFrame();
		mainframe.setVisible(true);
>>>>>>> 331083c4ee5d28fbb636a9558df3eaa2fa52f439
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

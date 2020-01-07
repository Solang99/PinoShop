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
=======

		registerFrame = new RegisterFrame(controller);
		registerFrame.setVisible(true);
>>>>>>> 65d9edb500d943fc56809a9f841a6a00e39f3ccc
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

package GUI;

public class Controller {
	RegisterFrame registerFrame;
	LoginFrame loginFrame;
	public static void main (String[] args) {
		Controller controller = new Controller ();
		RegisterFrame registerFrame = new RegisterFrame(controller);
	}
	
	public void GoToLoginFrame() {
		registerFrame.dispose();
		loginFrame= new LoginFrame();
		loginFrame.setVisible(true);
		
	}
}

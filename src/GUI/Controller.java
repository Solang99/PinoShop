package GUI;

public class Controller {
	private static RegisterFrame 
	registerFrame;
	LoginFrame loginFrame;
	public static void main (String[] args) {
		Controller controller = new Controller ();
<<<<<<< HEAD
		registerFrame = new RegisterFrame(controller);
=======
		 registerFrame = new RegisterFrame(controller);

>>>>>>> 027f64e5d7320ddc14c470657059d574e4807f32
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

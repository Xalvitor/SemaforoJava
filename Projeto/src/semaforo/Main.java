package semaforo;

public class Main {
	
	private static UiSemaforo uiSemaforo;
	private static Semaforo semaforo;
	
	public static void main(String[] args) {

		semaforo = new Semaforo();
		uiSemaforo = new UiSemaforo(semaforo);
		
		while(true) {
			uiSemaforo.mostrarCor(semaforo.getCor());
			semaforo.esperaMudar();
		}
		
	}
	
	
	
	
	
	/*public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					uiSemaforo = new UiSemaforo();
					uiSemaforo.setVisible(true);
					
					uiSemaforo.mostrarCor("teste");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}*/
	

}



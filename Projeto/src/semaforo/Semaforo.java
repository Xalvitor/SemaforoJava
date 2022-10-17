package semaforo;

public class Semaforo implements Runnable {
	
	private CorSemaforo cor;
	private boolean parar;
	private boolean corMudou;
	
	public Semaforo() {
		this.cor = CorSemaforo.Verde;
				
		this.parar = false;
		
		this.corMudou = false;
		new Thread(this).start();
		
	}
	@Override
	public void run() {
		
		while(!parar){
			try {
				System.out.println("TRED ESTA RODANDO");
				Thread.sleep(this.cor.getTempoEspera());
				this.mudarCor();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private synchronized void mudarCor() {
		switch(this.cor) {
		case Verde:
			this.cor = CorSemaforo.Amarelo;
			break;
		case Amarelo:
			this.cor = CorSemaforo.Vermelho;
			break;
		case Vermelho:
			this.cor = CorSemaforo.Verde;
			break;
		default:
			break;	
		}
		this.corMudou = true;
		notify();
	}
	
	public synchronized void esperaMudar() {
		
		while(!this.corMudou) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.corMudou = false;
	}

	public synchronized void desligar() {
		this.parar = true;
	}
	
	
	public CorSemaforo getCor() {
		return cor;
	}

}

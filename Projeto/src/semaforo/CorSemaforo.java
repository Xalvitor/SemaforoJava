package semaforo;

public enum CorSemaforo {
	
	Verde(120000), Amarelo(30000), Vermelho(60000);
	
	private int TempoEspera;
	
	CorSemaforo(int tempoEspera){
		this.TempoEspera = tempoEspera;
	}
	
	public int getTempoEspera() {
		return TempoEspera;
	}

}	

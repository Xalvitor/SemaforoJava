package semaforo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

public class UiSemaforo extends JFrame {

	private JPanel contentPane;
	private JButton botaoParar;
	private JTextArea textArea;
	private JScrollPane textAreaScroll;
		
	public UiSemaforo(final Semaforo semaforo) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		setVisible(true);
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		botaoParar = new JButton("Parar");
		botaoParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				semaforo.desligar();
			}
		});
		botaoParar.setBounds(10, 11, 414, 41);
		contentPane.add(botaoParar);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		contentPane.add(textArea);
		
		textAreaScroll = new JScrollPane(textArea);
		textAreaScroll.setBounds(10, 60, 420, 190);
		textAreaScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(textAreaScroll);

	}
	
	public void mostrarCor(CorSemaforo corSemaforo) {
		textArea.append(corSemaforo+"\n");
	}
	
}

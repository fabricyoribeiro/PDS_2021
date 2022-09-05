package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import util.SpringUtilities;

public class TemaPanel extends JPanel{
	private JLabel nome,valorAluguel,corToalha, temaLabel;
	private JTextField nomeF,valorF,corF;
	private JPanel dadosPanel, tituloPanel;
	private JButton salvarButton;
	private ButtonPanel buttonPanel;
	
	public TemaPanel() {
		setLayout(new BorderLayout());
		
		temaLabel = new JLabel("CADASTRAR TEMA");
		
		nome = new JLabel("Nome:");
		nomeF = new JTextField(13);
		valorAluguel = new JLabel("Valor do Aluguel");
		valorF = new JTextField(13);
		
		valorF.addKeyListener(new KeyAdapter() {
			  public void keyTyped(KeyEvent e) {
			    char c = e.getKeyChar();
			       if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
			    	 Mensagem.exibirMensagem("Este campo aceita somente números");
			        e.consume();  // ignore the event if it's not an alphabet
			    }
			   }
		});
		corToalha = new JLabel("Cor da Toalha");
		corF = new JTextField();
		
		tituloPanel = new JPanel();
		tituloPanel.add(temaLabel);
		
		buttonPanel = new ButtonPanel();
		
		dadosPanel = new JPanel(new SpringLayout());
		dadosPanel.add(nome);
		dadosPanel.add(nomeF);
		dadosPanel.add(valorAluguel);
		dadosPanel.add(valorF);
		dadosPanel.add(corToalha);
		dadosPanel.add(corF);
		SpringUtilities.makeCompactGrid(dadosPanel,3,2,4,4,4,4);	
		add(tituloPanel, BorderLayout.NORTH);
		add(BorderLayout.CENTER,dadosPanel);
		add(BorderLayout.SOUTH,buttonPanel);
	}
	
	
	public JLabel getNome() {
		return nome;
	}
	public void setNome(JLabel nome) {
		this.nome = nome;
	}
	public JLabel getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(JLabel valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	public JLabel getCorToalha() {
		return corToalha;
	}
	public void setCorToalha(JLabel corToalha) {
		this.corToalha = corToalha;
	}
	public JPanel getDadosPanel() {
		return dadosPanel;
	}


	public JButton getSalvarButton() {
		return salvarButton;
	}


	public JTextField getNomeF() {
		return nomeF;
	}
	public void setNomeF(JTextField nomeF) {
		this.nomeF = nomeF;
	}
	public JTextField getValorF() {
		return valorF;
	}
	public void setValorF(JTextField valorF) {
		this.valorF = valorF;
	}
	public JTextField getCorF() {
		return corF;
	}
	public void setCorF(JTextField corF) {
		this.corF = corF;
	}


	public JLabel getTemaLabel() {
		return temaLabel;
	}


	public JPanel getTituloPanel() {
		return tituloPanel;
	}


	public ButtonPanel getButtonPanel() {
		return buttonPanel;
	}
	
	
	
}

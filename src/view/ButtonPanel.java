package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import util.SpringUtilities;

public class ButtonPanel extends JPanel{
	
    private JButton removerButton,atualizarButton, cadastrarButton;
	
	public ButtonPanel() {
		
		setLayout(new SpringLayout());
		
		removerButton = new JButton("Remover");
		atualizarButton = new JButton("Atualizar");
		cadastrarButton = new JButton("Cadastrar");
		removerButton.setVisible(false);
		atualizarButton.setVisible(false);
		
		add(removerButton);
		add(atualizarButton);
		add(cadastrarButton);
		
		SpringUtilities.makeCompactGrid(this,1,3,4,4,4,4);
		setVisible(true);
	}

	public JButton getRemoverButton() {
		return removerButton;
	}

	public JButton getAtualizarButton() {
		return atualizarButton;
	}

	public JButton getCadastrarButton() {
		return cadastrarButton;
	}
	

}

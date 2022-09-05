package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import model.BaseDeDados;
import model.Cliente;
import model.ClienteException;
import model.Tema;
import model.TemaException;
import model.TipoErro;
import view.Mensagem;
import view.TelaMenu;

public class TemaController implements ActionListener{

	private FormularioHandler formularioHandler;
	private TelaMenu telaMenu;


	public TemaController(TelaMenu telaMenu) {
		this.formularioHandler = new FormularioHandler();
		this.telaMenu = telaMenu;

		control();
	}
	
	private void control() {
		
		telaMenu.getTemaPanel().getButtonPanel().getRemoverButton().addActionListener(this);
		telaMenu.getTemaPanel().getButtonPanel().getAtualizarButton().addActionListener(this); //atualizar

		telaMenu.getTemaPanel().getButtonPanel().getCadastrarButton().addActionListener(this);
		telaMenu.getTemaPanel().getButtonPanel().getCadastrarButton().setEnabled(false);
		telaMenu.getTemaPanel().getNomeF().addCaretListener(formularioHandler);
		telaMenu.getTemaPanel().getValorF().addCaretListener(formularioHandler);
		telaMenu.getTemaPanel().getCorF().addCaretListener(formularioHandler);
		telaMenu.getBuscarTemaPanel().getBuscarTemaButton().addActionListener(this);
		
		
	}

	private class FormularioHandler implements FocusListener, CaretListener{

		@Override
		public void caretUpdate(CaretEvent e) {
			if(telaMenu.getTemaPanel().getNomeF().getText().length()!=0
					&& telaMenu.getTemaPanel().getValorF().getText().length()!=0
					&& telaMenu.getTemaPanel().getCorF().getText().length()!=0) {
				telaMenu.getTemaPanel().getButtonPanel().getCadastrarButton().setEnabled(true);
			}else {
				telaMenu.getTemaPanel().getButtonPanel().getCadastrarButton().setEnabled(false);
			}
		}

		@Override
		public void focusGained(FocusEvent e) {

		}

		@Override
		public void focusLost(FocusEvent e) {



		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==telaMenu.getTemaPanel().getButtonPanel().getRemoverButton()) {
			try {
				BaseDeDados.removerTema(BaseDeDados.buscarTema(telaMenu.getBuscarTemaPanel().getNomeTemaT().getText().toUpperCase()));
				Mensagem.exibirMensagem("Tema removido com sucesso");
				telaMenu.getTemaPanel().setVisible(false);
			} catch (TemaException e1) {
				Mensagem.exibirMensagem(TipoErro.NAO_EXISTE_TEMA);
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == telaMenu.getTemaPanel().getButtonPanel().getAtualizarButton()) {
			try {
				atualizarTema();
				Mensagem.exibirMensagem("Tema atualizado com sucesso");
			} catch (TemaException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource()==telaMenu.getBuscarTemaPanel().getBuscarTemaButton()) {

			if(BaseDeDados.buscarTema(telaMenu.getBuscarTemaPanel().getNomeTemaT().getText().toUpperCase())!=null){
				telaMenu.getTemaPanel().getTemaLabel().setText("BUSCA REALIZADA");
				telaMenu.getTemaPanel().getNomeF().setText(BaseDeDados.buscarTema(telaMenu.getBuscarTemaPanel().getNomeTemaT().getText().toUpperCase()).getNome());

				telaMenu.getTemaPanel().getValorF().setText(String.valueOf(BaseDeDados.buscarTema(telaMenu.getBuscarTemaPanel().getNomeTemaT().getText().toUpperCase()).getValorAluguel()));
				telaMenu.getTemaPanel().getCorF().setText(BaseDeDados.buscarTema(telaMenu.getBuscarTemaPanel().getNomeTemaT().getText().toUpperCase()).getCorToalha());


				telaMenu.getFestaPanel().setVisible(false);
				telaMenu.getTemaPanel().getButtonPanel().getCadastrarButton().setVisible(false);
				telaMenu.getTemaPanel().getButtonPanel().getAtualizarButton().setVisible(true);
				telaMenu.getTemaPanel().getButtonPanel().getRemoverButton().setVisible(true);
				telaMenu.getFormularioBuscarCliente().setVisible(false);
				telaMenu.getFormularioCliente().setVisible(false);
				telaMenu.getFormularioCliente().getEnderecoPanel().setVisible(false);
				telaMenu.getBuscarTemaPanel().setVisible(false);
				telaMenu.getTemaPanel().setVisible(true);
				

			}else {
				Mensagem.exibirMensagem("Tema não está cadastrado.");
			}

		}
		if(e.getSource() == telaMenu.getTemaPanel().getButtonPanel().getCadastrarButton()) {
			salvarTema();
			telaMenu.getTemaPanel().getNomeF().setText("");
			telaMenu.getTemaPanel().getValorF().setText("");
			telaMenu.getTemaPanel().getCorF().setText("");
		}


		
	}
	
	private Tema novoTema() {
		return new Tema(telaMenu.getTemaPanel().getNomeF().getText().toUpperCase(), 
				Float.parseFloat(telaMenu.getTemaPanel().getValorF().getText()),
				telaMenu.getTemaPanel().getCorF().getText());
		
	}
	
	private boolean atualizarTema() throws TemaException {
		Tema temaOld = BaseDeDados.buscarTema(telaMenu.getBuscarTemaPanel().getNomeTemaT().getText().toUpperCase());
		Tema temaNew = novoTema();

		try {
			BaseDeDados.atualizarTema(temaOld, temaNew);
		} catch (TemaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println(temaOld.getNome());
		System.out.println(temaNew.getNome());
		return false;
	}
	
	private boolean salvarTema() {
		Tema tema = new Tema(telaMenu.getTemaPanel().getNomeF().getText().toUpperCase(),
				Float.parseFloat(telaMenu.getTemaPanel().getValorF().getText()),
				telaMenu.getTemaPanel().getCorF().getText());
		try {
			return BaseDeDados.adicionarTema(tema);
		} catch (TemaException e) {
			Mensagem.exibirMensagem(TipoErro.EXISTE_TEMA);
			e.printStackTrace();
		}
		return false;
	}
}

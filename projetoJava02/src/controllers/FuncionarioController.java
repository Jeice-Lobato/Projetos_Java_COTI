package controllers;

import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.swing.JOptionPane;

import entities.Funcionario;

import enums.TipoContratacao;

import repositories.FuncionarioRepository;

public class FuncionarioController {

	

    public void cadastrarFuncionario() {

    	var funcionario = new Funcionario();
    	var funcionarioRepository = new FuncionarioRepository();
    	
    	try {
    		funcionario.setId(UUID.randomUUID());
    		funcionario.setNome(JOptionPane.showInputDialog("Nome do Funcionario: "));
    		funcionario.setMatricula(JOptionPane.showInputDialog("Matricula do Funcionario: "));
    		funcionario.setDataAdmissao
    			(new SimpleDateFormat("dd/MM/yyyy").parse(JOptionPane.showInputDialog("Data de Admissão (dd/MM/aaaa): ")));
    		
    		var opcao = JOptionPane.showInputDialog("Opção: 1=Estagio, 2=CLT, 3=Terceirização");
    		
    		switch(opcao) {
    		case "1" : funcionario.setTipoContratacao(TipoContratacao.ESTAGIO); break;
    		case "2" : funcionario.setTipoContratacao(TipoContratacao.CLT); break;
    		case "3" : funcionario.setTipoContratacao(TipoContratacao.TERCEIRIZADO); break;
    		}		
    		
    		funcionarioRepository.exportarDados(funcionario);
    					
    	}
    	catch(Exception e) {
    		System.out.println("\nERRO------> "+e.getMessage());
    	}
    	
    }

}

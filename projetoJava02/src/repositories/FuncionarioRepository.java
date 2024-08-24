package repositories;

import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import entities.Funcionario;

/*
* Classe para acessar e manipular arquivos ou banco de dados[
* para armazenamento dos registros de funcionários.
*/
public class FuncionarioRepository {
	/*
	 * Método para gravar os dados do funcionário em arquivo
	 */
	public void exportarDados(Funcionario funcionario) {

		try {

			// criando um arquivo txt para gravação em modo 'append'
			// append -> o arquivo nunca será substituido, mas sim terá o conteudo
			// adicionado
			var fileWriter = new FileWriter("c:\\temp\\funcionarios.txt", true);
			var printWriter = new PrintWriter(fileWriter);

			// escrevendo os dados do funcionário no arquivo
			printWriter.write("Id do funcionário...: " + funcionario.getId());
			printWriter.write("Nome................: " + funcionario.getNome());
			printWriter.write("Matrícula...........: " + funcionario.getMatricula());
			printWriter.write("Data de admissão....: " + funcionario.getDataAdmissao());
			printWriter.write("Tipo dhe contratação.: " + funcionario.getTipoContratacao());

			// fechando o arquivo
			printWriter.close();

			JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
		} catch (Exception e) {
			System.out.println("\nFalha ao gravar o arquivo: " + e.getMessage());
		}
	}
}

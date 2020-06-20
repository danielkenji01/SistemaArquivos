package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivosController implements IArquivosController {

	private static final String CAMINHO = "C:\\TEMP";
	@Override
	public void verificaDirTemp() throws IOException {
		// TODO Auto-generated method stub
		
		File diretorio = new File(CAMINHO);
		
		if (!diretorio.exists()) {
			diretorio.mkdir();
		}
	}

	@Override
	public boolean verificaCadastro(String arquivo, int codigo) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File(CAMINHO + "\\" + arquivo);
		
		if (!file.exists()) {
			return false;
		}
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		
		String linha = null;
		
		while((linha = reader.readLine()) != null) {
			if (linha.contains(String.valueOf(codigo))) {
				return true;
			}
		}
		
		reader.close();
		
		return false;
	}

	@Override
	public void imprimeCadastro(String arquivo, int codigo) throws IOException {
		// TODO Auto-generated method stub
		
		if (!verificaCadastro(arquivo + ".csv", codigo)) {
			return;
		}
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(CAMINHO + "\\" + arquivo + ".csv"), "UTF-8"));
		
		String linha = null;
		
		while((linha = reader.readLine()) != null) {
			if (linha.contains(String.valueOf(codigo))) {
				String[] split = linha.split(";");
				
				System.out.println("Código: " + split[0]);
				System.out.println("Nome: " + split[1]);
				System.out.println("E-mail: " + split[2]);
			}
		}
		
		reader.close();
	}

	@Override
	public void insereCadastro(String arquivo, int codigo, String nome, String email) throws IOException {
		// TODO Auto-generated method stub
		
		if (this.verificaCadastro(arquivo + ".csv", codigo)) {
			return;
		}
		
		FileWriter fileWriter = new FileWriter(CAMINHO + "\\" + arquivo + ".csv", true);
		
		fileWriter.append(String.valueOf(codigo));
		fileWriter.append(";");

		fileWriter.append(nome);
		fileWriter.append(";");
		
		fileWriter.append(email);
		fileWriter.append(";");

		fileWriter.append("\n");
		
		fileWriter.flush();
		fileWriter.close();
	}

}

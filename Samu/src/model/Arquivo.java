package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import controller.ControladorCadastroMedico;
import controller.ControladorCadastroPaciente;
import controller.ControladorCadastroPatologia;
import controller.ControladorMedicamento;
import controller.ControladorAtendimento;

public class Arquivo {
	
	private static String linha = "";
	private static BufferedReader leitorBuffer = null;
	private static String csvSeparador = ";";
	
	public static boolean write(String caminho, String texto) {
		try {
			FileWriter arq = new FileWriter(caminho);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.println(texto);
			gravarArq.close();
			return true;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar os dados no arquivo");
			return false;
		}
	}
	
	public static boolean writeAdicionaFinal (String caminho, String[] texto) {
		 
		try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(caminho, true))){

			for (String linha: texto) {
				bWriter.write(linha);
				bWriter.newLine();
			}
			return true;
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar os dados no arquivo");
			return false;
		}
	}
	
	public static boolean writeAdicionaReescrevendo (String caminho, String[] texto) {
		 
		try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(caminho))){

			for (String linha: texto) {
				bWriter.write(linha);
				bWriter.newLine();
			}
			return true;
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar os dados no arquivo");
			return false;
		}
	}
	
	public static boolean limpaDados (String caminho, String[] texto) {
		 
		try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(caminho))){

			for (String linha: texto) {
				bWriter.write("");
				bWriter.newLine();
			}
			return true;
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar os dados no arquivo");
			return false;
		}
	}
	
	public static void carregarPacientes() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		ArrayList<Paciente> array = new ArrayList<Paciente>();
		
		try {
			leitorBuffer = new BufferedReader(new FileReader("Paciente.txt"));
			while ((linha = leitorBuffer.readLine()) != null) {
				String[] dados = linha.split(csvSeparador);
				Endereco modeloEndereco = new Endereco();
				Paciente paciente = new Paciente();
				
				modeloEndereco.setLogradouro(dados[0]);
				modeloEndereco.setNumero(Integer.parseInt(dados[1]));
				modeloEndereco.setComplemento(dados[2]);
				modeloEndereco.setBairro(dados[3]);
				modeloEndereco.setCidade(dados[4]);
				modeloEndereco.setEstado(dados[5]);
				modeloEndereco.setCep(dados[6]);
				modeloEndereco.setTelefone(dados[7]);
				
				paciente.setNome(dados[8]);
				paciente.setCpf(dados[9]);
				paciente.setRg(dados[10]);
				paciente.setEndereco(modeloEndereco);
				
				Date data = new Date();
				try {
					data = sdf.parse(dados[11]);
				} catch (Exception e) {
				}
				paciente.setDataNascimento(data);
				paciente.setSexo(dados[12]);
				paciente.setTipoSanguineo(dados[13]);
				paciente.setFiliacao(dados[14]);
				
				array.add(paciente);
			}
		} catch (FileNotFoundException e1) {
			System.out.println("Arquivo n�o encontrado : \n" + e1.getMessage());
		} catch (ArrayIndexOutOfBoundsException e2) {
			System.out.println("IndexOutOfBounds Lente: \n" + e2.getMessage());
		} catch (IOException e3) {
			System.out.println("IO Error: \n" + e3.getMessage());
		} finally {
			if (leitorBuffer != null) {
				try {
					leitorBuffer.close();
				} catch (IOException e) {
					System.out.println("IO Error: \n" + e.getMessage());
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Dados importados!");
		ControladorCadastroPaciente.importaDados(array);
	}
	
	public static void carregarMedicos() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		ArrayList<Medico> array = new ArrayList<Medico>();
		
		try {
			leitorBuffer = new BufferedReader(new FileReader("M�dico.txt"));
			while ((linha = leitorBuffer.readLine()) != null) {
				String[] dados = linha.split(csvSeparador);
				Endereco modeloEndereco = new Endereco();
				Medico medico = new Medico();
				
				modeloEndereco.setLogradouro(dados[0]);
				modeloEndereco.setNumero(Integer.parseInt(dados[1]));
				modeloEndereco.setComplemento(dados[2]);
				modeloEndereco.setBairro(dados[3]);
				modeloEndereco.setCidade(dados[4]);
				modeloEndereco.setEstado(dados[5]);
				modeloEndereco.setCep(dados[6]);
				modeloEndereco.setTelefone(dados[7]);
				
				medico.setNome(dados[8]);
				medico.setCpf(dados[9]);
				medico.setRg(dados[10]);
				medico.setEndereco(modeloEndereco);
				
				Date data = new Date();
				try {
					data = sdf.parse(dados[11]);
				} catch (Exception e) {
				}
				medico.setDataNascimento(data);
				medico.setSexo(dados[12]);
				medico.setCrm(Integer.parseInt(dados[13]));
				medico.setEspecialidade(dados[14]);
				medico.setAreaAtuacao(dados[15]);
				
				array.add(medico);
			}
		} catch (FileNotFoundException e1) {
			System.out.println("Arquivo n�o encontrado : \n" + e1.getMessage());
		} catch (ArrayIndexOutOfBoundsException e2) {
			System.out.println("IndexOutOfBounds Lente: \n" + e2.getMessage());
		} catch (IOException e3) {
			System.out.println("IO Error: \n" + e3.getMessage());
		} finally {
			if (leitorBuffer != null) {
				try {
					leitorBuffer.close();
				} catch (IOException e) {
					System.out.println("IO Error: \n" + e.getMessage());
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Dados importados!");
		ControladorCadastroMedico.importaDados(array);
	}
	
	public static void carregarAtendimentos() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		ArrayList<Atendimento> array = new ArrayList<Atendimento>();
		
		try {
			leitorBuffer = new BufferedReader(new FileReader("Atendimento.txt"));
			while ((linha = leitorBuffer.readLine()) != null) {
				String[] dados = linha.split(csvSeparador);
				
				Endereco modeloEndereco = new Endereco();
				Atendimento atendimento = new Atendimento();
				
				modeloEndereco.setLogradouro(dados[0]);
				modeloEndereco.setNumero(Integer.parseInt(dados[1]));
				modeloEndereco.setComplemento(dados[2]);
				modeloEndereco.setBairro(dados[3]);
				modeloEndereco.setCidade(dados[4]);
				modeloEndereco.setEstado(dados[5]);
				modeloEndereco.setCep(dados[6]);
				modeloEndereco.setTelefone(dados[7]);
				
				atendimento.setSolicitante(dados[8]);
				atendimento.setApelidoOcorrencia(dados[9]);
				atendimento.setPontoReferencia(dados[10]);
				atendimento.setLocalizacaoOcorrencia(modeloEndereco);
				atendimento.setSexoAtendido(dados[11]);
				atendimento.setMotivo(dados[12]);
				atendimento.setOrigem(dados[13]);
				atendimento.setTipoLigacao(dados[14]);
				atendimento.setIdadeAparente(Integer.parseInt(dados[15]));
				atendimento.setDataLigacao(dados[16]);
				atendimento.setCpf(dados[17]);
				array.add(atendimento);
			}
			
		} catch (FileNotFoundException e1) {
			System.out.println("Arquivo n�o encontrado : \n" + e1.getMessage());
		} catch (ArrayIndexOutOfBoundsException e2) {
			System.out.println("IndexOutOfBounds Armação: \n" + e2.getMessage());
		} catch (IOException e3) {
			System.out.println("IO Error: \n" + e3.getMessage());
		} finally {
			if (leitorBuffer != null) {
				try {
					leitorBuffer.close();
				} catch (IOException e) {
					System.out.println("IO Error: \n" + e.getMessage());
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Dados importados!");
		ControladorAtendimento.importaDados(array);
	}
}
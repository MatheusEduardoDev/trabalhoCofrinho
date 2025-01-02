package cofrinho;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cofrinho {

	private ArrayList<Moeda> listaMoedas = new ArrayList<>();

	// metodo para adicionar objetos do tipo Moeda na listaMoedas
	public void adicionar(Moeda moeda) {
		this.listaMoedas.add(moeda);
	}

	// metodo para remover objetos do tipo Moeda na listaMoedas
	public void remover(Moeda moeda) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o valor:");
		int contagemDeLoops = 0;

		while (true) {
			// caso o usuario ainda nao tenha colocado nenhuma moeda na lista esta mensagem
			// sera exibida
			if (listaMoedas.size() == 0) {
				System.out.println();
				System.out.println("antes de remover Voce precisa adicionar uma Moeda no cofrinho...");
				break;
			}
			try {

				double valor = sc.nextDouble();

				for (int i = 0; i < listaMoedas.size(); i++) {
					// if para remover somente o objeto especificado junto com o valor especifico
					if (moeda.getClass() == listaMoedas.get(i).getClass() && valor == listaMoedas.get(i).valor) {
						listaMoedas.remove(i);
						System.out.println("Moeda removida com sucesso!!!");
						contagemDeLoops++;
						break;
					}

				}
				// contagemDeLoops foi criada para caso o usuario escolher um objeto do tipo
				// Moeda e digitar um valor errado
				if (contagemDeLoops == 0) {
					System.out.print("Não á uma Moeda ");
					moeda.info();
					System.out.println(" com esse valor ");
					System.out.println("Por favor digite novamente:");
				} else {
					break;
				}

				// caso usuario digite uma letra uma exeçao sera lançada...
			} catch (InputMismatchException e) {
				System.out.println("Digito invalido, por favor digite somente numeros!!!");
				sc.nextLine();// limpando a entrada do console para que nao fique em um loop infinito
			}
		}
	}

	// lista todas as moedas colocadas no cofrinho
	public void listagemMoedas() {
		for (int i = 0; i < listaMoedas.size(); i++) {
			listaMoedas.get(i).info();
			System.out.println(" - " + listaMoedas.get(i).valor);

		}

	}

	// converte tidas as moedas em real
	public void totalConvertido() {
		double valorTotalConvertido = 0;
		for (int i = 0; i < listaMoedas.size(); i++) {
			valorTotalConvertido += listaMoedas.get(i).converter();

		}
		System.out.println("O total convertido para real: " + valorTotalConvertido);

	}

}

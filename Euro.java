package cofrinho;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Euro extends Moeda {

	private final double taxaConvercao = 6.36;

	public void setValor() {
		Scanner sc = new Scanner(System.in);
		while (true) {

			try {

				double valor = sc.nextDouble();

				/*
				 * caso valor seja maior do que 0 o bloco if é executado adicionando o valor no
				 * atributo e fazendo tambem o while parar com break;
				 */
				if (valor > 0) {
					this.valor = valor;
					System.out.println("Valor adicionado com sucesso!!!");
					System.out.println();
					break;
					// else entra em açao caso o usuario digite um valor fora do esperado como <=0
				} else {
					System.out.println("Valor precisa ser maior do que 0");
					System.out.println("Por favor digite novamente:");
					valor = sc.nextDouble();
				}

				// caso usuario digite uma letra uma exeçao sera lançada...
			} catch (InputMismatchException e) {
				System.out.println("Digito invalido, por favor digite somente numeros...");
				System.out.println("Digite o valor:");
				sc.nextLine();// limpando a entrada do console para que nao fique em um loop infinito
			}
		}
	}

	// subescrevendo o metodo da Classe Pai para ter informaçao da moeda atual
	@Override
	public void info() {
		System.out.print("Euro");
	}

	// subescrevendo o metodo da Classe Pai para retornar um valor de converçao para
	// a moeda real
	@Override
	public double converter() {
		double valorConvertido = 0;
		return valorConvertido = valor * taxaConvercao;
	}

}

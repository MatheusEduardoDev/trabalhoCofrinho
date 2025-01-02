package cofrinho;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Cofrinho cofri = new Cofrinho();
		Real r = null;
		Dolar d = null;
		Euro e = null;

		while (true) {
			System.out.println("COFRINHO:");
			System.out.println("1-Adicionar Moeda");
			System.out.println("2-Remover Moeda");
			System.out.println("3-Listar Moeda");
			System.out.println("4-Calcular total convertido para Real");
			System.out.println("0-Encerrar");

			try {

				int digito = sc.nextInt();

				if (digito == 1) {
					while (true) {
						System.out.println("Escolha Moeda:");
						System.out.println("1-Real");
						System.out.println("2-Dolar");
						System.out.println("3-Euro");

						try {

							int moeda = sc.nextInt();

							// adicionando Objeto Real junto com o valor desejado na listaMoedas
							if (moeda == 1) {
								System.out.println("Digite o valor:");
								cofri.adicionar(r = new Real());
								r.setValor();
								break;

								// adicionando Objeto Dolar junto com o valor desejado na listaMoedas
							} else if (moeda == 2) {
								System.out.println("Digite o valor:");
								cofri.adicionar(d = new Dolar());
								d.setValor();
								break;

								// adicionando Objeto Euro junto com o valor desejado na listaMoedas
							} else if (moeda == 3) {
								System.out.println("Digite o valor:");
								cofri.adicionar(e = new Euro());
								e.setValor();
								break;

								// else entra em açao caso o usuario digite um valor fora do esperado como <=0
								// || >3
							} else {
								System.out.println("Digito invalido, por favor digite novamente...");
							}

							// caso usuario digite uma letra uma exeçao sera lançada...
						} catch (InputMismatchException e2) {
							System.out.println("Digito invalido, por favor digite somente numeros...");
							sc.nextLine();// limpando a entrada do console para que nao fique em um loop infinito
						}
					}

				} else if (digito == 2) {
					while (true) {
						System.out.println("Escolha Moeda:");
						System.out.println("1-Real");
						System.out.println("2-Dolar");
						System.out.println("3-Euro");

						try {

							int moeda = sc.nextInt();

							// removendo somente o Objeto Real junto com o valor
							if (moeda == 1) {
								r = new Real();
								cofri.remover(r);
								break;

								// removendo somente o Objeto Dolar junto com o valor
							} else if (moeda == 2) {
								d = new Dolar();
								cofri.remover(d);
								break;

								// removendo somente o Objeto Euro junto com o valor
							} else if (moeda == 3) {
								e = new Euro();
								cofri.remover(e);
								break;
								// else entra em açao caso o usuario digite um valor fora do esperado como <=0
								// || >3
							} else {
								System.out.println("Digito invalido, por favor digite novamente...");
							}

							// caso usuario digite uma letra uma exeçao sera lançada...
						} catch (InputMismatchException e3) {
							System.out.println("Digito invalido, por favor digite somente numeros...");
							sc.nextLine();// limpando a entrada do console para que nao fique em um loop infinito
						}
					}

					/*
					 * referencia cofri chama o metodo listagemMoedas para listar todas as moedas
					 * colocadas no cofrinho
					 */
				} else if (digito == 3) {
					cofri.listagemMoedas();

					// referencia cofri chama o metodo listagemMoedas para converter todas as moedas
					// em real
				} else if (digito == 4) {
					cofri.totalConvertido();

					// se caso usuario digitar 0, break; encerra o loop(while)
				} else if (digito == 0) {
					System.out.println("Final do programa");
					break;
				} else {
					System.out.println("Digito invalido, por favor digite novamente...");

				}

				// caso usuario digite uma letra uma exeçao sera lançada...
			} catch (InputMismatchException e1) {
				System.out.println("Digito invalido, por favor digite somente numeros!!!");
				sc.nextLine();// limpando a entrada do console para que nao fique em um loop infinito
			}

		}

	}
}

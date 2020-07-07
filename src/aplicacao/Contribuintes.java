package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Pessoa;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;

public class Contribuintes {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Pessoa> lista = new ArrayList<>();

		System.out.print("Entre com o numero de contribuintes: ");
		Integer num = sc.nextInt();

		for (int i = 1; i <= num; i++) {
			System.out.println("Dados do Contribuinte #" + i);
			System.out.print("Fisica ou Juridica (f/j): ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			String nome = sc.next();
			System.out.print("Renda Anual: ");
			Double rendaAnual = sc.nextDouble();
			if (ch == 'f') {
				System.out.print("Despesas Medicas: ");
				Double despMedica = sc.nextDouble();
				lista.add(new PessoaFisica(nome, rendaAnual, despMedica));
			} else {
				System.out.print("Numero de Funcionarios: ");
				int numFunc = sc.nextInt();
				lista.add(new PessoaJuridica(nome, rendaAnual, numFunc));
			}
		}
		System.out.println();
		System.out.println("Impostos Pagos:");

		double soma = 0;

		for (Pessoa cont : lista) {
			System.out.println(cont.getNome() + " $ " + String.format("%.2f", cont.calculoImposto()));
			soma += cont.calculoImposto();
		}

		System.out.println();
		System.out.println("Total de Impostos: $ " + String.format("%.2f", soma));

		sc.close();

	}
}

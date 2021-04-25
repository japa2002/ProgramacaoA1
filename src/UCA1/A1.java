package UCA1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class A1 {

	public static void main(String[] args) {

		int cont = 0;
		String deseja = "", aposentado;
		double maior = 0, Smaior = 0;
		String nomeMaior = "", nomeSegundoMaior = "";

		int QtdTempBeneficio = 0;
		int QtdTempMiorBeneficio1 = 0;
		int QtdTempMiorBeneficio2 = 0;
		String beneficiarioMiorTemp1 = "";
		String beneficiarioMiorTemp2 = "";
		double contadorBeneficio = 0;
		int contBe = 0;

		do {

			Scanner dado = new Scanner(System.in);

			String nomeCompleto;
			System.out.println("Informe o nome completo: ");
			nomeCompleto = dado.nextLine();

			String dataNascimento;
			System.out.println("Informe a data de nascimento: ");
			dataNascimento = dado.next();

			String nomeCategoria = "";
			int categoria;
			System.out.println("------Categoria-----");
			System.out.println("| 1 - Empregado    |");
			System.out.println("| 2 - Empregador   |");
			System.out.println("| 3 - Desempregado |");
			System.out.println("--------------------");
			System.out.println("Informe categoria: ");
			categoria = dado.nextInt();

			double beneficioEmpregado;
			System.out.println("Informe o beneficio do empregado: ");
			beneficioEmpregado = dado.nextDouble();

			double beneficioDesempregado;
			System.out.println("Informe o beneficio do desempregado: ");
			beneficioDesempregado = dado.nextDouble();

			String estado;
			System.out.println("Informe o estado ou UF: ");
			estado = dado.next();

			LocalDate dataAtual = LocalDate.now(); // Pega data atual;
			LocalDate data = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			String etapas = "";

			dataAtual.getYear();

			int idade;
			idade = dataAtual.getYear() - data.getYear();

			double acrescimo;
			double Abeneficio;
			double beneficio = 0;

			switch (categoria) {

			case 1:
				// Empregado
				nomeCategoria = "Empregado";
				if (beneficioEmpregado >= 1000 && beneficioEmpregado <= 1800) {

					System.out.println("Empregados receberão entre R$1000 e R$1800 ");

					System.out.println("É aposentado? Sim ou Não ");
					aposentado = dado.nextLine();
					aposentado = dado.nextLine();

					double beneficio6Mes;

					if (aposentado.equals("sim")) {
						System.out.println("Aposentado");
						QtdTempBeneficio = 6;
						System.out.println("Tera apenas 6 meses de beneficio " + beneficioEmpregado);

						beneficio6Mes = beneficioEmpregado * 6;
						System.out.println("Um total de 6 meses será retirado " + beneficio6Mes);

						beneficio = beneficioEmpregado;
						etapas = etapas + "\n Recebera apenas 6 meses de beneficio ";

					}
					if (aposentado == "Não") {
						System.out.println("Nao aposentado");
						QtdTempBeneficio = 12;
						System.out.println("Apenas beneficio: " + beneficioEmpregado);
					}
				} else {
					System.out.println("O valor não condiz com o valor de empregados ");
				}

				break;

			case 2: /// verificar
				// Empregador
				nomeCategoria = "Empregador";
				System.out.println("Os empregadores receberão R$200 por funcionario ");

				int quantidadeFuncionarios;
				double beneficioEmpregador;

				beneficio = 0;

				System.out.println("Informe a quantidade de funcionarios: ");
				quantidadeFuncionarios = dado.nextInt();
				beneficioEmpregador = quantidadeFuncionarios * 200;

				// System.out.println("O beneficio do empregador é: " + beneficioEmpregador);

				if (quantidadeFuncionarios <= 40) {
					double acrescimoFuncionarios;
					acrescimoFuncionarios = beneficioEmpregador * 11 / 100;
					beneficio = beneficioEmpregador + acrescimoFuncionarios;
					etapas = etapas + "\n Recebeu 11% por ter atá 40 funcionarios ";
				}

				if (quantidadeFuncionarios <= 10) {
					QtdTempBeneficio = 10;
					System.out.println("Empregadores poderam retirar 10 beneficios " + beneficio);
					etapas = etapas + "\n Receberá até 10 beneficios ";
				} else {
					QtdTempBeneficio = 7;
					System.out.println("Empregadores só poderam retirar 7 beneficios " + beneficio);
					etapas = etapas + "\n Receberá até 7 beneficios";
				}

				break;

			case 3:
				// Desempregado
				nomeCategoria = "Desempregado";
				System.out.println("Desempregados receberão entre R$1500 e R$2300 ");

				if (beneficioDesempregado >= 1500 && beneficioDesempregado <= 2300) {

					int mesesDesempregado;

					beneficio = beneficioDesempregado;

					QtdTempBeneficio = 6;

					System.out.println("Há quantos meses esta desempregado? ");
					mesesDesempregado = dado.nextInt();
					System.out.println("Meses desmpregados: " + mesesDesempregado);
					System.out.println("Estando desempregado só poderá retirar 6 beneficios " + beneficio);

					if (mesesDesempregado <= 6) {
						System.out.println("Pode retirar o beneficio " + beneficio);
						etapas = etapas + "\n Receberá até 6 beneficios ";
					}

					if (mesesDesempregado > 6) {
						System.out.println("Não pode mais retirar o beneficio ");
					}
				}

				break;
			}

			switch (estado) {
			case "sc":
				acrescimo = beneficio * 5 / 100;
				Abeneficio = beneficio + acrescimo;

				beneficio = Abeneficio;
				etapas = etapas + "\n Por morar em Santa Catarina receberá 5% de acrescimo ";

			}

			System.out.println("Nome Completo é: " + nomeCompleto);
			System.out.println("A data de nascimento é: " + dataNascimento);
			System.out.println("Categoria: " + categoria + " - " + nomeCategoria);

			if (idade < 18) {
				System.out.println("Não pode receber o beneficio por ser menor de 18 anos ");
			} else {
				contBe++;
				System.out.println("As regras atendidas foram " + etapas);
				System.out.println("O beneficio foi de: " + beneficio + " por mês");
			}

			if (beneficio > maior) {
				maior = beneficio;
				nomeMaior = nomeCompleto;
			} else if (beneficio > Smaior) {
				Smaior = beneficio;
				nomeSegundoMaior = nomeCompleto;
			}
			if (maior < Smaior) {
				double auxi = maior;
				maior = Smaior;
				Smaior = auxi;

				String Auxi = nomeMaior;
				nomeMaior = nomeSegundoMaior;
				nomeSegundoMaior = Auxi;
			}

			if (etapas.equals("")) {
				System.out.println("Não recebeu beneficios");
			}

			if (QtdTempBeneficio >= 0 && QtdTempBeneficio <= 12) {

				if (QtdTempBeneficio > 0 && QtdTempBeneficio > QtdTempMiorBeneficio1) {
					if (QtdTempMiorBeneficio1 == 0) {
						QtdTempMiorBeneficio1 = QtdTempBeneficio;
						beneficiarioMiorTemp1 = nomeCompleto;
					} else {
						QtdTempMiorBeneficio2 = QtdTempBeneficio;
						beneficiarioMiorTemp2 = nomeCompleto;
					}
				} else if (QtdTempBeneficio > 0 && QtdTempBeneficio > QtdTempMiorBeneficio2) {
					{
						QtdTempMiorBeneficio2 = QtdTempBeneficio;
						beneficiarioMiorTemp2 = nomeCompleto;
					}

					if (QtdTempMiorBeneficio1 < QtdTempMiorBeneficio2) {
						int auxi = QtdTempMiorBeneficio1;
						QtdTempMiorBeneficio1 = QtdTempMiorBeneficio2;
						QtdTempMiorBeneficio2 = auxi;

						String Auxi = beneficiarioMiorTemp1;
						beneficiarioMiorTemp1 = beneficiarioMiorTemp2;
						beneficiarioMiorTemp2 = Auxi;
					}
				}
			}

			System.out.println("Deseja informar outro beneficiario? Sim ou Não");
			deseja = dado.next();

			contadorBeneficio = contadorBeneficio + beneficio;

			cont++;

		} while (deseja.equals("Sim"));

		System.out.println("O valor total: " + contadorBeneficio);
		System.out.println("Quantidade de usuário lidos: " + cont);
		System.out.println("Total de beneficiados: " + contBe);
		System.out.println("O maior valor é: " + maior + " é do: " + nomeMaior + "\n O segundo maior é: " + Smaior
				+ " é do: " + nomeSegundoMaior);
		System.out.println("Nome dos 2 beneficiados que iram receber os beneficios por mais tempo: 1 "
				+ beneficiarioMiorTemp1 + "\n2 " + beneficiarioMiorTemp2);
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioescola;

/**
 *
 * @author user
 */
public class EscolaMain {

    static String separator1 = "======================================================"
            + "==========================";
    static String separator2 = "------------------------------------------------------"
            + "--------------------------";
    static String fim = "~~~ FIM ~~~";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(separator1);
        System.out.println("a) Constroi objectos de cada uma das classes inst"
                + "anciáveis e guarda num contentor do tipo array");
        System.out.println(separator2);
        System.out.println(fim);

        Pessoa[] pessoas = new Pessoa[20];
        pessoas[0] = new Aluno(111111111, "Aluno 1", 999000);
        pessoas[1] = new Aluno(111111112, "Aluno 2", 999001);
        pessoas[2] = new Aluno(111111113, "Aluno 3", 999002);

        pessoas[3] = new AlunoBolsista("Bolseiro 1", 999003, 111111114, 250.0);
        pessoas[4] = new AlunoBolsista("Bolseiro 2", 999004, 111111115, 350.0);
        pessoas[5] = new AlunoBolsista("Bolseiro 3", 999005, 111111116, 50.0);

        pessoas[6] = new Professor("Prof 1", 222222000, "assistente");
        pessoas[7] = new Professor("Prof 2", 222222001, "adjunto");
        pessoas[8] = new Professor("Prof 3", 222222002, "coordenador");

        System.out.println(separator1);
        System.out.println("b) Liste o nome e categoria dos professores armazenado no contentor;");
        System.out.println(separator2);
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null && pessoa instanceof Professor) {
                System.out.printf("Nome: %s, Cat.: %s%n", ((Professor) pessoa).getNome(), ((Professor) pessoa).getCategoria());
            }
        }
        System.out.println(fim);

// Liste o número mecanográfico de todos os alunos que não são bolseiros;
        System.out.println(separator1);
        System.out.println("c) Liste o número mecanográfico de todos os alunos que não são bolseiros;");
        System.out.println(separator2);
        for (Pessoa pessoa : pessoas) {
//            if (pessoa != null && pessoa instanceof Aluno && !(pessoa instanceof AlunoBolsista)) {
            if (pessoa != null && pessoa.getClass() == Aluno.class) {
                System.out.printf("Nome: %s, Cat.: %s%n", ((Aluno) pessoa).getNome(), ((Aluno) pessoa).getNumeroMecanografico());
            }
        }
        System.out.println(fim);

        System.out.println(separator1);
        System.out.println("d) Liste os nomes dos professores e alunos, armazenados no contentor. A listagem deve incluir, "
        + "para cada objeto, a designação da classe;");
        System.out.println(separator2);
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {
                System.out.printf("Nome: %s, Classe: %s%n", ((Pessoa) pessoa).getNome(), ((Pessoa) pessoa).getClass().getSimpleName());
            }
        }
            System.out.println(fim);

            System.out.println(separator1);
            System.out.println("e) Liste os nomes e valores dos salários dos professores armazenados no contentor;");
            System.out.println(separator2);
            for (Pessoa pessoa : pessoas) {
                if (pessoa != null && pessoa.getClass() == Professor.class) {
                    System.out.printf("Nome: %s, Salário: %.2f%n", ((Professor) pessoa).getNome(), ((Professor) pessoa).calcularPagamento());
                }
            }
            System.out.println(fim);

            System.out.println(separator1);
            System.out.println("f) Liste os nomes e valores das bolsas dos alunos bolseiros armazenados no contentor;");
            System.out.println(separator2);
            for (Pessoa pessoa : pessoas) {
                if (pessoa != null && pessoa.getClass() == AlunoBolsista.class) {
                    System.out.printf("Nome: %s, Bolsa: %.2f%n", ((AlunoBolsista) pessoa).getNome(), ((AlunoBolsista) pessoa).calcularPagamento());
                }
            }
            System.out.println(fim);

            System.out.println(separator1);
            System.out.println("g) Mostre os valores totais dos encargos com: professores e alunos bolseiros. O total dos encargos da escola deve também ser apresentado.");
            System.out.println(separator2);

            double encargosBolseiros = 0.0;
            double encargosProfessores = 0.0;
            
            for (Pessoa pessoa : pessoas) {
                if (pessoa != null && pessoa.getClass() == AlunoBolsista.class) {
                    encargosBolseiros += ((AlunoBolsista) pessoa).calcularPagamento();
                }
            }
            System.out.printf("Encargos com Bolseiros: %.2f%n", encargosBolseiros);
            
            for (Pessoa pessoa : pessoas) {
                if (pessoa != null && pessoa.getClass() == Professor.class) {
                    encargosProfessores += ((Professor) pessoa).calcularPagamento();
                }
            }
            System.out.printf("Encargos com Professores: %.2f%n", encargosProfessores);
            System.out.printf("Encargos Totais: %.2f%n", encargosProfessores + encargosBolseiros);
            System.out.println(fim);
    }
}
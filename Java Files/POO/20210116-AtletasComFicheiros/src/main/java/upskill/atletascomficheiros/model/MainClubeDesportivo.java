package upskill.atletascomficheiros.model;

import java.util.List;

/**
 *
 * @author Daniel Junior Data de criação: 2020-11-25 07:56
 */
public class MainClubeDesportivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("### Criação de uma instância da classe ClubeDesportivo ###");
        ClubeDesportivo cd = new ClubeDesportivo("Club of Mine");

        System.out.println("\n### Estabelecer valor da parcela fixa dos atletas semiprofissionais ###");
        AtletaSemiProfissional.setParcelaFixa(600);

        System.out.println("\n### Armazenamento nessa instância de 3 objetos de cada uma das categorias (Profissional, Semiprofissional e Amador) ###");
        cd.adicionarAtletaProfissional("Daniel", 12121212, Atividade.GENERO_M, 30, Atividade.CAMINHADA, Atividade.IT_QUEIMARGORDURA, 68, 640, 800);
        cd.adicionarAtletaAmador("Junior", 64646464, Atividade.GENERO_M, 37, Atividade.CICLISMO, Atividade.IT_QUEIMARGORDURA, 58, 720, 14);
        cd.adicionarAtletaSemiProfissional("Margarida", 98989898, Atividade.GENERO_F, 22, Atividade.CAMINHADA, Atividade.IT_QUEIMARGORDURA, 60, 380, 8);
        cd.adicionarAtletaAmador("Andreia", 86868686, Atividade.GENERO_F, 19, Atividade.CORRIDA, Atividade.IT_TREINOCARDIORESP, 60, 7);
        cd.adicionarAtletaSemiProfissional("Pedro", 63636363, Atividade.GENERO_M, 43, Atividade.CICLISMO, Atividade.IT_QUEIMARGORDURA, 62, 370, 22);
        cd.adicionarAtletaProfissional("Filipe", 45454545, Atividade.GENERO_M, 22, Atividade.NATACAO, Atividade.IT_TREINOCARDIORESP, 74, 300, 1000);
        cd.adicionarAtletaProfissional("Maria", 15151515, Atividade.GENERO_F, 27, Atividade.CORRIDA, Atividade.IT_TREINOCARDIORESP, 59, 950);
        cd.adicionarAtletaAmador("Catarina", 14141414, Atividade.GENERO_F, 26, Atividade.CORRIDA, Atividade.IT_QUEIMARGORDURA, 57, 3);
        cd.adicionarAtletaSemiProfissional("Jorge", 37373737, Atividade.GENERO_M, 39, Atividade.NATACAO, Atividade.IT_TREINOCARDIORESP, 69, 19);

        System.out.println("\n### Criação de listagens sobre o contentor para: obter o nome, a FCM e as FCT de cada atleta semiprofissional e amador ###");
        for (Atleta atleta : cd.getAtletas()) {
            if (atleta instanceof AtletaSemiProfissional || atleta instanceof AtletaAmador) {
                System.out.printf("Nome: %-15s | Classe: %-20s | FCM: %.2f         | FCT: %.2f\n", atleta.getNome(), atleta.getClass().getSimpleName().substring(6), atleta.calcularFCM(), atleta.calcularFCT());
            }
        }

        System.out.println("\n### Criação de listagens sobre o contentor para: obter o nome e o valor a pagar de cada atleta ###");
        for (Atleta atleta : cd.getAtletas()) {
            System.out.printf("Nome: %-15s | Valor a pagar: % 8.2f\n", atleta.getNome(), atleta.calcularVencimento());
        }

        System.out.println("\n### Apresentação das quantidades de instâncias de atletas amadores e profissionais criadas, sem percorrer o contentor ###");
        System.out.printf("Número de atletas amadores: %d\nNúmero de atletas profissionais: %d\n", AtletaAmador.getContadorAtletasAmadores(), AtletaProfissional.getContadorAtletasProfissionais());

        System.out.println("\n### Calcular e apresentar o valor total a pagar a cada tipo de atleta (profissional, semiprofissional e amador), percorrendo apenas uma vez o contentor. Deve ser também calculado e apresentado o valor total a pagar a todos os atletas ###");
        double totalAmador = 0, totalSemiProfissional = 0, totalProfissional = 0;
        for (Atleta atleta : cd.getAtletas()) {
            if (atleta instanceof AtletaAmador) {
                totalAmador += atleta.calcularVencimento();
            } else if (atleta instanceof AtletaSemiProfissional) {
                totalSemiProfissional += atleta.calcularVencimento();
            } else if (atleta instanceof AtletaProfissional) {
                totalProfissional += atleta.calcularVencimento();
            }
        }
        System.out.printf("Total a pagar a atletas profissionais: %.2f\nTotal a pagar a atletas semiprofissionais: %.2f\nTotal a pagar a atletas amadores: %.2f\n", totalProfissional, totalSemiProfissional, totalAmador);
        System.out.printf("Total a pagar a todos os atletas: %.2f\n", totalProfissional + totalSemiProfissional + totalAmador);

        System.out.println("\n### Executar as funcionalidades implementadas na classe ClubeDesportivo e visualizar o seu resultado ###");
        System.out.println("### Retornar o nome do clube ###");
        System.out.printf("Nome do clube: %s\n", cd.getNome());

        System.out.println("\n### Retornar uma lista de atletas, ordenada alfabeticamente por nome, usando a interface nativa do Java Comparable ###");
        imprimirAtletasOrdemAlfabetica(cd.listarAtletasOrdemAlfabetica());

        System.out.println("\n### Retornar uma lista de atletas, ordenada inversamente pelo valor dos prémios usando a interface nativa do Java Comparator ###");
        imprimirAtletasOrdemPremio(cd.listarAtletasOrdemPremiosInversa());

        System.out.println("\n### Retornar o valor total, para efeitos de IRS, da totalidade dos atletas ###");
        System.out.printf("Total do IRS: %.2f€%n", cd.calcularIRSTotal());

        System.out.println("\n### Retornar uma lista de atletas do clube, ordenada alfabeticamente por categoria, modalidade e nome ###");
        imprimirAtletasOrdemAlfabeticaCatModNome(cd.listarAtletasPorCategoriaModalidadeENome());

    }

    private static void imprimirAtletasOrdemAlfabetica(List<Atleta> atletas) {
        for (Atleta atleta : atletas) {
            if (atleta != null) {
                System.out.printf("Nome: %-25s | Atividade: %-25s%n", atleta.getNome(), atleta.getTipoAtividade());
            }
        }
    }

    private static void imprimirAtletasOrdemPremio(List<Atleta> atletas) {
        for (Atleta atleta : atletas) {
            if (atleta != null) {
                System.out.printf("Prémio: % 7.2f | Nome: %-25s | Atividade: %-25s%n", atleta.getPremio(), atleta.getNome(), atleta.getTipoAtividade());
            }
        }
    }

    private static void imprimirAtletasOrdemAlfabeticaCatModNome(List<Atleta> atletas) {
        for (Atleta atleta : atletas) {
            String className = atleta.getClass().getSimpleName().substring(6);
            if (atleta != null) {
                System.out.printf("Classe: %-25s | Atividade: %-25s | Nome: %-25s%n", className, atleta.getTipoAtividade(), atleta.getNome());
            }
        }
    }
    //
}

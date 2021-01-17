package upskill.atletascomficheiros.model;

/**
 *
 * @author Daniel Junior Data de criação: 24/11/2020
 * @version 0.1 Interface que implementa cálculo da retenção do IRS.
 *
 * @author Jorge Pires Data de criação: 26/11/2020
 * @version 0.2 Implementação do javadoc.
 */
public interface RetencaoIRS {

    /**
     * Constante - valor percentual a ser descontado do vencimento do atleta
     * profissional e semi-profissional
     */
    final double TAXA_RETENCAO_IRS = 10.0;

    /**
     *
     * @return o cálculo do valor da retenção de IRS a deduzir ao vencimento do
     * atleta semi-profissional
     */
    double calcularRetencaoIRS();
}

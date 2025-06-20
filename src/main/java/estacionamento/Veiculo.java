package estacionamento;

/**
 * Classe que possui a identificação do véiculo para cadastro
 *
 * @author João Carlos/Lucas GOmes
 */
public class Veiculo {

    private String cpfCliente;
    private String placa;
    private String marca;
    private String modelo;
    private String cor;

    /**
     * Retorna o CPF do cliente associado ao veículo.
     *
     * @return o CPF do cliente.
     */
    public String getCpfCliente() {
        return cpfCliente;
    }

    /**
     * Define o CPF do cliente associando ele ao veículo.
     *
     * @param cpfCliente o CPF do cliente a ser definido.
     */
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    /**
     * Retorna a placa do veículo.
     *
     * @return placa do veículo.
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Define a placa do veículo.
     *
     * @param placa a placa do veículo a ser definida.
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * Retorna a marca do veículo.
     *
     * @return a marca do veículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Define a marca do veículo.
     *
     * @param marca a marca do veículo a ser preenchida.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Retorna o modelo do veículo.
     *
     * @return o modelo do veículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Define o modelo do veículo.
     *
     * @param modelo o modelo do veículo a ser definido.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Retorna a cor do veículo.
     *
     * @return a cor do veículo.
     */
    public String getCor() {
        return cor;
    }

    /**
     * Define a cor do veículo.
     *
     * @param cor cor do veículo a ser preenchida.
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

}

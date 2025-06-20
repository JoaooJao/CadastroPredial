package estacionamento;

/**
 * Classe pessoa com atributos de identificação
 */
public class Pessoa {

    public String nome;
    private String cpf;
    private String telefone;
    private String cidade;

    /**
     * Define o nome da pessoa.
     *
     * @param nome Nome a ser atribuído.
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Retorna o nome da pessoa.
     *
     * @return Nome da pessoa.
     */
    public String getNome(){
        return nome;
    }

    /**
     * Define o CPF da pessoa.
     *
     * @param cpf CPF a ser atribuído.
     */
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    /**
     * Retorna o CPF da pessoa.
     *
     * @return CPF da pessoa.
     */
    public String getCpf(){
        return cpf;
    }

    /**
     * Retorna o telefone da pessoa.
     *
     * @return Telefone da pessoa.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone da pessoa.
     *
     * @param telefone Telefone a ser atribuído.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna a cidade da pessoa.
     *
     * @return Cidade da pessoa.
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Define a cidade.
     *
     * @param cidade define a cidade.
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}

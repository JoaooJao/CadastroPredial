package estacionamento;
/**
 * Funcionário do estacionamento.
 * Herda os atributos e comportamentos da classe Pessoa
 * Adiciona dados para autenticação
 */
public class Funcionario extends Pessoa {
    private String senha;
    /**
     * Retorna a senha do funcionário.
     *
     * @return String com a senha.
     */
    public String getSenha() {
        return senha;
    }
    
    /**
     * Define  a senha do funcionário.
     *
     * @param senha senha do funcionario a ser definida.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}

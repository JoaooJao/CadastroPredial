package DAO;

import estacionamento.Funcionario;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.conversions.Bson;
import static com.mongodb.client.model.Filters.*;

import javax.swing.JOptionPane;

/**
 * Classe que realiza operações de acesso aos dados.
 */
public class FuncionarioDAO {

    /** Collection onde os dados vão ser armazenados. */
    private final MongoCollection<Document> funcionarioCollection;

    /**
     * Construtor da classe.
     * Inicializa a conexão do banco.
     */
    public FuncionarioDAO() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("EstacionamentoPOO2");
        funcionarioCollection = database.getCollection("funcionarios");
    }

    /**
     * Faz a autenticação de um funcionário
     * @param funcionario Objeto Funcionario contendo nome e senha a serem verificados.
     * @return retorna um valor booleano para a autenticação,true para acesso false caso erro.
     */
    public boolean autenticacaoFuncionario(Funcionario funcionario) {
        try {
            Bson filtro = and(
                eq("nome", funcionario.getNome()),
                eq("senha", funcionario.getSenha())
            );

            Document resultado = funcionarioCollection.find(filtro).first();

            return resultado != null;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao autenticar funcionário: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Cadastra um novo funcionário.
     *
     * @param funcionario Funcionario a ser cadastrado.
     */
    public void novoFuncionario(Funcionario funcionario) {
        try {
            // Veri
            if (funcionarioCollection.find(eq("nome", funcionario.getNome())).first() != null) {
                JOptionPane.showMessageDialog(null, "Funcionário já existe!", "Cadastro", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Document doc = new Document("nome", funcionario.getNome())
                    .append("senha", funcionario.getSenha());

            funcionarioCollection.insertOne(doc);
            JOptionPane.showMessageDialog(null, "Novo Funcionário Cadastrado", "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário: " + e.getMessage(), "Cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

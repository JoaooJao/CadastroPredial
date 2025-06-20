package DAO;

import estacionamento.Cliente;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Classe de acesso ao cliente
 *
 * @author João Carlos/Lucas Gomes
 */
public class ClienteDAO {

    private static final MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    private static final MongoDatabase database = mongoClient.getDatabase("EstacionamentoPOO2");
    private static final MongoCollection<Document> clienteCollection = database.getCollection("clientes");
    private static final MongoCollection<Document> veiculoCollection = database.getCollection("veiculos");

    /**
     * Cadastra um novo cliente no banco de dados.
     *
     * @param cliente Objeto Cliente contendo os dados a serem inseridos.
     * @return O ID gerado para o cliente cadastrado, ou null se ocorrer erro ou
     * CPF já existir.
     */
    public String cadastrarCliente(Cliente cliente) {
        try {

            Document clienteExistente = clienteCollection.find(new Document("cpf", cliente.getCpf())).first();
            if (clienteExistente != null) {
                JOptionPane.showMessageDialog(null, "Cliente já cadastrado com este CPF!", "Aviso", JOptionPane.WARNING_MESSAGE);
                return null;
            }

            Document clienteDoc = new Document("nome", cliente.getNome())
                    .append("cpf", cliente.getCpf())
                    .append("telefone", cliente.getTelefone())
                    .append("cidade", cliente.getCidade());

            clienteCollection.insertOne(clienteDoc);
            String idGerado = clienteDoc.getObjectId("_id").toHexString();

            JOptionPane.showMessageDialog(null, "Cliente Adicionado!", "ESTACIONAMENTO", JOptionPane.INFORMATION_MESSAGE);
            return idGerado;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /**
     * Lista clientes que possuem veículos registrados no sistema.
     *
     * @return Lista de clientes associados a veículos.
     */
    public List<Cliente> listaCliente() {
        List<Cliente> lista = new ArrayList<>();

        try {
            for (Document veiculo : veiculoCollection.find()) {
                Object clienteId = veiculo.get("id_cliente");
                if (clienteId instanceof ObjectId) {
                    Document clienteDoc = clienteCollection.find(new Document("_id", (ObjectId) clienteId)).first();
                    if (clienteDoc != null) {
                        Cliente cliente = new Cliente();
                        cliente.setNome(clienteDoc.getString("nome"));
                        cliente.setCpf(clienteDoc.getString("cpf"));
                        cliente.setTelefone(clienteDoc.getString("telefone"));
                        cliente.setCidade(clienteDoc.getString("cidade"));
                        lista.add(cliente);
                    }
                }
            }

            lista.sort(Comparator.comparing(Cliente::getNome, String.CASE_INSENSITIVE_ORDER));

        } catch (Exception erro) { // mostra o stack trace no console
            // mostra o stack trace no console
            JOptionPane.showMessageDialog(null, "Erro ao Listar Veículos: " + erro.getClass().getName());
        }
        return lista;
    }

    public List<Cliente> listarClientes() {
        List<Cliente> lista = new ArrayList<>();

        try {
            FindIterable<Document> docs = clienteCollection.find();
            for (Document doc : docs) {
                Cliente cliente = new Cliente();
                cliente.setCpf(doc.getString("cpf"));
                cliente.setNome(doc.getString("nome"));
                cliente.setTelefone(doc.getString("telefone"));
                cliente.setCidade(doc.getString("cidade"));
                lista.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    /**
     * Remove o cliente com base no cpf
     *
     * @param cpf retorna o cpf para ser deletado
     */
    public void removerClientePorCpf(String cpf) {
        try {
            Document filtro = new Document("cpf", cpf);
            clienteCollection.deleteOne(filtro);
            JOptionPane.showMessageDialog(null, "CLIENTE REMOVIDO", null, JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover cliente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Busca um cliente pelo seu ID
     *
     * @param idCliente ID do cliente.
     * @return Cliente com CPF preenchido, ou vazio.
     */
    public Cliente buscarClientePorId(String idCliente) {
        try {
            if (!ObjectId.isValid(idCliente)) {
                return null;
            }

            Document filtro = new Document("_id", new ObjectId(idCliente));
            Document doc = clienteCollection.find(filtro).first();

            if (doc != null) {
                Cliente cliente = new Cliente();
                cliente.setCpf(doc.getString("cpf"));
                return cliente;
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar cliente por ID: " + e.getMessage());
        }
        return null;
    }

    /**
     * Atualiza os dados de um cliente com base no CPF original.
     *
     * @param cpfOriginal rertorna o CPF atual do cliente no banco.
     * @param cliente retorna o Objeto Cliente com os dados atualizados.
     */
    public void atualizarCliente(String cpfOriginal, Cliente cliente) {
        try {
            Document filtro = new Document("cpf", cpfOriginal);
            Document atualizacao = new Document("$set", new Document()
                    .append("nome", cliente.getNome())
                    .append("cpf", cliente.getCpf())
                    .append("telefone", cliente.getTelefone())
                    .append("cidade", cliente.getCidade())
            );

            clienteCollection.updateOne(filtro, atualizacao);
        } catch (Exception e) {
        }
    }

    /**
     * Busca um cliente pelo CPF.
     *
     * @param cpf CPF do cliente.
     * @return Objeto Cliente com todos os dados preenchidos, ou null se não  encontrado
     */
    public Cliente buscarClientePorCpf(String cpf) {
        try {
            Document filtro = new Document("cpf", cpf);
            Document doc = clienteCollection.find(filtro).first();

            if (doc != null) {
                Cliente cliente = new Cliente();
                cliente.setCpf(doc.getString("cpf"));
                cliente.setNome(doc.getString("nome"));
                cliente.setTelefone(doc.getString("telefone"));
                cliente.setCidade(doc.getString("cidade"));
                return cliente;
            }
        } catch (Exception e) {
        }
        return null;
    }

}

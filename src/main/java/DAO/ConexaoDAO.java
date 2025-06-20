package DAO;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
/**
 * Classe de conexão com o MongoDB
 * @author oakens
 */
public class ConexaoDAO {

    private static final String URI = "mongodb://localhost:27017";
    private static final String NOME_BANCO = "POO2";

    private static MongoClient mongoClient;

    public static MongoClient getMongoClient() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(URI);
        }
        return mongoClient;
    }
    
    /**
     * Retorna a collection do banco de dados.
     *
     * @return uma instância de MongoDatabase.
     */
    public static MongoDatabase getDatabase() {
        return getMongoClient().getDatabase(NOME_BANCO);
    }
    /**
     * Fecha a conexão com o banco
     */
    public static void fecharConexao() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }
}

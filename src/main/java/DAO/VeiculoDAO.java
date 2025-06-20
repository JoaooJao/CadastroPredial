package DAO;

import estacionamento.Veiculo;
import com.mongodb.client.*;
import java.awt.HeadlessException;
import org.bson.Document;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {

    private final MongoCollection<Document> veiculoCollection;

    public VeiculoDAO() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("EstacionamentoPOO2");
        veiculoCollection = database.getCollection("veiculos");
    }

    // Cadastra um novo veículo no banco
    public void cadastrarVeiculo(Veiculo veiculo) {
        System.out.println("CPF salvo: " + veiculo.getCpfCliente());
        System.out.println("Cor salva: " + veiculo.getCor());
        try {
            Document doc = new Document("placa", veiculo.getPlaca())
                    .append("marca", veiculo.getMarca())
                    .append("modelo", veiculo.getModelo())
                    .append("cor", veiculo.getCor())
                    .append("cpfCliente", veiculo.getCpfCliente());

            veiculoCollection.insertOne(doc);

            JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar veículo: " + e.getMessage());
        }
    }

    // Lista todos os veículos com os dados associados
    public List<Veiculo> listaVeiculo() {
        List<Veiculo> lista = new ArrayList<>();
        try {
            FindIterable<Document> docs = veiculoCollection.find();
            for (Document doc : docs) {
                Veiculo veiculo = new Veiculo();
                veiculo.setPlaca(doc.getString("placa"));
                veiculo.setMarca(doc.getString("marca"));
                veiculo.setModelo(doc.getString("modelo"));
                veiculo.setCor(doc.getString("cor"));
                veiculo.setCpfCliente(doc.getString("cpfCliente")); // <- aqui

                lista.add(veiculo);
            }
        } catch (Exception e) {}
        return lista;
    }

    public void removerVeiculoPorPlaca(String placa) {
        try {
            Document filtro = new Document("placa", placa);
            veiculoCollection.deleteOne(filtro);
            JOptionPane.showMessageDialog(null, "VEÍCULO REMOVIDO");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover veículo: " + e.getMessage());
        }
    }

    public void atualizarVeiculo(String placaOriginal, Veiculo veiculo) {
    try {
        Document filtro = new Document("placa", placaOriginal);

        Document atualizacao = new Document("$set", new Document()
            .append("placa", veiculo.getPlaca())  
            .append("marca", veiculo.getMarca())
            .append("modelo", veiculo.getModelo())
            .append("cor", veiculo.getCor())
            .append("cpfCliente", veiculo.getCpfCliente())
        );

        veiculoCollection.updateOne(filtro, atualizacao);
    } catch (Exception e) {
        e.printStackTrace();
    }
}


public Veiculo buscarVeiculoPorPlaca(String placa) {
    try {
        Document filtro = new Document("placa", placa);
        Document doc = veiculoCollection.find(filtro).first();

        if (doc != null) {
            Veiculo veiculo = new Veiculo();
            veiculo.setPlaca(doc.getString("placa"));
            veiculo.setMarca(doc.getString("marca"));
            veiculo.setModelo(doc.getString("modelo"));
            veiculo.setCor(doc.getString("cor"));
            veiculo.setCpfCliente(doc.getString("cpfCliente"));
            return veiculo;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

    
}

package br.com.DAO;

import br.com.DTO.ClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void editarCliente(ClienteDTO objDTO) {
        String sql = "update tb_clientes set nome = ?, endereco = ?, telefone = ?, email = ?, cpf_cnpj = ? where id_cliente = ?";
        Connection conexao = null;
        PreparedStatement pst = null;

        try {
            conexao = ConexaoDAO.conector();
            pst = conexao.prepareStatement(sql);

            pst.setInt(6, objDTO.getId_cliente());
            pst.setString(1, objDTO.getNomeCliente());
            pst.setString(2, objDTO.getEnderecoCliente());
            pst.setString(3, objDTO.getTelefoneCliente());
            pst.setString(4, objDTO.getEmailCliente());
            pst.setString(5, objDTO.getCpf_cnpj());

            int add = pst.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Usuário editado com sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método Editar: " + e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e);
            }
        }

    }

    public void apagarCliente(ClienteDTO objDTO) {
        String sql = "delete from tb_clientes where id_cliente = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objDTO.getId_cliente());

            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                JOptionPane.showMessageDialog(null, "Usuario excluido com sucesso!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método apagar " + e);
        }
    }

    public boolean inserirCliente(ClienteDTO objDTO) {
        String sql = "insert into tb_clientes(id_cliente, nome, endereco, telefone, email, cpf_cnpj) values(?, ?, ?, ?, ?, ?)";
        conexao = new ConexaoDAO().conector();

        try {

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objDTO.getId_cliente());
            pst.setString(2, objDTO.getNomeCliente());
            pst.setString(3, objDTO.getEnderecoCliente());
            pst.setString(4, objDTO.getTelefoneCliente());
            pst.setString(5, objDTO.getEmailCliente());
            pst.setString(6, objDTO.getCpf_cnpj());

            pst.execute();
            pst.close();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inserir usuário " + e);
            return false;
        }
    }

}

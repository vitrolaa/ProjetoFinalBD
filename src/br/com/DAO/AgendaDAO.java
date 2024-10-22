package br.com.DAO;

import br.com.DTO.AgendaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AgendaDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public boolean inserirAgenda(AgendaDTO objDTO) {
        String sql = "insert into tb_agenda(id_agenda, descricao, dataa, email, nome) values(?, ?, ?, ?, ?)";
        conexao = new ConexaoDAO().conector();

        try {

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objDTO.getId_agenda());
            pst.setString(2, objDTO.getDescricao());
            pst.setString(3, objDTO.getData());
            pst.setString(4, objDTO.getEmail());
            pst.setString(5, objDTO.getNome());
           

            pst.execute();
            pst.close();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inserir usuário " + e);
            return false;
        }
    }

    

    public void apagarEvento(AgendaDTO objDTO) {
        String sql = "delete from tb_agenda where dataa = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objDTO.getData());

            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                JOptionPane.showMessageDialog(null, "Evento excluido com sucesso!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método excluir " + e);
        }
    }
    
}



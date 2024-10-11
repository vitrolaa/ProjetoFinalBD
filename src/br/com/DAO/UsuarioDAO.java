package br.com.DAO;

import br.com.DTO.UsuarioDTO;
import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void editar(UsuarioDTO objDTO) {
        String sql = "update tbUsuario set login = ?, email = ?, nome = ?, senha = ? where id_usuario = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objDTO.getIdUsuario());
            pst.setString(2, objDTO.getLoginUsuario());
            pst.setString(3, objDTO.getEmailUsuario());
            pst.setString(4, objDTO.getNomeUsuario());
            pst.setString(5, objDTO.getSenhaUsuario());

            int add = pst.executeUpdate();

            if (add > 0) {
                conexao.close();
                JOptionPane.showMessageDialog(null, "Usuario editado com sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método Editar " + e);
        }
    }

    public void apagar(UsuarioDTO objDTO) {
        String sql = "delete from tbUsuario where login = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objDTO.getLoginUsuario());

            int add = pst.executeUpdate();

            if (add > 0) {
                conexao.close();
                JOptionPane.showMessageDialog(null, "Usuario excluido com sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método apagar " + e);
        }
    }

    public boolean inserir(UsuarioDTO objDTO) {
        String sql = "insert into tbUsuario(login, email, nome, senha) values(?, ?, ?, ?)";
        conexao = new ConexaoDAO().conector();

        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, objDTO.getLoginUsuario());
            pst.setString(2, objDTO.getEmailUsuario());
            pst.setString(3, objDTO.getNomeUsuario());
            pst.setString(4, objDTO.getSenhaUsuario());
            
            pst.execute();
            pst.close();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Inserir usuário " + e);
            return false;
        }
    }
}

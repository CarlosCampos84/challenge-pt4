package br.com.fiap.dao;

import br.com.fiap.to.UsuarioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO extends Repository {
    public ArrayList<UsuarioTO> findAll() {
        ArrayList<UsuarioTO> usuarios = new ArrayList<UsuarioTO>();
        String sql = "select * from t_sf_usuario order by id_usuario";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    UsuarioTO usuario = new UsuarioTO();
                    usuario.setIdCliente(rs.getLong("id_usuario"));
                    usuario.setNome(rs.getString("nm_usuario"));
                    usuario.setUsuario(rs.getString("nm_cadastro"));
                    usuario.setEmail(rs.getString("nm_email"));
                    usuario.setSenha(rs.getString("nm_senha"));
                    usuario.setPlaca(rs.getString("nr_placa"));
                    usuarios.add(usuario);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return usuarios;
    }

    public UsuarioTO findByCodigo(Long codigo) {
        UsuarioTO usuario = new UsuarioTO();
        String sql = "select * from t_sf_usuario where id_usuario = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setNome(rs.getString("nm_usuario"));
                usuario.setUsuario(rs.getString("nm_cadastro"));
                usuario.setEmail(rs.getString("nm_email"));
                usuario.setSenha(rs.getString("nm_senha"));
                usuario.setPlaca(rs.getString("nr_placa"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return usuario;
    }

    public UsuarioTO save(UsuarioTO usuario) {
        String sql = "insert into t_sf_usuario (nm_usuario, nm_cadastro, nm_email,  nm_senha, nr_placa) values(?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getSenha());
            ps.setString(5, usuario.getPlaca());
            if (ps.executeUpdate() > 0) {
                return usuario;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long idCliente) {
        String sql = "delete from t_sf_usuario where id_usuario = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idCliente);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public UsuarioTO update(UsuarioTO usuario){
        String sql = "update t_sf_usuario set nm_usuario=?, nm_email=?, nm_cadastro=?, nm_senha=?, nr_placa=? where id_usuario=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getSenha());
            ps.setString(5, usuario.getPlaca());
            ps.setLong(6, usuario.getIdCliente());
            if (ps.executeUpdate() > 0){
                return usuario;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
        finally {
            closeConnection();
        }
        return null;
    }

}

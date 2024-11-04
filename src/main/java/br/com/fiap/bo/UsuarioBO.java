package br.com.fiap.bo;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.to.UsuarioTO;

import java.util.ArrayList;

public class UsuarioBO {
    private UsuarioDAO usuarioDAO;

    public ArrayList<UsuarioTO> findAll() {
        usuarioDAO = new UsuarioDAO();
        // aqui se implementa a regra de negócios
        return usuarioDAO.findAll();
    }

    public UsuarioTO findByCodigo(Long codigo) {
        usuarioDAO = new UsuarioDAO();
        // aqui se implementa a regra de negócios
        return usuarioDAO.findByCodigo(codigo);
    }

    public UsuarioTO save(UsuarioTO remedio){
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.save(remedio);
    }

    public boolean delete(Long idCliente) {
        usuarioDAO = new UsuarioDAO();
        //aqui se implementa a regra de negócios
        return usuarioDAO.delete(idCliente);
    }

    public UsuarioTO update(UsuarioTO remedio){
        usuarioDAO = new UsuarioDAO();
        //aqui se implementa a regra de negócios
        return usuarioDAO.update(remedio);
    }

}

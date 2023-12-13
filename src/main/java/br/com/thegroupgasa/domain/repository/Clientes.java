package br.com.thegroupgasa.domain.repository;

import br.com.thegroupgasa.domain.entity.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class Clientes {

    private static String INSERT = "insert into cliente (nome) values (?)";
    private static String SELECT_ALL = "select * from cliente";
    private static String UPDATE = "update cliente set nome = ? where clienteId = ?";
    private static String DELETE = "delete from cliente where clienteId = ?";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente salvar(Cliente cliente) {
       jdbcTemplate.update(INSERT, new Object[] { cliente.getNome() });
        return cliente;
    }

    public Cliente atualizar(Cliente cliente) {
        jdbcTemplate.update(UPDATE, new Object[] { 
            cliente.getNome(), cliente.getClienteId() });
        return cliente;
    }

    public void deletar(Integer id) {
        jdbcTemplate.update(DELETE, new Object[] { id });
    }

    public void deletar(Cliente cliente) {
        deletar(cliente.getClienteId());
    }

    public List<Cliente> obterPorNome(String nome) {
        return jdbcTemplate.query(
            SELECT_ALL.concat(" where nome like ?"), 
            new Object[] { "%" + nome + "%" }, obterClienteMapper());
    }

    public List<Cliente> obterTodos() {
        return jdbcTemplate.query(SELECT_ALL, obterClienteMapper());
    }

    private static RowMapper<Cliente> obterClienteMapper() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer clienteId = resultSet.getInt("clienteId");
                String nome = resultSet.getString("nome");
                return new Cliente(clienteId, nome);
            }
        };
    }
}

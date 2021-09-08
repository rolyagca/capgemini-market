package com.capgemini.market.persistence.crud;

import com.capgemini.market.persistence.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteCrudRepository extends CrudRepository<Cliente,String> {

    @Query(value = "UPDATE clientes SET nombre = ?1, apellidos = ?2 WHERE id = ?3 RETURNING *; ", nativeQuery = true)
    Optional<Cliente> actualizarNombreCliente(String nombre, String lastName, String id);

    Optional<List<Cliente>> findByDireccionOrderByNombreAsc(String direccion); //QueryMethods

    //Optional<List<Cliente>> findByComprasOrderByFechaAsc(String id);

    Optional<Cliente> findByCorreoElectronico(String correoElectronico);

    Optional<List<Cliente>> findByNombreAndApellidos(String nombre, String apellidos);
}

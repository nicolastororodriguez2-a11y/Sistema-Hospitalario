
package com.hospital.sys.repository;

import com.hospital.sys.model.Usuarios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuariosRepository extends JpaRepository<Usuarios, Integer>{
    List<Usuarios> findByUsuario(String usuario);
}

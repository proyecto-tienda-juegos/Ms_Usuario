package com.tienda.usuario.repository;

import com.tienda.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

// Al extender JpaRepository ya obtenemos gratis los métodos
// save(), findById(), findAll(), deleteById(), etc.
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

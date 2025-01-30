package backend.repository;

import backend.entity.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuariosRepository extends JpaRepository<Usuarios, Long> {
}

package backend.repository;

import backend.entity.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface usuariosRepository extends JpaRepository<Usuarios, Long> {



}

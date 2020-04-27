package kg.itacademy.filesystem.repository;

import kg.itacademy.filesystem.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileEntityRepository extends JpaRepository<FileEntity,Long> {
    FileEntity findFirstByName(String name);
}

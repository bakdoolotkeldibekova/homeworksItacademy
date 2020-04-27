package kg.itacademy.filesystem.entity;

import kg.itacademy.filesystem.entity.base.TimedEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "file")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class FileEntity extends TimedEntity {

    @Column(nullable = false)
    private String originalName;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String extension;

    @Column(nullable = false)
    private Long size;

    @Column(nullable = false)
    private String path;
}
package org.example.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "planet")
@Entity
@Data
public class Planet {
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
}

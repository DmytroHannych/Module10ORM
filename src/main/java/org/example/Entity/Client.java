package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Table(name = "client")
@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
}

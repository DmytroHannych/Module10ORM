package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Table(name = "ticket")
@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "created_at")
    private Date created_at;
    @Column(name = "client_id")
    private int client_id;
    @Column(name = "from_planet_id")
    private String from_planet_id;
    @Column(name = "to_planet_id")
    private String to_planet_id;
}

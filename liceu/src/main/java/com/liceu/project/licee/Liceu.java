package com.liceu.project.licee;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Licee")
public class Liceu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nume", unique = true)
    private String nume;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "is_deleted")
    private Integer isDeleted;
}
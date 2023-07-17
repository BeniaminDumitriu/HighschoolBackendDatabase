package com.liceu.project.elevi;

import com.liceu.project.licee.Liceu;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Elevi")
public class Elev {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "elevi_seq")
    @SequenceGenerator(name = "elevi_seq", sequenceName = "elevi_SEQ", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @Column(name = "telefon")
    private String telefon;

    @ManyToOne
    @JoinColumn(name = "liceu_id")
    private Liceu liceu;
}
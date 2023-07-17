package com.liceu.project.camine;

import com.liceu.project.licee.Liceu;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Camine")
public class Camin{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "camine_seq")
    @SequenceGenerator(name = "camine_seq", sequenceName = "camine_SEQ", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "numar", nullable = false)
    private Integer numar;

    @Column(name = "adresa", nullable = false)
    private String adresa;

    @Column(name = "numar_total_camere", nullable = false)
    private Integer numarTotalCamere=1;

    @ManyToOne
    @JoinColumn(name = "liceu_id", nullable = false)
    private Liceu liceu;

}

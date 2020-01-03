package io.github.rirfanuddin.kode.wilayah.scraping.domain;

import lombok.*;

import javax.persistence.*;

/**
 * @author rirfanuddin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "kabupaten")
public class Kabupaten {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "kode")
    private String kode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "provinsi_id")
    private Provinsi provinsi;

    @Column(name = "nama")
    private String nama;

}

package io.github.rirfanuddin.kode.wilayah.scraping.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author rirfanuddin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "kecamatan")
public class Kecamatan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "kode")
    private String kode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kabupaten_id")
    private Kabupaten kabupaten;

    @Column(name = "nama")
    private String nama;

}

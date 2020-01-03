package io.github.rirfanuddin.kode.wilayah.scraping.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
@Entity(name = "provinsi")
public class Provinsi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "kode")
    private String kode;

    @Column(name = "nama")
    private String nama;

}

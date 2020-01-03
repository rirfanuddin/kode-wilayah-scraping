package io.github.rirfanuddin.kode.wilayah.scraping.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.rirfanuddin.kode.wilayah.scraping.domain.Kecamatan;
import io.github.rirfanuddin.kode.wilayah.scraping.model.deserializer.KecamatanDeserializer;

import java.util.ArrayList;

/**
 * @author rirfanuddin
 */
@JsonDeserialize(using = KecamatanDeserializer.class)
public class KecamatanList extends ArrayList<Kecamatan> {
}

package io.github.rirfanuddin.kode.wilayah.scraping.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.rirfanuddin.kode.wilayah.scraping.domain.Provinsi;
import io.github.rirfanuddin.kode.wilayah.scraping.model.deserializer.ProvinsiDeserializer;

import java.util.ArrayList;

/**
 * @author rirfanuddin
 */
@JsonDeserialize(using = ProvinsiDeserializer.class)
public class ProvinsiList extends ArrayList<Provinsi> {
}

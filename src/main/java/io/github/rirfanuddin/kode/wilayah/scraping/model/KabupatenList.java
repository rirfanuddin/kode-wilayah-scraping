package io.github.rirfanuddin.kode.wilayah.scraping.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.rirfanuddin.kode.wilayah.scraping.domain.Kabupaten;
import io.github.rirfanuddin.kode.wilayah.scraping.model.deserializer.KabupatenDeserializer;

import java.util.ArrayList;

/**
 * @author rirfanuddin
 */
@JsonDeserialize(using = KabupatenDeserializer.class)
public class KabupatenList extends ArrayList<Kabupaten> {
}

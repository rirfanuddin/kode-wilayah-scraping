package io.github.rirfanuddin.kode.wilayah.scraping.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.rirfanuddin.kode.wilayah.scraping.domain.Kelurahan;
import io.github.rirfanuddin.kode.wilayah.scraping.model.deserializer.KelurahanDeserializer;

import java.util.ArrayList;

/**
 * @author rirfanuddin
 */
@JsonDeserialize(using = KelurahanDeserializer.class)
public class KelurahanList extends ArrayList<Kelurahan> {
}

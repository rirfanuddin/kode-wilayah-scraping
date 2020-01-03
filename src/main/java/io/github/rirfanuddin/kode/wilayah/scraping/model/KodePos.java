package io.github.rirfanuddin.kode.wilayah.scraping.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.rirfanuddin.kode.wilayah.scraping.model.deserializer.KelurahanDeserializer;
import io.github.rirfanuddin.kode.wilayah.scraping.model.deserializer.KodePosDeserializer;
import lombok.Data;

/**
 * @author rirfanuddin
 */
@JsonDeserialize(using = KodePosDeserializer.class)
public class KodePos {

    private String kodePos;

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }
}

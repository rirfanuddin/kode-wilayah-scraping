package io.github.rirfanuddin.kode.wilayah.scraping.model.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import io.github.rirfanuddin.kode.wilayah.scraping.domain.Kabupaten;
import io.github.rirfanuddin.kode.wilayah.scraping.domain.Provinsi;
import io.github.rirfanuddin.kode.wilayah.scraping.model.KabupatenList;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author rirfanuddin
 */
@Slf4j
public class KabupatenDeserializer extends StdDeserializer<KabupatenList> {

    public KabupatenDeserializer() {
        this(null);
    }

    private KabupatenDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public KabupatenList deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        KabupatenList kabupatenList = new KabupatenList();
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        root.elements().forEachRemaining(k -> {
            Kabupaten kabupaten = new Kabupaten();
            String kode = k.get("kode_bps").asText();
            kode = kode.substring(2, 4);
            kabupaten.setKode(kode);
            kabupaten.setNama(k.get("nama_bps").asText());
            kabupatenList.add(kabupaten);
        });
        return kabupatenList;
    }
}

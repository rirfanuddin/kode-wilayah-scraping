package io.github.rirfanuddin.kode.wilayah.scraping.model.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import io.github.rirfanuddin.kode.wilayah.scraping.domain.Kecamatan;
import io.github.rirfanuddin.kode.wilayah.scraping.model.KecamatanList;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author rirfanuddin
 */
@Slf4j
public class KecamatanDeserializer extends StdDeserializer<KecamatanList> {

    public KecamatanDeserializer() {
        this(null);
    }

    private KecamatanDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public KecamatanList deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        KecamatanList kecamatanList = new KecamatanList();
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        root.elements().forEachRemaining(k -> {
            Kecamatan kecamatan = new Kecamatan();
            String kode = k.get("kode_bps").asText();
            kode = kode.substring(4, 7);
            kecamatan.setKode(kode);
            kecamatan.setNama(k.get("nama_bps").asText());
            kecamatanList.add(kecamatan);
        });
        return kecamatanList;
    }
}

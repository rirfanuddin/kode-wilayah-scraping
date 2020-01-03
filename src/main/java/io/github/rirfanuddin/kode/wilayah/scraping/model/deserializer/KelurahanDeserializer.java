package io.github.rirfanuddin.kode.wilayah.scraping.model.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import io.github.rirfanuddin.kode.wilayah.scraping.domain.Kelurahan;
import io.github.rirfanuddin.kode.wilayah.scraping.model.KelurahanList;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author rirfanuddin
 */
@Slf4j
public class KelurahanDeserializer extends StdDeserializer<KelurahanList> {

    public KelurahanDeserializer() {
        this(null);
    }

    private KelurahanDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public KelurahanList deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        KelurahanList kelurahanList = new KelurahanList();
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        root.elements().forEachRemaining(k -> {
            Kelurahan kelurahan = new Kelurahan();
            String kode = k.get("kode_bps").asText();
            kode = kode.substring(7, 10);
            kelurahan.setKode(kode);
            kelurahan.setNama(k.get("nama_bps").asText());
            kelurahanList.add(kelurahan);
        });
        return kelurahanList;
    }
}

package io.github.rirfanuddin.kode.wilayah.scraping.model.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import io.github.rirfanuddin.kode.wilayah.scraping.domain.Provinsi;
import io.github.rirfanuddin.kode.wilayah.scraping.model.ProvinsiList;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author rirfanuddin
 */
@Slf4j
public class ProvinsiDeserializer extends StdDeserializer<ProvinsiList> {

    public ProvinsiDeserializer() {
        this(null);
    }

    private ProvinsiDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public ProvinsiList deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ProvinsiList provinsiList = new ProvinsiList();

        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        root.elements().forEachRemaining(p -> {
            Provinsi provinsi = new Provinsi();
            provinsi.setKode(p.get("kode").asText());
            provinsi.setNama(p.get("nama").asText());

            provinsiList.add(provinsi);
        });

        log.debug("========== isi provinsi list ======= {}", provinsiList);

        return provinsiList;
    }
}

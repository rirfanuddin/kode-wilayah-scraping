package io.github.rirfanuddin.kode.wilayah.scraping.model.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import io.github.rirfanuddin.kode.wilayah.scraping.model.KodePos;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @author rirfanuddin
 */

public class KodePosDeserializer extends StdDeserializer<KodePos> {

    public KodePosDeserializer() {
        this(null);
    }

    protected KodePosDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public KodePos deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        KodePos kodePos = new KodePos();
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        JsonNode content = jsonNode.get(0);

        if(null == content) {
            kodePos.setKodePos("");
        } else {
            kodePos.setKodePos(content.get("kode_pos").asText());
        }

        return kodePos;

    }


}

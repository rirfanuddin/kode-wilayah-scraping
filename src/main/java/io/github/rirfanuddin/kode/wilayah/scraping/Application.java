package io.github.rirfanuddin.kode.wilayah.scraping;

import io.github.rirfanuddin.kode.wilayah.scraping.domain.Kabupaten;
import io.github.rirfanuddin.kode.wilayah.scraping.service.WilayahService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author rirfanuddin
 */
@SpringBootApplication
@Slf4j
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        WilayahService wilayahService = context.getBean(WilayahService.class);
//        wilayahService.saveProvinceToDb();
//        wilayahService.saveKabupatenToDb();
//        wilayahService.saveKecamatanToDb();
        wilayahService.saveKelurahanToDb();

//        Kabupaten kabupaten = wilayahService.findById();
//        log.info("=== kabupaten === {}", kabupaten);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

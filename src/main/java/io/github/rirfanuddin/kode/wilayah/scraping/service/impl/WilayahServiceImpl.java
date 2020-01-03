package io.github.rirfanuddin.kode.wilayah.scraping.service.impl;

import io.github.rirfanuddin.kode.wilayah.scraping.domain.Kabupaten;
import io.github.rirfanuddin.kode.wilayah.scraping.domain.Kecamatan;
import io.github.rirfanuddin.kode.wilayah.scraping.domain.Kelurahan;
import io.github.rirfanuddin.kode.wilayah.scraping.domain.Provinsi;
import io.github.rirfanuddin.kode.wilayah.scraping.model.*;
import io.github.rirfanuddin.kode.wilayah.scraping.repository.KabupatenRepository;
import io.github.rirfanuddin.kode.wilayah.scraping.repository.KecamatanRepository;
import io.github.rirfanuddin.kode.wilayah.scraping.repository.KelurahanRepository;
import io.github.rirfanuddin.kode.wilayah.scraping.repository.ProvinsiRepository;
import io.github.rirfanuddin.kode.wilayah.scraping.service.WilayahService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rirfanuddin
 */
@Service
@Slf4j
public class WilayahServiceImpl implements WilayahService {

    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Autowired
    private KabupatenRepository kabupatenRepository;

    @Autowired
    private KecamatanRepository kecamatanRepository;

    @Autowired
    private KelurahanRepository kelurahanRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${io.github.rirfanuddin.scraping.kodwil.url}")
    private String baseUrl;

    @Value("${io.github.rirfanuddin.scraping.kodwil.sub-url}")
    private String subUrl;

    @Value("${io.github.rirfanuddin.scraping.kodwil.kode-pos-url}")
    private String kodePosUrl;

    @Override
    public void saveProvinceToDb() {
        ProvinsiList provinsiList = restTemplate.getForObject(baseUrl, ProvinsiList.class);
        provinsiList.forEach(provinsi -> {
            provinsiRepository.save(provinsi);
            log.info("*** provinsi id ke-{} ***", provinsi.getId());
        });
        log.info("========== PROVINSI SAVED!! ==========");
    }

    @Override
    public void saveKabupatenToDb() {
        List<Provinsi> provinsiList = provinsiRepository.findAll();
        provinsiList.forEach(provinsi -> {
            String url = subUrl + "/kabupaten/parent/" + provinsi.getKode() + "/periode/20181";
            KabupatenList kabupatenList = restTemplate.getForObject(url, KabupatenList.class);
            kabupatenList.forEach(kabupaten -> {
                kabupaten.setProvinsi(Provinsi.builder().id(provinsi.getId()).build());
                kabupatenRepository.save(kabupaten);
                log.info("*** kabupaten id ke-{} ***", kabupaten.getId());
            });
        });

        log.info("========== KABUPATEN SAVED!! ==========");
    }

    @Override
    public void saveKecamatanToDb() {
        List<Kabupaten> kabupatenList = kabupatenRepository.findAll();
        kabupatenList.forEach(kabupaten -> {
            String url = subUrl + "/kecamatan/parent/" + kabupaten.getProvinsi().getKode() + kabupaten.getKode() + "/periode/20181";
            KecamatanList kecamatanList = restTemplate.getForObject(url, KecamatanList.class);
            kecamatanList.forEach(kecamatan -> {
                kecamatan.setKabupaten(Kabupaten.builder().id(kabupaten.getId()).build());
                kecamatanRepository.save(kecamatan);
                log.info("*** kecamatan id ke-{} ***", kecamatan.getId());
            });
        });

        log.info("========== KECAMATAN SAVED!! ==========");
    }

    @Override
    public void saveKelurahanToDb() {
        List<Kecamatan> kecamatanList = kecamatanRepository.findAll();
        List<Kecamatan> kecamatanList1 = new ArrayList<>();
        kecamatanList.forEach(kecamatan -> {
            log.info(">>>>> kecamatan id ke-{} <<<<<", kecamatan.getId());
            String url = subUrl + "/desa/parent/" + kecamatan.getKabupaten().getProvinsi().getKode() + kecamatan.getKabupaten().getKode() + kecamatan.getKode() + "0/periode/20181";
            KelurahanList kelurahanList = restTemplate.getForObject(url, KelurahanList.class);
            kelurahanList.forEach(kelurahan -> {
                kelurahan.setKecamatan(Kecamatan.builder().id(kecamatan.getId()).build());
                kelurahanRepository.save(kelurahan);
                Kelurahan objKelurahan = kelurahanRepository.findById(kelurahan.getId()).get();

                String urlKodePos = kodePosUrl + objKelurahan.getKecamatan().getKabupaten().getProvinsi().getKode()
                        + objKelurahan.getKecamatan().getKabupaten().getKode()
                        + objKelurahan.getKecamatan().getKode()
                        + objKelurahan.getKode();
                KodePos kodePos = restTemplate.getForObject(urlKodePos, KodePos.class);

                kelurahan.setKodePos(kodePos.getKodePos());
                kelurahanRepository.save(kelurahan);

                log.info("*** kelurahan id ke-{} ***", kelurahan.getId());
            });
        });

        log.info("========== KELURAHAN SAVED!! ==========");
    }

    @Override
    public Kabupaten findById() {
        return kabupatenRepository.findById(100).get();
    }
}

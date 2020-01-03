package io.github.rirfanuddin.kode.wilayah.scraping.service;

import io.github.rirfanuddin.kode.wilayah.scraping.domain.Kabupaten;

/**
 * @author rirfanuddin
 */
public interface WilayahService {

    void saveProvinceToDb();

    void saveKabupatenToDb();

    void saveKecamatanToDb();

    void saveKelurahanToDb();

    Kabupaten findById();

}

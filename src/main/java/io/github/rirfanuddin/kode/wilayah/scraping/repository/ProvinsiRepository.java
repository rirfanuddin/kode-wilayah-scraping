package io.github.rirfanuddin.kode.wilayah.scraping.repository;

import io.github.rirfanuddin.kode.wilayah.scraping.domain.Provinsi;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rirfanuddin
 */
@Repository
public interface ProvinsiRepository extends PagingAndSortingRepository<Provinsi, Integer> {
    List<Provinsi> findAll();
}

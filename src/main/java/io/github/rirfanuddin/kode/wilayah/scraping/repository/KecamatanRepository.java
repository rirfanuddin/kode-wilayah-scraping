package io.github.rirfanuddin.kode.wilayah.scraping.repository;

import io.github.rirfanuddin.kode.wilayah.scraping.domain.Kecamatan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rirfanuddin
 */
@Repository
public interface KecamatanRepository extends PagingAndSortingRepository<Kecamatan, Integer> {
    List<Kecamatan> findAll();
}

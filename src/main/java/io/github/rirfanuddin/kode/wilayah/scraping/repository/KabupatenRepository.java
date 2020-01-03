package io.github.rirfanuddin.kode.wilayah.scraping.repository;

import io.github.rirfanuddin.kode.wilayah.scraping.domain.Kabupaten;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rirfanuddin
 */
@Repository
public interface KabupatenRepository extends PagingAndSortingRepository<Kabupaten, Integer> {
    List<Kabupaten> findAll();
}

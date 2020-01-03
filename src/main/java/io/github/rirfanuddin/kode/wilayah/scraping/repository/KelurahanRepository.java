package io.github.rirfanuddin.kode.wilayah.scraping.repository;

import io.github.rirfanuddin.kode.wilayah.scraping.domain.Kelurahan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rirfanuddin
 */
@Repository
public interface KelurahanRepository extends PagingAndSortingRepository<Kelurahan, Integer> {
}

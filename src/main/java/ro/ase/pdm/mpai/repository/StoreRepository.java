package ro.ase.pdm.mpai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.ase.pdm.mpai.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}

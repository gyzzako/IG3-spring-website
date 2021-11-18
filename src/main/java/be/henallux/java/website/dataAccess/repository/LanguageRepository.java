package be.henallux.java.website.dataAccess.repository;

import be.henallux.java.website.dataAccess.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Integer> {
}

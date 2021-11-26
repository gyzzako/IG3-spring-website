package be.henallux.java.website.dataAccess.repository;

import be.henallux.java.website.dataAccess.entity.TranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationRepository extends JpaRepository<TranslationEntity, Integer> {
}

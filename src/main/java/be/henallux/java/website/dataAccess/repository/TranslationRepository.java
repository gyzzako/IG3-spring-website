package be.henallux.java.website.dataAccess.repository;

import be.henallux.java.website.dataAccess.entity.TranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface TranslationRepository extends JpaRepository<TranslationEntity, Integer> {
    @Query("SELECT translation from TranslationEntity translation WHERE translation.language_fk.language_id = ?1")
    ArrayList<TranslationEntity> findByLanguage_fk(Integer languageFK);
}

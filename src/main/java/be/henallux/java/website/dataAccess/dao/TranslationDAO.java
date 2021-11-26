package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.dataAccess.entity.TranslationEntity;
import be.henallux.java.website.dataAccess.repository.TranslationRepository;
import be.henallux.java.website.dataAccess.utils.ProviderConverter;
import be.henallux.java.website.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TranslationDAO implements TranslationDataAccess{
    private TranslationRepository translationRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public TranslationDAO(TranslationRepository translationRepository, ProviderConverter providerConverter){
        this.translationRepository = translationRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<Translation> getAllTranslations() {
        List<TranslationEntity> translationEntities = translationRepository.findAll();
        ArrayList<Translation> translations = new ArrayList<>();
        for (TranslationEntity entity : translationEntities) {
            Translation translation = providerConverter.translationEntityToTranslationModel(entity);
            translations.add(translation);
        }
        return translations;
    }
}

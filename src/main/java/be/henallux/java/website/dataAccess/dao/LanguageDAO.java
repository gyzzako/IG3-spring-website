package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.dataAccess.entity.LanguageEntity;
import be.henallux.java.website.dataAccess.repository.LanguageRepository;
import be.henallux.java.website.dataAccess.utils.ProviderConverter;
import be.henallux.java.website.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LanguageDAO implements LanguageDataAccess{

    private LanguageRepository languageRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public LanguageDAO(LanguageRepository languageRepository, ProviderConverter providerConverter){
        this.languageRepository = languageRepository;
        this.providerConverter = providerConverter;
    }

    public Language getLanguage(Integer id){
        Optional<LanguageEntity> languageEntity = languageRepository.findById(id);
        if(languageEntity.isPresent()){
            return providerConverter.languageEntityToLanguageModel(languageEntity.get());
        }else{
            return null;
        }
    }
}

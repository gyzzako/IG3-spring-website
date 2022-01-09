package be.henallux.java.website.dataAccess.dao;

import be.henallux.java.website.dataAccess.entity.CategoryEntity;
import be.henallux.java.website.dataAccess.entity.LanguageEntity;
import be.henallux.java.website.dataAccess.entity.TranslationEntity;
import be.henallux.java.website.dataAccess.repository.TranslationRepository;
import be.henallux.java.website.dataAccess.utils.ProviderConverter;
import be.henallux.java.website.model.Language;
import be.henallux.java.website.model.Translation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CategoriesTranslationTest {

    private TranslationDAO translationDAO;

    @Mock
    private TranslationRepository translationRepository;
    @Mock
    private ProviderConverter providerConverter;

    /*
    @Before en faisant ceci, on a des erreurs comme quoi translationDAO est null.
    public void setUp() throws Exception{
        translationDAO = new TranslationDAO(translationRepository,providerConverter);
    }*/

    public ArrayList<TranslationEntity> mockedTranslationEntities(){
        ArrayList<TranslationEntity> mockedEntities = new ArrayList<>();
        TranslationEntity translationEntityFr = new TranslationEntity();
        translationEntityFr.setTranslationId(1);
        translationEntityFr.setCategory(new CategoryEntity());
        translationEntityFr.getCategory().setCategoryId(1);
        translationEntityFr.setLabel("Guitare");
        translationEntityFr.setLanguage(new LanguageEntity());
        translationEntityFr.getLanguage().setLanguageId(1);
        mockedEntities.add(translationEntityFr);

        TranslationEntity translationEntityEn = new TranslationEntity();
        translationEntityEn.setTranslationId(2);
        translationEntityEn.setCategory(new CategoryEntity());
        translationEntityEn.getCategory().setCategoryId(2);
        translationEntityEn.setLabel("Guitar");
        translationEntityEn.setLanguage(new LanguageEntity());
        translationEntityFr.getLanguage().setLanguageId(2);
        mockedEntities.add(translationEntityEn);
        return mockedEntities;
    }


    public ArrayList<TranslationEntity> mockedCategoriesTranslationFrench(){
        ArrayList<TranslationEntity> mockedCategories = new ArrayList<>();
        TranslationEntity translationCategory1 = new TranslationEntity();
        translationCategory1.setTranslationId(1);
        translationCategory1.setCategory(new CategoryEntity());
        translationCategory1.getCategory().setCategoryId(1);
        translationCategory1.setLabel("Guitare");
        translationCategory1.setLanguage(new LanguageEntity());
        translationCategory1.getLanguage().setLanguageId(1);
        mockedCategories.add(translationCategory1);

        TranslationEntity translationCategory2 = new TranslationEntity();
        translationCategory2.setTranslationId(2);
        translationCategory2.setCategory(new CategoryEntity());
        translationCategory2.getCategory().setCategoryId(2);
        translationCategory2.setLabel("Piano");
        translationCategory2.setLanguage(new LanguageEntity());
        translationCategory2.getLanguage().setLanguageId(1);
        mockedCategories.add(translationCategory2);

        TranslationEntity translationCategory3 = new TranslationEntity();
        translationCategory3.setTranslationId(3);
        translationCategory3.setCategory(new CategoryEntity());
        translationCategory3.getCategory().setCategoryId(3);
        translationCategory3.setLabel("Violon");
        translationCategory3.setLanguage(new LanguageEntity());
        translationCategory3.getLanguage().setLanguageId(1);
        mockedCategories.add(translationCategory3);

        TranslationEntity translationCategory4 = new TranslationEntity();
        translationCategory4.setTranslationId(4);
        translationCategory4.setCategory(new CategoryEntity());
        translationCategory4.getCategory().setCategoryId(4);
        translationCategory4.setLabel("Batteries");
        translationCategory4.setLanguage(new LanguageEntity());
        translationCategory4.getLanguage().setLanguageId(1);
        mockedCategories.add(translationCategory4);
        return mockedCategories;
    }



    public ArrayList<TranslationEntity> mockedCategoriesTranslationEnglish(){
        ArrayList<TranslationEntity> mockedCategories = new ArrayList<>();
        TranslationEntity translationCategory1 = new TranslationEntity();
        translationCategory1.setTranslationId(1);
        translationCategory1.setCategory(new CategoryEntity());
        translationCategory1.getCategory().setCategoryId(1);
        translationCategory1.setLabel("Guitar");
        translationCategory1.setLanguage(new LanguageEntity());
        translationCategory1.getLanguage().setLanguageId(2);
        mockedCategories.add(translationCategory1);

        TranslationEntity translationCategory2 = new TranslationEntity();
        translationCategory2.setTranslationId(2);
        translationCategory2.setCategory(new CategoryEntity());
        translationCategory2.getCategory().setCategoryId(2);
        translationCategory2.setLabel("Piano");
        translationCategory2.setLanguage(new LanguageEntity());
        translationCategory2.getLanguage().setLanguageId(2);
        mockedCategories.add(translationCategory2);

        TranslationEntity translationCatgory3 = new TranslationEntity();
        translationCatgory3.setTranslationId(3);
        translationCatgory3.setCategory(new CategoryEntity());
        translationCatgory3.getCategory().setCategoryId(3);
        translationCatgory3.setLabel("Violin");
        translationCatgory3.setLanguage(new LanguageEntity());
        translationCatgory3.getLanguage().setLanguageId(2);
        mockedCategories.add(translationCatgory3);

        TranslationEntity translationCategory4 = new TranslationEntity();
        translationCategory4.setTranslationId(4);
        translationCategory4.setCategory(new CategoryEntity());
        translationCategory4.getCategory().setCategoryId(4);
        translationCategory4.setLabel("Drums");
        translationCategory4.setLanguage(new LanguageEntity());
        translationCategory4.getLanguage().setLanguageId(2);
        mockedCategories.add(translationCategory4);
        return mockedCategories;
    }

    @Test
    public void testCategoriesFrench(){
        translationDAO = new TranslationDAO(translationRepository,providerConverter);
        String expectedCategory1 = "Guitare";
        String expectedCategory2 = "Piano";
        String expectedCategory3 ="Violon";
        String expectedCategory4 ="Batteries";

        LanguageEntity categoryFr = new LanguageEntity();
        categoryFr.setLanguageId(1);
        Language languageFrench = new Language();
        languageFrench.setLanguageId(1);

        //when(providerConverter.languageModelToLanguageEntity(languageFrench)).thenReturn(categoryFr);
        when(providerConverter.translationEntityToTranslationModel(any())).thenCallRealMethod();
        when(translationRepository.findByLocale(categoryFr.getLocale())).thenReturn(mockedCategoriesTranslationFrench());

        ArrayList<Translation> translations = translationDAO.getCategoryTranslationByLanguage(languageFrench.getLocale());
        Optional<Translation> translation1 = translations.stream().filter(t -> t.getTranslationId() == 1).findFirst();
        Optional<Translation> translation2 = translations.stream().filter(t -> t.getTranslationId() == 2).findFirst();
        Optional<Translation> translation3 = translations.stream().filter(t->t.getTranslationId() == 3).findFirst();
        Optional<Translation> translation4 = translations.stream().filter(t->t.getTranslationId() == 4).findFirst();
        assertEquals(4,translations.size());
        assertEquals(expectedCategory1,translation1.isPresent()?translation1.get().getLabel() :"");
        assertEquals(expectedCategory2,translation2.isPresent()? translation2.get().getLabel():"");
        assertEquals(expectedCategory3,translation3.isPresent()?translation3.get().getLabel():"");
        assertEquals(expectedCategory4,translation4.isPresent()?translation4.get().getLabel():"");

    }

    @Test
    public void testCategoriesEnglish(){
        translationDAO = new TranslationDAO(translationRepository,providerConverter);

        String expectedCategory1 = "Guitar";
        String expectedCategory2 = "Piano";
        String expectedCategory3 ="Violin";
        String expectedCategory4 ="Drums";
        LanguageEntity categoriesEn = new LanguageEntity();
        categoriesEn.setLanguageId(2);

        Language languageEnglish = new Language();
        languageEnglish.setLanguageId(2);

        //when(providerConverter.languageModelToLanguageEntity(languageEnglish)).thenReturn(categoriesEn);
        when(providerConverter.translationEntityToTranslationModel(any())).thenCallRealMethod();
        when(translationRepository.findByLocale(categoriesEn.getLocale())).thenReturn(mockedCategoriesTranslationEnglish());
        ArrayList<Translation> translations = translationDAO.getCategoryTranslationByLanguage(languageEnglish.getLocale());
        Optional<Translation> translation1 = translations.stream().filter(t -> t.getTranslationId() == 1).findFirst();
        Optional<Translation> translation2 = translations.stream().filter(t -> t.getTranslationId() == 2).findFirst();
        Optional<Translation> translation3 = translations.stream().filter(t->t.getTranslationId() == 3).findFirst();
        Optional<Translation> translation4 = translations.stream().filter(t->t.getTranslationId() == 4).findFirst();
        assertEquals(4,translations.size());
        assertEquals(expectedCategory1,translation1.isPresent()?translation1.get().getLabel() :"");
        assertEquals(expectedCategory2,translation2.isPresent()? translation2.get().getLabel():"");
        assertEquals(expectedCategory3,translation3.isPresent()?translation3.get().getLabel():"");
        assertEquals(expectedCategory4,translation4.isPresent()?translation4.get().getLabel():"");
    }


    @Test
    public void testCategoryDAO(){
        translationDAO = new TranslationDAO(translationRepository,new ProviderConverter());
        String expectedFrTranslation ="Guitare";
        String expectedEnTranslation ="Guitar";

        when(translationRepository.findAll()).thenReturn(mockedTranslationEntities());
        ArrayList<Translation> translations = translationDAO.getAllTranslations();
        Optional<Translation> frenchTranslation = translations.stream().filter(t -> t.getTranslationId() == 1).findFirst();
        Optional<Translation> englishTranslation = translations.stream().filter(t ->t.getTranslationId() == 2).findFirst();

        assertEquals(2,translations.size());
        assertEquals(expectedFrTranslation,frenchTranslation.isPresent() ? frenchTranslation.get().getLabel():"");
        assertEquals(expectedEnTranslation,englishTranslation.isPresent() ? englishTranslation.get().getLabel():"");
    }

}

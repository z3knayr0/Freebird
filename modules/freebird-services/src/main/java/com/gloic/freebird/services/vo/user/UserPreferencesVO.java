package com.gloic.freebird.services.vo.user;

import com.gloic.freebird.commons.enumerations.PreferredLanguage;
import com.gloic.freebird.commons.enumerations.PreferredQuality;
import com.gloic.freebird.persistence.model.UserPreferences;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * UserPreferencesVO contains the user' preferences and the possible values for its choices
 * @author gloic
 */
@Data
public class UserPreferencesVO {

    private Set<PreferredLanguage> languagesMovies;
    private Set<PreferredLanguage> languagesTvShows;
    private Set<PreferredQuality> qualities;

    private List<PreferredLanguage> languagesPossiblesValues;
    private List<PreferredQuality> qualitiesPossiblesValues;

    public UserPreferencesVO(UserPreferences input) {
        languagesMovies = input.getLanguagesMovies();
        languagesTvShows = input.getLanguagesTvShows();
        qualities = input.getQualities();

        languagesPossiblesValues = Arrays.asList(PreferredLanguage.values());
        qualitiesPossiblesValues = Arrays.asList(PreferredQuality.values());
    }
}
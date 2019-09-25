package utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import steps.*;


@Configuration
@ComponentScan("steps")
public class ConfigurationDependencyInjection {

    @Bean
    public BaseEmulatorPageSteps getBaseEmulatorPageSteps() {
        return new BaseEmulatorPageSteps();
    }

    @Bean
    public NotePageSteps getNotePageSteps() {
        return new NotePageSteps();
    }

    @Bean
    public HomePageSteps getHomePageSteps() {
        return new HomePageSteps();
    }

    @Bean
    public NoteTypePopupSteps getNoteTypePopupSteps() {
        return new NoteTypePopupSteps();
    }

    @Bean
    public EditNotePageSteps getEditNotePageSteps() {
        return new EditNotePageSteps();
    }

}

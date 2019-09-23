import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.ColorPopup;
import steps.*;
import utils.ConfigurationDependencyInjection;
import utils.androiddriver.AndroidDriverSingletone;

public class BaseTest {


    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//    protected BaseEmulatorPageSteps baseEmulatorPageSteps; // = context.getBean(BaseEmulatorPageSteps.class);
    protected BaseEmulatorPageSteps baseEmulatorPageSteps = (BaseEmulatorPageSteps)context.getBean("baseEmulatorPageSteps");
    protected HomePageSteps homePageSteps = (HomePageSteps) context.getBean("homePageSteps");
    protected NoteTypePopupSteps noteTypePopupSteps = (NoteTypePopupSteps)context.getBean("noteTypePopupSteps");
    protected NotePageSteps notePageSteps;
    protected TextNotePageSteps textNotePageSteps = (TextNotePageSteps)context.getBean("textNotePageSteps");

    public BaseTest() {
        context = new AnnotationConfigApplicationContext(ConfigurationDependencyInjection.class);
    }
    private AndroidDriverSingletone instance;

    @BeforeTest
    public void createInstance() {
        instance = AndroidDriverSingletone.getSingletoneInstance();
    }

    @AfterTest
    public void closeDriver() {
        instance.closeDriver();
    }

}

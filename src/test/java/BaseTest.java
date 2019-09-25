import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import steps.*;
import utils.ConfigurationDependencyInjection;
import utils.androiddriver.AndroidDriverSingletone;

@ContextConfiguration(classes = ConfigurationDependencyInjection.class)
public class BaseTest extends AbstractTestNGSpringContextTests {

    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Autowired
    protected BaseEmulatorPageSteps baseEmulatorPageSteps;

    @Autowired
    protected HomePageSteps homePageSteps; // = (HomePageSteps) context.getBean("homePageSteps");

    @Autowired
    protected NoteTypePopupSteps noteTypePopupSteps; // = (NoteTypePopupSteps)context.getBean("noteTypePopupSteps");

    @Autowired
    protected NotePageSteps notePageSteps;

    @Autowired
    protected EditNotePageSteps editNotePageSteps;

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

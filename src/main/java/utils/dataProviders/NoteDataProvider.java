package utils.dataProviders;

import business_objects.*;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class NoteDataProvider {

    @DataProvider(name = "CreateNewNote")
    public static Object[] getNote() {
        return new Note[]{
                new TextNote("Salad ingridients", new Body(Arrays.asList("Oil\nRed fish\nCheese\nLatook\nEggs"))),
                new TextNote("Cake", Color.BLUE, new Body(Arrays.asList("Milk\n5 Eggs\nCreamy souse\n2Bananas\n500g Berries"))),
                new CheckListNote("Books to read", new Body(Arrays.asList("Ivanhoe",
                        "Lost by the wind",
                        "Forsyte saga")))
        };
    }

    @DataProvider(name = "CreateTextNote")
    public static Object[] createTextNote() {
        return new Note[]{
                new TextNote("Books to read", new Body(Arrays.asList("Lost by the wind\nForsyte saga\nIvanhoe")))
        };
    }

    @DataProvider(name = "Note_Editing")
    public static Object[] createChecklistNote() {
        return new Note[]{
                    new TextNote("Books to read", new Body(Arrays.asList("Lost by the wind\nForsyte saga\nIvanhoe\n"))),
                    new CheckListNote("Colors", new Body(Arrays.asList("Green")))
        };
    }

}

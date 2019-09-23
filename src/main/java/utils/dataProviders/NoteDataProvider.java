package utils.dataProviders;

import business_objects.Note;
import business_objects.TextNote;
import org.testng.annotations.DataProvider;

public class NoteDataProvider {

    @DataProvider(name = "CreateNewNote")
    public static Object[] getNote() {
        return new Note[]{
                new TextNote("Salad ingridients", "Oil\nRed fish\nCheese\nLatook\nEggs"),
                new TextNote("Cake", "Milk\n5 Eggs\nCreamy souse\n2Bananas\n500g Berries")
        };
    }

}

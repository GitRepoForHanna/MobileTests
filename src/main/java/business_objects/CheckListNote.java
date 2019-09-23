package business_objects;

import java.util.ArrayList;
import java.util.List;

public class CheckListNote extends Note{

    private List<CheckListItem> items = new ArrayList<CheckListItem>();

    public CheckListNote(String name, Color color) {
        super(name, NoteType.CHECKLIST, color);
    }

    public CheckListNote(String name, List<CheckListItem> items) {
        super(name, NoteType.CHECKLIST);
        this.items = items;
    }

    public CheckListNote(String name) {
        super(name, NoteType.CHECKLIST);
    }

    public void addNewItem(CheckListItem item){
        items.add(item);
    }

    public void removeItem(String itemBody){
        CheckListItem item = items.stream().filter(i -> i.getBody().trim().equals(itemBody))
                .findFirst()
                .get();
        items.remove(item);
    }

    public List<CheckListItem> getItems() {
        return items;
    }
}

package business_objects;

public class TextNote extends Note {

    public TextNote(String name, Color color, Body body) {
        super(name, NoteType.TEXT_NOTE, color);
        setBody(body);
    }

    public TextNote(String name, Body body) {
        super(name, NoteType.TEXT_NOTE);
        setBody(body);
    }

    public TextNote(String name) {
        super(name, NoteType.TEXT_NOTE);
    }

}

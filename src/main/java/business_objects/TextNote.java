package business_objects;

public class TextNote extends Note {

    private String body;

    public TextNote(String name, Color color, String body) {
        super(name, NoteType.TEXT_NOTE, color);
        this.body = body;
    }

    public TextNote(String name, String body) {
        super(name, NoteType.TEXT_NOTE);
        this.body = body;
    }

    public TextNote(String name) {
        super(name, NoteType.TEXT_NOTE);
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }
}

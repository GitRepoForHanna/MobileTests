package business_objects;

public enum NoteType {
    TEXT_NOTE("Text"),
    CHECKLIST("Checklist");

    private String value;

    NoteType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}

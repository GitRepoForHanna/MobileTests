package business_objects;

/**
 * CheckListItem - is item in check list note
 */
public class CheckListItem {
    private String body;

    public CheckListItem(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

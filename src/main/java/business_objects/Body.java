package business_objects;

import java.util.List;

public class Body {

    private List<String> contentItems;

    public Body(List<String> contentItems) {
        this.contentItems = contentItems;
    }

    public List<String> getContentItems() {
        return contentItems;
    }

    public void setContentItems(List<String> contentItems) {
        this.contentItems = contentItems;
    }

}

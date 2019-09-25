package business_objects;

import java.util.List;

public class Body {

    private List<String> contentItems;

    public Body(List<String> contentItems) {
        this.contentItems = contentItems;
    }

    public Body() {
    }

    public List<String> getContentItems() {
        return contentItems;
    }

    public void setContentItems(List<String> contentItems) {
        this.contentItems = contentItems;
    }

    public void addNewValue(String item) {
        contentItems.add(item);
    }

    public void removeBodyItem(String itemToRemove){
        String item = getContentItems().stream().filter(i -> i.trim().equals(itemToRemove))
                .findFirst()
                .get();
        getContentItems().remove(item);
    }

}

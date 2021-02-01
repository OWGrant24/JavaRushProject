package Java_Multithreading.Multithreading10;

public class Level30Task03_ShareItem {
    public String description;
    public int itemId;

    public Level30Task03_ShareItem() {
        this("Test Item", 0);
    }

    public Level30Task03_ShareItem(String description) {
        this(description, 0);
    }

    public Level30Task03_ShareItem(int itemId) {
        this("Test Item", itemId);
    }

    public Level30Task03_ShareItem(String description, int itemId) {
        this.description = description;
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public int getItemId() {
        return itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Level30Task03_ShareItem that = (Level30Task03_ShareItem) o;

        if (itemId != that.itemId) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + itemId;
        return result;
    }

    @Override
    public String toString() {
        return "Level30Task03_ShareItem{" +
                "description='" + description + '\'' +
                ", itemId=" + itemId +
                '}';
    }
}

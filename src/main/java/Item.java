public class Item {
    private double price;
    private String name;

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder spacesBetweenNameAndPrice = new StringBuilder();

        for(int i = 0; i <15-name.length(); i++){
            spacesBetweenNameAndPrice.append(".");
        }
        return name + spacesBetweenNameAndPrice + price+" р.";
    }
}

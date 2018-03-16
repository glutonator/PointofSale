
public class Product {
    private String barCode;
    private String name;
    private double price;

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(String barCode, String name, double price) {
        this.barCode = barCode;
        this.name = name;
        this.price = price;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Product product = (Product) o;
//
//        if (Double.compare(product.price, price) != 0) return false;
//        if (!barCode.equals(product.barCode)) return false;
//        return name.equals(product.name);
//    }
//
//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = barCode.hashCode();
//        result = 31 * result + name.hashCode();
//        temp = Double.doubleToLongBits(price);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        return result;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.price, price) != 0) return false;
        if (barCode != null ? !barCode.equals(product.barCode) : product.barCode != null) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = barCode != null ? barCode.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "barCode='" + barCode + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
    public String getInfo(String text) {
        return this.getName();
    }
}

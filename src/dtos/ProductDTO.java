package dtos;

public class ProductDTO {

    private int idProduct;

    private String name;

    private String category;

    private int stock;

    private int lot;

    private  double price;

    public ProductDTO(int idProduct, String name, String category, int stock, int lot, double price) {
        this.idProduct = idProduct;
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.lot = lot;
        this.price = price;
    }

    public ProductDTO() {
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getLot() {
        return lot;
    }

    public void setLot(int lot) {
        this.lot = lot;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

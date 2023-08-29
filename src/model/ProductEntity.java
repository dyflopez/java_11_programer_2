package model;


import dtos.ProductDTO;

public class ProductEntity {
    private String tableName="product";
    //id_product
    private String idProduct;
    private String name;
    private String category;
    private int stock;
    private int lot;
    private  double price;

    public ProductEntity() {
    }

    public ProductEntity(String name, String category, int stock, int lot, double price) {
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.lot = lot;
        this.price = price;
    }

    public ProductEntity(ProductDTO productoDTO) {
        this.name =productoDTO.getName();
        this.setCategory(productoDTO.getCategory());
        this.stock=productoDTO.getStock();
        this.lot=productoDTO.getLot();
        this.price=productoDTO.getPrice();
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
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

    public String saveBackup(){
        return  idProduct+","+name+","+category+","+stock+","+lot+","+price;
    }
    @Override
    public String toString() {
        return "ProductEntity{" +
                "tableName='" + tableName + '\'' +
                ", idProduct='" + idProduct + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", stock=" + stock +
                ", lot=" + lot +
                ", price=" + price +
                '}';
    }
}

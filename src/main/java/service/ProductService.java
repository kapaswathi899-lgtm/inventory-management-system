package service;

import java.util.List;
import model.Product;
import repository.ProductDAO;

public class ProductService {

    private ProductDAO dao = new ProductDAO();

    public void addProduct(Product p) {
        dao.addProduct(p);
    }

    public List<Product> getAllProducts() {
        return dao.getAllProducts();
    }

    public Product getProduct(int id) {
        return dao.getProductById(id);
    }

    public void updateProduct(Product p) {
        dao.updateProduct(p);
    }

    public void deleteProduct(int id) {
        dao.deleteProduct(id);
    }
}
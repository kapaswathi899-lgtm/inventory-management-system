package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDAO {

    private final String url = "jdbc:postgresql://localhost:5432/inventory_db";
    private final String username = "postgres";
    private final String password = "123";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void addProduct(Product p) {
        String sql = "INSERT INTO products(name, price, quantity) VALUES (?, ?, ?)";

        try (Connection con = connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getQuantity());
            ps.executeUpdate();
            System.out.println("✔ Product added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection con = connect(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product getProductById(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        Product p = null;

        try (Connection con = connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public void updateProduct(Product p) {
        String sql = "UPDATE products SET name = ?, price = ?, quantity = ? WHERE id = ?";

        try (Connection con = connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getQuantity());
            ps.setInt(4, p.getId());

            ps.executeUpdate();
            System.out.println("✔ Product updated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try (Connection con = connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✔ Product deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
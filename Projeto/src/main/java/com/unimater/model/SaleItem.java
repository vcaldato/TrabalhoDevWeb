package com.unimater.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleItem implements Entity {

    private int id;
    private int saleId;
    private int productId;
    private int quantity;
    private double price;

    public SaleItem(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.saleId = rs.getInt("sale_id");
        this.productId = rs.getInt("product_id");
        this.quantity = rs.getInt("quantity");
        this.price = rs.getDouble("price");
    }

    public SaleItem(int id, int saleId, int productId, int quantity, double price) {
        this.id = id;
        this.saleId = saleId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public SaleItem() {}

    @Override
    public int getId() {
        return id;
    }

    public int getSaleId() {
        return saleId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public Entity constructFromResultSet(ResultSet rs) throws SQLException {
        return new SaleItem(rs);
    }

    @Override
    public PreparedStatement prepareStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, getSaleId());
        preparedStatement.setInt(2, getProductId());
        preparedStatement.setInt(3, getQuantity());
        preparedStatement.setDouble(4, getPrice());
        return preparedStatement;
    }
}

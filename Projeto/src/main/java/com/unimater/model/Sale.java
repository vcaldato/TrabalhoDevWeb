package com.unimater.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sale implements Entity {

    private int id;
    private String date;
    private double total;

    public Sale(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.date = rs.getString("date");
        this.total = rs.getDouble("total");
    }

    public Sale(int id, String date, double total) {
        this.id = id;
        this.date = date;
        this.total = total;
    }

    public Sale() {}

    @Override
    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public Entity constructFromResultSet(ResultSet rs) throws SQLException {
        return new Sale(rs);
    }

    @Override
    public PreparedStatement prepareStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, getDate());
        preparedStatement.setDouble(2, getTotal());
        return preparedStatement;
    }
}

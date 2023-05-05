package com.example.eShop.dao;


import com.example.eShop.DataBaseConnection;
import com.example.eShop.entity.PaymentDetails;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class PaymentDetailsDAO {

    public PaymentDetails findPDById(long customerId) throws SQLException {

        PaymentDetails foundPD = new PaymentDetails();
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.payment_details WHERE customer_id = ?");
        statement.setLong(1, customerId);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            foundPD = new PaymentDetails(rs.getLong("id"), rs.getString("card_owner_name"), rs.getString("card_number"), rs.getString("card_expiration_date"), rs.getInt("card_cvv"));
            foundPD.setCustomerId(customerId);
        }
        return foundPD;
    }

    public PaymentDetails createPD(PaymentDetails PD) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO public.payment_details (card_owner_name, card_number, card_expiration_date, card_cvv, customer_id) VALUES (?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, PD.getCardOwnerName());
            preparedStatement.setString(2, PD.getCardNumber());
            preparedStatement.setString(3, PD.getCardExpirationDate());
            preparedStatement.setInt(4, PD.getCvv());
            preparedStatement.setLong(5, PD.getCustomerId());

            preparedStatement.executeUpdate();

            generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            PD.setId(generatedKeys.getLong(1));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return PD;
    }

    public PaymentDetails deletePD(long id) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.payment_details WHERE id = ?");
        preparedStatement.setLong(1, id);

        try {
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public PaymentDetails updatePD(PaymentDetails PD) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = connection.prepareStatement("UPDATE public.payment_details SET card_owner_name=?, card_number=?, card_expiration_date=?, card_cvv=?, customer_id=? WHERE id = ?");
            preparedStatement.setLong(1, PD.getId());

            preparedStatement.setString(1, PD.getCardOwnerName());
            preparedStatement.setString(2, PD.getCardNumber());
            preparedStatement.setString(3, PD.getCardExpirationDate());
            preparedStatement.setInt(4, PD.getCvv());
            preparedStatement.setLong(5, PD.getCustomerId());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return PD;
    }

}

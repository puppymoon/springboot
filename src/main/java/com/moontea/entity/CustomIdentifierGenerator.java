package com.moontea.entity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdentifierGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

        String prefix = "ITEM";
        Connection connection = session.connection();

        try {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select count(SERI) as SERI from moontea.item");

            if (rs.next()) {
                int id = rs.getInt(1) + 1;
                String seri = StringUtils.leftPad(new Integer(id).toString(), 5, "0");
                String today = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()).toString();
                // ITEM + yyyyMMdd + 序號
                String generatedId = prefix + today + seri;
                return generatedId;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
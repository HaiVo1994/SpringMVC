package Utils;

import Model.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableDB {
    public static List<Table> findAll() {
        List<Table> tables=new ArrayList<>();
        try (Connection connection= My_SQL_Connection.getSqlConnection();
             PreparedStatement preparedStatement=connection.prepareStatement("SELECT id_table,local,capacity,is_available FROM coffee.table_coffee WHERE is_delete=0;")
        ){
            System.out.println(preparedStatement);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                int id=rs.getInt("id_table");
                String local=rs.getString("local");
                int capacity=rs.getInt("capacity");
                int is_available=rs.getInt("is_available");
                Table table=new Table(id,local,capacity,is_available);
                tables.add(table);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        return tables;
    }

}

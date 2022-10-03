package repository;

import configurasi.DataSource;
import model.Absen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AbsenRepository {
    DataSource dataSource = new DataSource();

    // Absen CRUD (Create, Read, Update, Delete)
    public void insertAbsen (Integer id, String start) {
        String insertStatement = "INSERT INTO absen (id,start) VALUES(?,?)";
        try {
            PreparedStatement stmt= dataSource.connection().prepareStatement(insertStatement);
            stmt.setInt(1,id);
            stmt.setString(2,start);
            int res = stmt.executeUpdate();
            System.out.println(res+" Absen Inserted");
        } catch (Exception e) {
            System.out.println("Absen not Inserted");
        }
    }

    public void readAbsen (String jenis, Integer id) {
        String insertStatement = "";
        if (jenis == "all") {
            insertStatement = "SELECT * FROM absen";
        } else if (jenis == "by id") {
            insertStatement = "SELECT * FROM absen WHERE id = ?";
        }
        try {
            PreparedStatement stmt= dataSource.connection().prepareStatement(insertStatement);
            if (jenis == "by id") {
                stmt.setInt(1,id);
            }
            ResultSet rs = stmt.executeQuery();
            System.out.println("Hasil Read:");
            while(rs.next()){
                System.out.print(rs.getInt(1) + " \t");
                System.out.print(rs.getString(2) + " \t");
                System.out.print(rs.getString(3) + "\n");
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Gagal Baca");
        }
    }

    public void updateAbsen (Integer id, String end) {
        String insertStatement = "UPDATE absen SET end=? WHERE id=?";
        try {
            PreparedStatement stmt= dataSource.connection().prepareStatement(insertStatement);
            stmt.setString(1,end);
            stmt.setInt(2,id);
            int res = stmt.executeUpdate();
            System.out.println(res+" Absen Updated");
        } catch (Exception e) {
            System.out.println("Absen not Updated");
        }
    }

    public void deleteAbsen (Integer id) {
        String insertStatement = "DELETE FROM absen WHERE id=?";
        try {
            PreparedStatement stmt= dataSource.connection().prepareStatement(insertStatement);
            stmt.setInt(1, id);
            int res = stmt.executeUpdate();
            System.out.println (res + " Absen Deleted");
        } catch (Exception e) {
            System.out.println ("Absen not Deleted");
        }
    }
}

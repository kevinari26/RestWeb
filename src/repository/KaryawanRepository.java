package repository;

import configurasi.DataSource;
import model.Karyawan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KaryawanRepository {
    DataSource dataSource = new DataSource();

    // Karyawan CRUD (Create, Read, Update, Delete)
    public Integer insertKaryawan (Karyawan karyawan) {
        String insertStatement = "INSERT INTO karyawan VALUES(?,?,?)";
        try {
            PreparedStatement stmt= dataSource.connection().prepareStatement(insertStatement);
            stmt.setInt(1,karyawan.getId());
            stmt.setString(2,karyawan.getNama());
            stmt.setString(3,karyawan.getAlamat());
            int res = stmt.executeUpdate();
            System.out.println(res+" Karyawan Inserted");
            return (1);
        } catch (Exception e) {
            System.out.println("Karyawan not Inserted");
            return (0);
        }
    }

    public List<Karyawan> readKaryawan (String id) {
        String insertStatement = "";
        if (id == "all") {
            insertStatement = "SELECT * FROM karyawan";
        } else {
            insertStatement = "SELECT * FROM karyawan WHERE id = ?";
        }
        List<Karyawan> hasil = new ArrayList<>();
        try {
            PreparedStatement stmt= dataSource.connection().prepareStatement(insertStatement);
            if (id != "all") {
                stmt.setInt(1, Integer.valueOf(id));
            }
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	hasil.add (new Karyawan (rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            System.out.println("Berhasil Baca");
        } catch (Exception e) {
            System.out.println("Gagal Baca");
        }
        return (hasil);
    }

    public Integer updateKaryawan (Karyawan karyawan, Integer id) {
        String insertStatement = "UPDATE karyawan " +
            "SET id=?, nama=?, alamat=? " +
            "WHERE id=?";
        try {
            PreparedStatement stmt= dataSource.connection().prepareStatement(insertStatement);
            stmt.setInt(1,karyawan.getId());
            stmt.setString(2,karyawan.getNama());
            stmt.setString(3,karyawan.getAlamat());
            stmt.setInt(4,id);
            int res = stmt.executeUpdate();
            System.out.println (res + " Karyawan Updated");
            return (1);
        } catch (Exception e) {
            System.out.println ("Karyawan not Updated");
            System.out.println (e);
            return (0);
        }
    }

    public Integer deleteKaryawan (Integer id) {
        String insertStatement = "DELETE FROM karyawan WHERE id=?";
        try {
            PreparedStatement stmt= dataSource.connection().prepareStatement(insertStatement);
            stmt.setInt(1, id);
            int res = stmt.executeUpdate();
            System.out.println (res + " Karyawan Deleted");
            return (1);
        } catch (Exception e) {
            System.out.println ("Karyawan not Deleted");
            return (0);
        }
    }




    public void createTabel () {
        String insertStatement = "CREATE TABLE test(id int PRIMARY KEY NOT NULL AUTO_INCREMENT, nama varchar(45), telepon varchar(15))";
        try {
            PreparedStatement stmt= dataSource.connection().prepareStatement(insertStatement);
            int res = stmt.executeUpdate();
            System.out.println(res+" Tabel Created");
        } catch (Exception e) {
            System.out.println("Tabel not Created");
        }
    }

    public void deleteTabel (String namaTabel) {
        String insertStatement = "DROP TABLE " + namaTabel;
        try {
            PreparedStatement stmt= dataSource.connection().prepareStatement(insertStatement);
            int res = stmt.executeUpdate();
            System.out.println(res+" Tabel Deleted");
        } catch (Exception e) {
            System.out.println("Tabel not Deleted");
            System.out.println(e);
        }
    }
}

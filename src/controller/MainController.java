package controller;

import model.Karyawan;
import model.Absen;
import repository.KaryawanRepository;
import repository.AbsenRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MainController {
    KaryawanRepository karyawanRepository = new KaryawanRepository();
    AbsenRepository absenRepository = new AbsenRepository();

    // Karyawan CRUD (Create, Read, Update, Delete)
    public Integer insertKaryawan(Karyawan karyawan) {
	    return (karyawanRepository.insertKaryawan(karyawan));
    }

    public List<Karyawan> readKaryawan (String id) { // read tabel
        // "all" atau masukkan "id"
    	return (karyawanRepository.readKaryawan(id));
    }

    public Integer updateKaryawan (Karyawan karyawan, Integer id) { // delete menggunakan id
        return (karyawanRepository.updateKaryawan(karyawan, id));
    }

    public Integer deleteKaryawan (Integer id) { // delete menggunakan id
        return (karyawanRepository.deleteKaryawan(id));
    }



    // Absen CRUD (Create, Read, Update, Delete)
    public void insertAbsen(Integer id) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(format); // datetime start absen
        absenRepository.insertAbsen(id, formattedDateTime);
    }

    public void readAbsen (String jenis, Integer id) { // read tabel
        // "all" atau "by id"
        absenRepository.readAbsen(jenis, id);
    }

    public void updateAbsen (Integer id) { // delete menggunakan id
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(format); // datetime end absen
        absenRepository.updateAbsen(id, formattedDateTime);
    }

    public void deleteAbsen (Integer id) { // delete menggunakan id
        absenRepository.deleteAbsen(id);
    }




    public void createTabel () { // buat tabel
        karyawanRepository.createTabel();
    }

    public void deleteTabel (String namaTabel) { // delete tabel
        karyawanRepository.deleteTabel(namaTabel);
    }
}

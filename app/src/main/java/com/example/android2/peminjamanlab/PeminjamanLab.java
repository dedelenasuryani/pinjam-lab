package com.example.android2.peminjamanlab;

/**
 * Created by android2 on 07/03/18.
 */

public class PeminjamanLab {

    private long id;
    private  String namaPeminjam;
    private  String jabatan;
    private  String kodeBarang;
    private  String namaBarang;
    private String ruangLab;

    public PeminjamanLab( String namaPeminjam, String jabatan, String kodeBarang, String namaBarang, String ruangLab) {
        this.namaPeminjam = namaPeminjam;
        this.jabatan = jabatan;
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.ruangLab = ruangLab;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public void setNamaPeminjam(String namaPeminjam) {
        this.namaPeminjam = namaPeminjam;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getRuangLab() {
        return ruangLab;
    }

    public void setRuangLab(String ruangLab) {
        this.ruangLab = ruangLab;
    }
}

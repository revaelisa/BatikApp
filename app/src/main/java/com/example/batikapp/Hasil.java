package com.example.batikapp;

import java.io.Serializable;
import java.util.List;

public class Hasil implements Serializable {
    private List<Batik> hasil;

    public List<Batik> getHasil() {
        return hasil;
    }

    public void setHasil(List<Batik> hasil) {
        this.hasil = hasil;
    }
}

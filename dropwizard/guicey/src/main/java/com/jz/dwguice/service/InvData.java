package com.jz.dwguice.service;


import java.util.ArrayList;
import java.util.List;

public class InvData {

    private static int count = 0;
    private List<InvItem> inv;


    public InvData() {
        this.inv = new ArrayList<>();
    }

    public void add(String name, String desc) {
        InvItem it = new InvItem(++InvData.count, name, desc);
        this.inv.add(it);
    }

    public void remove(int id) {
        for (InvItem it : this.inv) {
            if (it.getId() == id) {
                this.inv.remove(it);
            }
        }
    }

    public List<InvItem> get() {
        return this.inv;
    }



}

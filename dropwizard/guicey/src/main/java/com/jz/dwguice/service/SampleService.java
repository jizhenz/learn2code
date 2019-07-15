package com.jz.dwguice.service;

import javax.inject.Singleton;
import java.util.List;

/**
 * @author Vyacheslav Rusakov
 * @since 27.07.2017
 */
@Singleton
public class SampleService {

    // state used to show that service instance is the same for guice and sub-resource
    private String state;
    private InvData inv = new InvData();

    public void setState(String state) {
        this.state = state;
    }

    public String applyState(String id) {
        return state + " " + id;
    }

    public List<InvItem> read() {return this.inv.get();}
    public void insert(String name, String desc) {
        this.inv.add(name, desc);
    }
    public void delete(int id) {
        this.inv.remove(id);
    }
}

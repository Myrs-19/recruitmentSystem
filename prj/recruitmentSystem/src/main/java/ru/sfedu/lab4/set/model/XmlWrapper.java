package ru.sfedu.lab4.set.model;

import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class XmlWrapper<T> {
    @ElementList(inline=true)
    public List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
    
}
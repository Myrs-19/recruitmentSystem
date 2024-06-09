package ru.sfedu.lab5.api;

import java.util.List;

public interface IHibernateDataProvider {
    List selectAllNativeSql();
    Object selectAllCriteria();
    Object selectAllHQL();
}

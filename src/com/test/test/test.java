package com.test.test;

import com.test.bean.TUserEntity;
import com.test.dao.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class test {

    public static void main(String[] args) {
        add();

        delete();

        update();

        query();
    }

    public static void add() {
        try {
            Session session = HibernateUtils.getSession();
            Transaction tran = session.beginTransaction();
            //增
            TUserEntity addObj = new TUserEntity();
            addObj.setSex("男");
            addObj.setAge(129);
            addObj.setUsername("addObj");
            session.save(addObj);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void delete() {
        try {
            Session session = HibernateUtils.getSession();
            Transaction tran = session.beginTransaction();
            //删
            /*查询复合主键对象，需要先构建主键*/
            TUserEntity deleteObjPriKey = new TUserEntity();
            deleteObjPriKey.setId(5);
            deleteObjPriKey.setUsername("5");
            TUserEntity deleteObj = session.get(TUserEntity.class,deleteObjPriKey);
            session.delete(deleteObj);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void update() {
        try {
            Session session = HibernateUtils.getSession();
            Transaction tran = session.beginTransaction();
            //改
            TUserEntity updateObjPriKey = new TUserEntity();
            updateObjPriKey.setId(6);
            updateObjPriKey.setUsername("6");
            TUserEntity updateObj = session.get(TUserEntity.class,updateObjPriKey);
            updateObj.setAge(102);
            session.update(updateObj);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void query() {
        try {
            Session session = HibernateUtils.getSession();
            //查
            TUserEntity queryObjjPriKey = new TUserEntity();
            queryObjjPriKey.setId(7);
            queryObjjPriKey.setUsername("7");
            TUserEntity queryObj = session.get(TUserEntity.class,queryObjjPriKey);
            System.out.println(queryObj.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

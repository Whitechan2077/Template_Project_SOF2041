/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import com.edusys.entity.NhanVien;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
/**
 *
 * @author buidu
 */
public class NhanVienDao implements DAO<NhanVien, String>{

    private SessionFactory factory;

    
    public NhanVienDao(SessionFactory factory) {
        this.factory = factory;

    }
    
    @Override
    public void insert(NhanVien e) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(e);
            transaction.commit();
        }
    }

    @Override
    public void delete(NhanVien e) {
         try (Session session = factory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.remove(e);
            transaction.commit();
    }
    }

    @Override
    public void update(NhanVien e) {
       try (Session session = factory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.merge(e);
            transaction.commit();
    }
    }

    @Override
    public List<NhanVien> getAll() {
        Session session = factory.openSession();
          Query<NhanVien> query = session.getNamedQuery("NhanVien.findAll");
        List<NhanVien> list = query.getResultList();
        return list;
    }
      
    @Override
    public NhanVien getByID(String id) {
        NhanVien nhanVien = null;    
        try {
            try (Session session = factory.openSession()) {
                Query<NhanVien> query = session.getNamedQuery("NhanVien.findByMaNV");
                query.setParameter("maNV", id);
                nhanVien = query.getSingleResult();
            }
        } catch (Exception e) {
            
        }
        return nhanVien;
    }  
}

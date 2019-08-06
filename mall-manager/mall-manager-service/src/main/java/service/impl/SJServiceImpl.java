package service.impl;

import DAO.ISJDao;
import DAO.impl.SJDaoImpl;
import DAO.impl.SJPageDaoImpl;
import page.PageEntity;
import service.ISJService;
import sj.SJ;

import java.util.List;

public class SJServiceImpl implements ISJService {
    @Override
    public void addSJ(SJ sj) {
        ISJDao dao = new SJDaoImpl();
        dao.insertSJ(sj);
    }

    @Override
    public void removeSJ(int id) {
        ISJDao dao = new SJDaoImpl();
        dao.deleteSJById(id);

    }

    @Override
    public void modifySJ(SJ sj) {
        ISJDao dao = new SJDaoImpl();
        dao.update(sj);
    }

    @Override
    public SJ findSJById(int id) {
        ISJDao dao = new SJDaoImpl();
        SJ sj=null;
        sj=dao.selectSJById(id);
        return sj;
    }

    @Override
    public List<SJ> findAll1() {
        ISJDao dao = new SJDaoImpl();
        List<SJ> sjList=null;
        sjList=dao.selectAll1();
        return sjList;
    }

    @Override
    public List<SJ> findAll0() {
        ISJDao dao = new SJDaoImpl();
        List<SJ> sjList=null;
        sjList=dao.selectAll0();
        return sjList;
    }

    @Override
    public void getAll1(PageEntity<SJ> peC) {
       SJPageDaoImpl pQDI = new SJPageDaoImpl();
        try {
            pQDI.getAll1(peC);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getAll0(PageEntity<SJ> peC) {
        SJPageDaoImpl pQDI = new SJPageDaoImpl();
        try {
            pQDI.getAll0(peC);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

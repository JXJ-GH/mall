package DAO;

import page.PageEntity;
import sj.SJ;


public interface ISJPageDao {
    public void getAll1(PageEntity<SJ> pageEntity);
    public void getAll0(PageEntity<SJ> pageEntity);

}

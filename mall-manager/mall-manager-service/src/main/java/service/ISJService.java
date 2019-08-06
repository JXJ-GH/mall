package service;

import page.PageEntity;
import sj.SJ;

import java.util.List;

public interface ISJService {
    //增加用户
    public void addSJ(SJ sj);
    //删除用户
    public  void removeSJ(int id);
    //修改用户
    public void modifySJ(SJ sj);
    //查询单用户
    public SJ findSJById(int id);
    //查询所有用户
    public List<SJ> findAll1();

    public List<SJ> findAll0();

    public void getAll1(PageEntity<SJ> peC);

    public void getAll0(PageEntity<SJ> peC);
}

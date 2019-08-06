package DAO;





import sj.SJ;

import java.util.List;

public interface ISJDao {
    //添加数据
    public void insertSJ(SJ sj);
    //删除数据 根据id
    public void deleteSJById(int id);
    //修改数据
    public void update(SJ sj);
    //查询数据 根据ID
    public SJ selectSJById(int id);
    //商家列表
    public List<SJ> selectAll1();
    //注册商家列表
    public List<SJ> selectAll0();
    //商家资质状态
    public void ChangeState(SJ sj);

    //获取商家总数
    public int selectCount1();

    //获取注册商家总数
    public int selectCount0();

}

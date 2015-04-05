package org.lazicats.admin.dal.db;

import java.util.List;

import org.lazicats.admin.entity.Desk;
import org.lazicats.common.dbaccess.orm.mybatis.IBaseDao;
import org.lazicats.common.vo.Page;

public interface IDeskDao extends IBaseDao<Desk>{
	
	/**
	 * 根据类型查询桌位信息
	 */
	public List<Desk> findDesk(Integer type)throws Exception;
	
	/**
	 * 获取查询条件的后桌位信息记录数
	 */
	public Integer countRows(Page page)throws Exception;
	
	
	
	/***
	 * 查询所有桌位信息
	 */
	public List<Desk> findAllDesk()throws Exception;
	
	/***
	 * 开台更改是否预订标签
	 */
	public void update(Integer id)throws Exception;
	
	/***
	 * 更改标签，表示顾客处于就餐状态
	 * @throws Exception
	 */
	public void updateEate(Integer id)throws Exception;
	
	/***
	 * 更改标签，表示顾客就餐完毕
	 */
	public void updateRest(Integer id)throws Exception;
	/***
	 * 条件查询分页
	 */
	public List<Desk> pageDesk(Page page)throws Exception;
	
	/***
	 * 添加桌位信息
	 */
	public void addDesk(Desk desk)throws Exception;
	
	/***
	 * 根据id查询桌位信息
	 */
	public Desk findDeskById(Integer id)throws Exception;
	
	/***
	 * 修改桌位信息
	 */
	public void updateDesk(Desk desk)throws Exception;
	
	/**
	 * 删除桌位信息
	 */
	public void delDesk(Integer id)throws Exception;
}

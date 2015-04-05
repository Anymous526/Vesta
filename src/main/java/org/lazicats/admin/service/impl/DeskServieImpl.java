package org.lazicats.admin.service.impl;

import java.util.List;

import org.lazicats.admin.dal.db.IDeskDao;
import org.lazicats.admin.entity.Desk;
import org.lazicats.admin.service.IDeskService;
import org.lazicats.common.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DeskServieImpl implements IDeskService{
	@Autowired
	private IDeskDao deskDao;
	
	
	/**
	 * 根据类型查询部分桌位信息
	 * @throws Exception 
	 */
	@Override
	public List<Desk> findDesk(Integer type) throws Exception {
		
		return deskDao.findDesk(type);
	}

	/***
	 * 开台更改是否预订标签
	 */
	@Override
	public void update(Integer id) throws Exception {
		deskDao.update(id);
		
	}
	
	/***
	 * 更改标签状态，表示顾客处于就餐状态
	 */
	@Override
	public void updateEate(Integer id) throws Exception {
		deskDao.updateEate(id);
		
	}
	
	/***
	 * 更改标签状态，表示顾客就餐完毕
	 */

	@Override
	public void updateRest(Integer id) throws Exception {
		deskDao.updateRest(id);
		
	}

	/***
	 * 条件查询分页
	 */
	@Override
	public List<Desk> pageDesk(Page page) throws Exception {
		
		return deskDao.pageDesk( page);
	}
	
	/***
	 * 查询所有桌位信息
	 */
	@Override
	public List<Desk> findAllDesk() throws Exception {
		// TODO Auto-generated method stub
		return deskDao.findAllDesk();
	}
	/***
	 * 添加桌位信息
	 */
	@Override
	public void addDesk(Desk desk) throws Exception {
		deskDao.addDesk(desk);
		
	}
	
	/***
	 * 根据id查询桌位信息
	 */
	@Override
	public Desk findDeskById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return deskDao.findDeskById(id);
	}
	
	/***
	 * 修改桌位信息
	 */
	@Override
	public void updateDesk(Desk desk) throws Exception {
		// TODO Auto-generated method stub
		deskDao.updateDesk(desk);
	}
	/**
	 * 删除桌位信息
	 */
	@Override
	public void delDesk(Integer id) throws Exception {
		// TODO Auto-generated method stub
		deskDao.delDesk(id);
	}
	
	/**
	 * 获取查询条件的后桌位信息记录数
	 */
	@Override
	public Integer countRows(Page page) throws Exception {
		// TODO Auto-generated method stub
		return deskDao.countRows(page);
	}

	
	
	
}

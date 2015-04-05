package org.lazicats.website.service.impl;

import java.util.List;

import org.lazicats.common.basecomponent.page.PageFinder;
import org.lazicats.common.vo.Page;
import org.lazicats.website.dal.db.IGoodsDao;
import org.lazicats.website.entity.Goods;
import org.lazicats.website.service.IGoodsService;
import org.lazicats.website.vo.GoodsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GoodsServiceImpl implements IGoodsService {
	
	@Autowired
	private IGoodsDao goodsDao;
	
	/**
	 * 查询所有商品信息
	 */
	@Override
	public List<Goods> findList() throws Exception {
		
		return goodsDao.findList();
	}
	/**
	 * 分页查询商品信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageFinder<Goods> pageQueryGoods(PageFinder<Goods> page) {
		
		return (PageFinder<Goods>) goodsDao.pageQueryGoods(page);
	}
	
	/**
	 * 根据ID查询商品信息
	 */
	@Override
	public Goods findOneById(Integer id) throws Exception {
		
		return goodsDao.findOneById(id);
	}
	/****
	 * 根据类型查询商品信息
	 */
	@Override
	public List<Goods> findByType(Goods goods) throws Exception {
		
		return goodsDao.findByType(goods);
	}
	  /***
	    * 添加商品信息
	    */
	  
	@Override
	public void addGoods(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		 goodsDao.addGoods(goods);
	}
	
	
	 /***
	    * 修改商品信息
	    */
	@Override
	public void updateGoods(Goods goods) throws Exception {
		goodsDao.updateGoods(goods);
		
	}
	
	 /**
	    * 根据id删除商品信息
	    */
	@Override
	public void delGoods(Integer id) throws Exception {
		goodsDao.delGoods(id);
		
	}
	
	  /***
     * 查询商品总数量
     * @param page
     * @return
     * @throws Exception
     */ 
	@Override
	public Integer countRows(Page page) throws Exception {
		// TODO Auto-generated method stub
		return goodsDao.countRows(page);
	}
	
	
	/**
     * 分页查询商品信息
     * @param page
     * @return
     * @throws Exception
     */
	@Override
	public List<Goods> pageGoods(Page page) throws Exception {
		// TODO Auto-generated method stub
		return goodsDao.pageGoods(page);
	}
	
	 /***
     * 根据条件查询商品总数量
     * @param page
     * @return
     * @throws Exception
     */ 
	@Override
	public Integer count(Integer type) throws Exception {
		
		return goodsDao.count(type);
	}
	
	 /***
     * 根据类型对商品进行分页
     * @param page
     * @return
     * @throws Exception
     */   
	@Override
	public Goods page(GoodsPage page) throws Exception {
		// TODO Auto-generated method stub
		return goodsDao.page(page);
	}

}

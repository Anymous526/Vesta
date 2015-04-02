package org.lazicats.website.dal.db.impl;

import java.util.List;

import org.lazicats.common.basecomponent.page.PageFinder;
import org.lazicats.common.vo.Page;
import org.lazicats.website.dal.db.IGoodsDao;
import org.lazicats.website.entity.Goods;
import org.lazicats.website.vo.GoodsPage;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDaoImpl implements IGoodsDao{

	@Override
	public void create(Goods t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOfBatch(List<Goods> entities) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Goods t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOfBatch(List<Goods> entities) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer delete(Goods entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteOfBatch(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(Goods t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOfBatch(List<Goods> entities) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Goods findOneById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> findList(List<Goods> entites) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findAllCount() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findCount(Goods query) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByIdSelective(Goods entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> findList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> pageQueryGoods(PageFinder<Goods> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Goods findOneById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> findByType(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addGoods(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGoods(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delGoods(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer countRows(Page page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> pageGoods(Page page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer count(Integer type) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Goods page(GoodsPage page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

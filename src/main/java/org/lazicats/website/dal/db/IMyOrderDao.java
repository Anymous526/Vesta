package org.lazicats.website.dal.db;
import java.util.List;
import org.lazicats.common.dbaccess.orm.mybatis.IBaseDao;
import org.lazicats.common.vo.Page;
import org.lazicats.website.entity.MyOrder;

public interface IMyOrderDao extends IBaseDao<MyOrder> {
	/**
	 * 生成订单信息
	 */
	public Integer addMyOrder(MyOrder myorder)throws Exception;
	
	
	
	 /**
     * 根据ID获取订单信息
     * @return
     */
    public MyOrder findById(String id) throws Exception;
    
    
    /***
     * 后台开台后，顾客订餐,修改订单信息
     */
	public void updateMyOrder(MyOrder myOrder)throws Exception;
	
	/***
	 * 查询所有订单信息
	 */
	public List<MyOrder> findAll()throws Exception;
	
	
	/***
	 * 根据ID删除订单信息
	 */
	public void deleteMyOrder(String id)throws Exception;
	
	
	/**
	 * 获取查询条件的后桌位信息记录数
	 */
	public Integer countRows(Page page)throws Exception;
	
	/***
	 * 条件查询分页
	 */
	public List<MyOrder> pageMyOrder(Page page)throws Exception;
	
	
	
}

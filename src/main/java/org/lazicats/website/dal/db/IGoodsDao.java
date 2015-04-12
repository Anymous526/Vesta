package org.lazicats.website.dal.db;

import java.util.List;

import org.lazicats.common.basecomponent.page.PageFinder;
import org.lazicats.common.dbaccess.orm.mybatis.IBaseDao;
import org.lazicats.common.vo.Page;
import org.lazicats.website.entity.Goods;
import org.lazicats.website.vo.GoodsPage;

public interface IGoodsDao extends IBaseDao<Goods>  {
		
	 /**
     * 获取所有的对象
     * @return
     */
    public List<Goods> findList() throws Exception;
    
    /***
     * 查询商品总数量
     * @param page
     * @return
     * @throws Exception
     */
    public Integer countRows(Page page)throws Exception;
    
    
    /***
     * 根据条件查询商品总数量
     * @param page
     * @return
     * @throws Exception
     */
    public Integer count(Integer type)throws Exception;
    
    
    /***
     * 根据类型对商品进行分页
     * @param page
     * @return
     * @throws Exception
     */
    public Goods page(GoodsPage page)throws Exception;
    
    
    /**
     * 分页查询商品信息
     * @param page
     * @return
     * @throws Exception
     */
    public List<Goods> pageGoods(Page page)throws Exception;
    
    
    /**
     * 分页查询用户列表
     * 
     * @param page
     *        分页参数
     */
    public List<Goods> pageQueryGoods(PageFinder<Goods> page);
    
    
    /**
     * 根据ID获取对象
     * @param id
     * @return
     */
    public Goods findOneById(Integer id) throws Exception;
    
    /***
     * 根据类型查询
     */
   public List<Goods> findByType(Goods goods)throws Exception;
   
   
   /***
    * 添加商品信息
    */
   public void addGoods(Goods goods)throws Exception;
   
   
   /***
    * 修改商品信息
    */
   public void updateGoods(Goods goods)throws Exception;
   
   /**
    * 根据id删除商品信息
    */
   public void delGoods(Integer id)throws Exception;
}

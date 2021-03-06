package com.zzc.track.base;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName: BaseService
 * @Description: Service基类
 * @author
 */
public class BaseServiceImpl<T> implements BaseService<T> {

	protected Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
    protected Mapper<T> mapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xiaobai.adms.base.BaseService#save(T)
	 */
	public int insert(T entity) {
		return mapper.insert(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xiaobai.adms.base.BaseService#saveSelective(T)
	 */
	public int insertSelective(T entity) {
		return mapper.insertSelective(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xiaobai.adms.base.BaseService#updateByPrimaryKey(T)
	 */
	public int updateByPrimaryKey(T entity) {
		return mapper.updateByPrimaryKey(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xiaobai.adms.base.BaseService#updateByPrimaryKeySelective(T)
	 */
	public int updateByPrimaryKeySelective(T entity) {
		return mapper.updateByPrimaryKeySelective(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xiaobai.adms.base.BaseService#delete(T)
	 */
	public int delete(T entity) {
		return mapper.delete(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xiaobai.adms.base.BaseService#deleteByPrimaryKey(T)
	 */
	public int deleteByPrimaryKey(Object key) {
		return mapper.deleteByPrimaryKey(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xiaobai.adms.base.BaseService#select(T)
	 */
	public List<T> select(T entity) {
		return mapper.select(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xiaobai.adms.base.BaseService#selectByPrimaryKey(T)
	 */
	public T selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xiaobai.adms.base.BaseService#selectAll(T)
	 */
	public List<T> selectAll() {
		return mapper.selectAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xiaobai.adms.base.BaseService#selectOne(T)
	 */
	public T selectOne(T entity) {
		return mapper.selectOne(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xiaobai.adms.base.BaseService#selectCount(T)
	 */
	public int selectCount(T entity) {
		return mapper.selectCount(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xiaobai.adms.base.BaseService#findByProperties(T)
	 */
	public T findByProperties(T entity) {
		return mapper.selectOne(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xiaobai.adms.base.BaseService#selectPage(int, int)
	 */
	public List<T> selectPage(int pageNum, int pageSize, T paramBean) {
		PageHelper.startPage(pageNum, pageSize);
		return mapper.select(paramBean);
	}

	public List<T> selectByExample(Example example) {
		return mapper.selectByExample(example);
	}

	public List<T> selectByExampleWithPage(Example example, int offset,
			int count) {
		return mapper.selectByExampleAndRowBounds(example, new RowBounds(
				offset, count));
	}

	public int selectCountByExample(Example example) {
		return mapper.selectCountByExample(example);
	}
}

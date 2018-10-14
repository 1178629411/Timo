package com.linln.admin.system.repository;

import com.linln.admin.system.domain.Menu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author 小懒虫
 * @date 2018/8/14
 */
public interface MenuRepository extends BaseRepository<Menu, Long> {

    /**
     * 查找状态正常的菜单
     * @param sort 排序对象
     */
    public List<Menu> findAllByStatus(Sort sort, Byte status);

    /**
     * 查找多个菜单
     * @param ids id列表
     */
    public List<Menu> findByIdInAndStatus(List<Long> ids, Byte status);

    /**
     * 根据父ID查找子菜单
     * @param pids pid列表
     */
    public List<Menu> findByPidsLikeAndStatus(String pids, Byte status);

    /**
     * 获取排序最大值
     * @param pid 父菜单ID
     */
    @Query("select max(sort) from Menu m where m.pid = ?1")
    public Integer findSortMax(long pid);
}

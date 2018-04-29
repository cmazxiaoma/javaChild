package cn.photoflash.album.dao;

import java.util.List;
import java.util.Map;

import cn.photoflash.album.bean.Album;

/**
 * 相册操作类
 * 
 * @author yishuihan
 * 
 */
public interface AlbumDao {
	// 添加相册
	public void add(Album album);

	// 根据id删除相册
	public void deleteById(int aid);

	// 修改相册信息
	public void update(Album album);

	// 查询所有的相册
	public List<Album> findAll();

	// 获取总记录数
	public int getTotalrows();

	// 分页查询
	public List<Album> findByPage(Map<String, Integer> map);

	// 通过id查询相册
	public Album find(Integer aid);

	// 通过albumname查找
	public Album find(String albumname);

	// 更新局部相册信息
	public void updateById(Album album);

	// 我的相册分页
	public List<Album> findPageByUid(Map<String, Integer> map);
}

package cn.photoflash.photo.dao;

import java.util.List;
import java.util.Map;

import cn.photoflash.photo.bean.Photo;

/**
 * 相片处理类
 * 
 * @author yishuihan
 * 
 */
public interface PhotoDao {
	// 添加相片
	public void add(Photo photo);

	// 删除相片
	public void delete(Photo photo);

	// 更新相片
	public void update(Photo photo);

	// 根据id查询相片的详细
	public Photo find(int pid);

	// 查询某相册的所有相片
	public List<Photo> findAll(int aid);

	// 查找所有的相片
	public List<Photo> findAll();

	// 分页查询相片
	public List<Photo> findByPage(Map<String, Integer> map);

	// 获取总记录数
	public int getTotalrows();

	// 获取总记录数
	public int getTotalrowsByAid(int aid);

	// 带条件的分页查询
	public List<Photo> findByAid(Map<String, Integer> map);

	// 修改部分图片信息
	public void updateById(Photo photo);

	// 通过uid获取总记录
	public int getTotalrowsByUid(int uid);

	// 通过uid获取总照片
	public List<Photo> findByUid(Map<String, Integer> map);
}

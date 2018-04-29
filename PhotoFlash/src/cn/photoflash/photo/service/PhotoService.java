package cn.photoflash.photo.service;

import java.util.List;

import cn.photoflash.photo.bean.Photo;
import cn.photoflash.photo.bean.PhotoPageBean;

/**
 * 照片服务类
 * 
 * @author yishuihan
 * 
 */
public interface PhotoService {
	// 添加照片
	public void add(Photo photo);

	// 删除照片
	public void delete(Photo photo);

	// 查看照片
	public Photo find(int pid);

	// 查看某相册下的所有相片
	public List<Photo> findAll(int aid);

	// 查找所有的相片
	public List<Photo> findAll();

	// 分页查询photo
	public PhotoPageBean findByAllPage(int page, int pagesize, int uid);

	// 带条件的分页查询
	public PhotoPageBean findByPage(int page, int pagesize, int albumId);

	// 更新照片
	public void update(Photo photo);

	// 我的相片分页
	public PhotoPageBean findPageByUid(int page, int pagesize, int uid);

}

package cn.photoflash.photo.service.Imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.photoflash.photo.bean.Photo;
import cn.photoflash.photo.bean.PhotoPageBean;
import cn.photoflash.photo.dao.PhotoDao;
import cn.photoflash.photo.dao.imp.PhotoDaoImp;
import cn.photoflash.photo.service.PhotoService;

public class PhotoServiceImp implements PhotoService {

	private PhotoDao photoDao = new PhotoDaoImp();

	@Override
	public void add(Photo photo) {
		photoDao.add(photo);
	}

	@Override
	public void delete(Photo photo) {
		photoDao.delete(photo);
	}

	@Override
	public Photo find(int pid) {
		return photoDao.find(pid);
	}

	@Override
	public List<Photo> findAll(int aid) {
		return photoDao.findAll(aid);
	}

	@Override
	public List<Photo> findAll() {
		return photoDao.findAll();
	}

	/**
	 * 封装PhotoPageBean
	 */
	@Override
	public PhotoPageBean findByAllPage(int page, int pagesize, int uid) {
		PhotoPageBean photoPageBean = new PhotoPageBean();
		Map<String, Integer> map = new HashMap<String, Integer>();
		photoPageBean.setCurpage(page);
		photoPageBean.setPagesize(pagesize);

		map.put("page", (page - 1) * pagesize);
		map.put("pagesize", pagesize);
		map.put("uid", uid);

		List<Photo> photoList = photoDao.findByPage(map);

		photoPageBean.setTotalrows(photoDao.getTotalrows());
		photoPageBean.setPhotoList(photoList);

		return photoPageBean;
	}

	@Override
	public PhotoPageBean findByPage(int page, int pagesize, int albumId) {
		PhotoPageBean photoPageBean = new PhotoPageBean();
		Map<String, Integer> map = new HashMap<String, Integer>();
		photoPageBean.setCurpage(page);
		photoPageBean.setPagesize(pagesize);

		map.put("page", (page - 1) * pagesize);
		map.put("pagesize", pagesize);
		map.put("aid", albumId);

		List<Photo> photoList = photoDao.findByAid(map);

		photoPageBean.setTotalrows(photoDao.getTotalrowsByAid(albumId));
		photoPageBean.setPhotoList(photoList);

		return photoPageBean;
	}

	@Override
	public void update(Photo photo) {
		if (photo.getFilepath() == null || photo.getFilepath().equals("")) {
			photoDao.updateById(photo);
		} else {
			photoDao.update(photo);
		}
	}

	@Override
	public PhotoPageBean findPageByUid(int page, int pagesize, int uid) {
		PhotoPageBean photoPageBean = new PhotoPageBean();
		Map<String, Integer> map = new HashMap<String, Integer>();
		photoPageBean.setCurpage(page);
		photoPageBean.setPagesize(pagesize);

		map.put("page", (page - 1) * pagesize);
		map.put("pagesize", pagesize);
		map.put("uid", uid);

		List<Photo> photoList = photoDao.findByUid(map);

		photoPageBean.setTotalrows(photoDao.getTotalrowsByUid(uid));
		photoPageBean.setPhotoList(photoList);

		return photoPageBean;
	}

}
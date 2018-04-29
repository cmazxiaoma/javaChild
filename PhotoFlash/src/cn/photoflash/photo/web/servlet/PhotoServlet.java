package cn.photoflash.photo.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.photoflash.album.service.AlbumService;
import cn.photoflash.album.service.imp.AlbumServiceImp;
import cn.photoflash.photo.bean.Photo;
import cn.photoflash.photo.bean.PhotoPageBean;
import cn.photoflash.photo.service.PhotoService;
import cn.photoflash.photo.service.Imp.PhotoServiceImp;
import cn.photoflash.reply.bean.Reply;
import cn.photoflash.reply.service.ReplyService;
import cn.photoflash.reply.service.imp.ReplyServiceImp;
import cn.photoflash.user.bean.User;

@SuppressWarnings("serial")
public class PhotoServlet extends BaseServlet {

	private PhotoService photoService = new PhotoServiceImp();

	private AlbumService albumService = new AlbumServiceImp();

	private ReplyService replyService = new ReplyServiceImp();

	public String findAllByAid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String aid = request.getParameter("albumId");
		int page = getPc(request);
		int pagesize = 9;

		// 获取所有相册的名字
		request.getSession().setAttribute("albumNameList", albumService.findAll());

		// 分页显示
		PhotoPageBean photoPageBean = photoService.findByPage(page, pagesize, Integer.parseInt(aid));

		request.getSession().setAttribute("photo_pb", photoPageBean);

		return "f:/user/album/albumTophoto.jsp";
	}

	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int page = getPc(request);
		int pagesize = 9;

		// 获取相册的名字
		request.getSession().setAttribute("albumNameList", albumService.findAll());
		User user = (User) request.getSession().getAttribute("user");
		// 从数据库中查找
		PhotoPageBean photoPageBean = photoService.findByAllPage(page, pagesize, user.getUid());
		request.getSession().setAttribute("photo_pb", photoPageBean);
		return "f:/user/photo/PhotoManage.jsp";
	}

	// page页数
	private int getPc(HttpServletRequest request) {
		String value = request.getParameter("page");
		if (value == null || value.trim().equals("")) {
			return 1;
		}
		return Integer.parseInt(value);
	}

	public String addReply(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Reply reply = CommonUtils.toBean(request.getParameterMap(), Reply.class);
		User user = (User) request.getSession().getAttribute("user");
		reply.setPid(Integer.parseInt(request.getParameter("photoId")));
		reply.setUid(user.getUid());
		reply.setReplytime(new Date());
		replyService.add(reply);

		return find(request, response);
	}

	public String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("photoId");
		request.setAttribute("photoDesc", photoService.find(Integer.parseInt(pid)));
		request.setAttribute("replyList", replyService.findAll(Integer.parseInt(pid)));

		return "f:/user/photo/PhotoDetail.jsp";

	}

	public String findByPid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取页面传来的pid
		String pid = request.getParameter("pid");
		// 查找编辑的相片
		request.setAttribute("editPhoto", photoService.find(Integer.parseInt(pid)));
		// 保存相册的相册名
		request.getSession().setAttribute("albumNameList", albumService.findAll());

		return "f:/user/photo/EditPhoto.jsp";
	}

	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Photo photo = CommonUtils.toBean(request.getParameterMap(), Photo.class);
		photo.setIsdel(true);
		photoService.delete(photo);
		return findAll(request, response);
	}

	public String findMyPhotos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");

		int page = getPc(request);
		int pagesize = 9;

		// 获取相册的名字
		request.getSession().setAttribute("albumNameList", albumService.findAll());

		// 从数据库中查找
		PhotoPageBean photoPageBean = photoService.findPageByUid(page, pagesize, user.getUid());

		request.setAttribute("Myphoto_pb", photoPageBean);

		return "f:/user/photo/MyPhoto.jsp";
	}
}

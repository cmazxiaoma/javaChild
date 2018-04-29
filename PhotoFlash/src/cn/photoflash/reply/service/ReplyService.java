package cn.photoflash.reply.service;

import java.util.List;

import cn.photoflash.reply.bean.Reply;

/**
 * 回复类，依赖ReplyDao
 * 
 * @author yishuihan
 *
 */
public interface ReplyService {
	// 添加回复
	public void add(Reply reply);

	// 删除回复
	public void delete(Reply reply);

	// 查看某相片下的所有回复
	public List<Reply> findAll(int photoId);
}
package cn.photoflash.reply.dao;

import java.util.List;

import cn.photoflash.reply.bean.Reply;

/**
 * 回复信息
 * 
 * @author yishuihan
 *
 */
public interface ReplyDao {

	// 添加评论
	public void add(Reply reply);

	// 删除评论
	public void delete(Reply reply);

	// 查看评论
	public List<Reply> findAll(int pid);
}

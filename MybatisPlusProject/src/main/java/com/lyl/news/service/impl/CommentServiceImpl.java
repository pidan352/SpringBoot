package com.lyl.news.service.impl;

import com.lyl.news.entity.Comment;
import com.lyl.news.mapper.CommentMapper;
import com.lyl.news.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lyl
 * @since 2022-11-18
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}

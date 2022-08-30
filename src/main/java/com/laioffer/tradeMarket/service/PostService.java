package com.laioffer.tradeMarket.service;

import com.laioffer.tradeMarket.dao.PostDao;
import com.laioffer.tradeMarket.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostDao postDao;

    @Autowired
    public PostService(PostDao postDao) {
        this.postDao = postDao;
    }

    public void editPost(int postID, Post newPost) {
        postDao.editPost(postID, newPost);
        // update current post info based on new post
    }

    public void addPost(Post post) {
    }

    public void deletePost(int postID) {

    }
}
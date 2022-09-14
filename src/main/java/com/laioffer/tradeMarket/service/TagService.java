package com.laioffer.tradeMarket.service;

import com.laioffer.tradeMarket.dao.PostDao;
import com.laioffer.tradeMarket.dao.TagDao;
import com.laioffer.tradeMarket.entity.Post;
import com.laioffer.tradeMarket.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TagService {
    private final TagDao tagDao;

    @Autowired
    public TagService(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    public void addTag(int tagId, int postId) {
        tagDao.addTag(tagId, postId);
    }

    public void removeTag(int tagId, int postId) {
        tagDao.removeTag(tagId, postId);
    }

    public Set<Post> getAllPosts(int tagId){
        return tagDao.getAllPostsByTagId(tagId);
    }


}
package com.laioffer.tradeMarket.dao;

import com.laioffer.tradeMarket.entity.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public PostDao(SessionFactory sessionFactory) throws Exception {
        this.sessionFactory = sessionFactory;
    }

    public Post getPostById(int postID) {
        try (Session session = sessionFactory.openSession()) {
            // Post.class这张表里get到postId对应的那一行(用Post类型返回)
            // 我们只从一张表里找一行东西的时候我们就可以直接用session.get
            Post post = session.get(Post.class, postID);
            if ( post != null) {
                return post;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new Post();
    }

    public void addPost(Post newPost) {

    }

    public void editPost(int postID, Post newPost) {
        Post post = getPostById(postID);
        // 改变post底下的所有参数(仅用户可以改变的部分)
        post.setTitle(newPost.getTitle());
        post.setDescription(newPost.getDescription());
        post.setPrice(newPost.getPrice());
        post.setMedias(newPost.getMedias());
        post.setAppendTags(newPost.getAppendTags());

        Session session = null;
        try {
            session = sessionFactory.openSession();
            //强烈建议所有对数据库的操作都定义在一个transaction底下，因为这个可以保证原子性
            //Especially我们在对关系型数据库做改动的时候！！
            session.beginTransaction();
            // 我们这里是改变了post，需要存到数据库里
            session.saveOrUpdate(post);
            session.getTransaction().commit();

        } catch (Exception e) { // for all other db saving exceptions
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deletePost(int postID) {

    }
}
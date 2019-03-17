package com.java.proxy.service;

/**
 * @author lixiongxiong
 * @date 2019/3/17
 * @description forum
 */
public class ForumService implements ParentForum{

    @Override
    public void removeTopic(int topicId){
        System.out.println("Porum remove topicId...");
    }

    @Override
    public void removeForum(int forumId){
        System.out.println("Porum remove forumId...");
    }

}

package com.example.demo.repository;


import com.example.demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName UserRepository
 * @Description 用户仓库
 * @Author lixingxing
 * @Date 2020/8/8 11:37
 * @Version 1.0
 */

/**
 *  {@link com.example.demo.domain.User} {@link org.springframework.stereotype.Repository}
 */

@Repository
public class UserRepository {

    /**
     * 采用内存型的存储方式 -> map
     */
    private final ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger ID_GENERATOR = new AtomicInteger();

    /**
     * 保存用户对象
     * @param user {@link User} 对象
     * @return 如果保存成功，则返回<code>true</code>，
     *                   否则返回<code>false</code>
     */
    public boolean save(User user) {

        Integer id = ID_GENERATOR.incrementAndGet();

        user.setId(id);
        return repository.put(id, user) == null;
    }

    /**
     * 返回所有用户列表
     * @return
     */
    public Collection<User> findAll() {
        return repository.values();
    }
}

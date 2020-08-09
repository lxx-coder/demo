package com.example.demo.config;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * @ClassName RouterFunctionConfiguration
 * @Description TODO
 * @Author lixingxing
 * @Date 2020/8/8 17:08
 * @Version 1.0
 */

@Configuration
public class RouterFunctionConfiguration {

    /**
     * Servlet
     * 请求接口：ServeletRequest 或者 HttpServletRequest
     * 响应接口：ServletResponse 或者 HTTPServletResponse
     * Spring5.0 重新定义服务请求和响应：
     * 请求接口：ServerRequest
     * 响应接口：ServerResponse
     *
     * Flux是0-N个对象集合
     * Mono是0-1个对象集合
     * Reactive中的Flux 或者 Mono 是异步处理，非阻塞式
     * 集合对象基本上是同步处理，阻塞式
     * Flux 或者 Mono都是Publisher
     */

    /**
     * 定义GET方法  ，返回所有用户对象，URI：/person/find/all
     * @param userRepository
     * @return
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository) {

        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request -> {
                    // 返回所有对象
                    Collection<User> users = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux,User.class);
                });
    }
}

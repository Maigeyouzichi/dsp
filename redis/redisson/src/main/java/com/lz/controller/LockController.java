package com.lz.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihao
 * 测试分布式锁
 */
@RestController
public class LockController {

    private final RedissonClient redissonClient;

    public LockController(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @GetMapping("/redisson/lock/test")
    public String testLock() {
        // 1.获取锁，只要锁的名字一样，获取到的锁就是同一把锁。
        RLock lock = redissonClient.getLock("lz-lock");
        // 2.加锁
        lock.lock();
        try {
            System.out.println("加锁成功，执行后续代码。线程 ID：" + Thread.currentThread().getId());
            Thread.sleep(10000);
        } catch (Exception e) {
            //TODO
        } finally {
            lock.unlock();
            // 3.解锁
            System.out.println("Finally，释放锁成功。线程 ID：" + Thread.currentThread().getId());
        }
        return "test lock ok";
    }

}

package com.lz;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lz.entity.Cat;
import com.lz.entity.Dog;
import com.lz.entity.ListNode;
import lombok.SneakyThrows;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DailyTestSimpleApplication.class)
class DailyTestSimpleApplicationTests {

    @Autowired
    private JSONConfig jsonConfig;

    @Test
    void testForLoop() {
        ArrayList<Object> objects = Lists.newArrayList();
        for (Object object : objects) {
            Class<?> aClass = object.getClass();
        }
    }

    @Test
    void contextLoads() {
        //@JSONField(format = "yyyy-MM-dd HH:mm:ss")
        Date date = new Date();
        Dog dog = new Dog();
        dog.setName(null);
        dog.setBirthday(date);
        Cat cat = new Cat();
        cat.setDog(dog);
        cat.setName(null);
        System.out.println(JSONUtil.toJsonStr(JSONUtil.wrap(cat, jsonConfig)));
    }

    @Test
    void test002() {
        long hour = 19;
        System.out.println(hour / 24);
        System.out.println(hour % 24);
    }

    @Test
    void test003() {
        Dog dog = new Dog();
        String string = "{\"name\":\"\",\"birthday\":0}";
        Dog dog1 = JSON.parseObject(string, Dog.class);
        System.out.println(JSON.toJSONString(dog1));
    }

    @SneakyThrows
    @Test
    void test004() {
        Dog dog = new Dog();
        String string = "{\"name\":\"\",\"birthday\":0}";
        ObjectMapper mapper = new ObjectMapper();
        Dog dog1 = mapper.readValue(string, Dog.class);
        System.out.println(JSON.toJSONString(dog1));
    }


    /**
     * ????????????
     *
     * @param l1 ????????????1
     * @param l2 ????????????2
     * @return ????????????
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //res???????????????cur???res????????????
        ListNode res = new ListNode();
        ListNode cur = res;
        //????????????
        int carry = 0;
        while (l1 != null || l2 != null) {
            //????????????????????????????????????????????????????????????????????????????????????0???
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            //???????????????????????????
            int sum = a + b + carry;
            //??????10??????
            carry = sum / 10;
            //????????????????????????
            sum %= 10;
            //????????????????????????res??????
            cur.next = new ListNode(sum);
            cur = cur.next;
            //????????????
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        //???????????????????????????????????????????????????
        if (carry == 1) cur.next = new ListNode(1);
        return res.next;
    }


    public ListNode addTwoNum(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode cur = res;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = carry + a + b;
            carry = sum / 10;
            int val = sum % 10;
            cur.next = new ListNode(val);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) cur.next = new ListNode(1);
        return res.next;
    }

    @Test
    public void testBuilderPlateCard() {
        String s = buildVclNsBySubVehiclePlates(Lists.newArrayList());
        System.out.println(s);
    }

    /**
     * ??????????????????
     */
    private String buildVclNsBySubVehiclePlates(List<String> subVehiclePlates) {
        StringBuilder builder = new StringBuilder();
        for (String plate : subVehiclePlates) {
            builder.append(plate).append(CharUtil.COMMA);
        }
        return StrUtil.subPre(builder.toString(), -1);
    }

    /**
     * ??????????????????
     */
    @Test
    public void testArray() {
        int[] array1 = {1, 2};
        int[] array2 = {3, 4};
        int[] array3 = {5, 6};
        int[][] ints = {array1, array2, array3};
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }

        System.out.println(ints[0][1]);
    }


    @Test
    public void testColl() {

        List<String> objects = Lists.newArrayList();
        for (int i = 0; i < 70; i++) {
            objects.add("hello");
        }
        for (int i = 0; i < objects.size(); i = i + 50) {
            int end = (i + 50) > objects.size() ? objects.size() : (i + 50);
            List<String> subVehiclePlates = objects.subList(i, end);
            System.out.println(subVehiclePlates);
            Collection<String> subtract = CollUtil.subtract(Lists.newArrayList(subVehiclePlates), Lists.newArrayList("wo", "ld"));
            System.out.println(subtract);
        }
    }
}

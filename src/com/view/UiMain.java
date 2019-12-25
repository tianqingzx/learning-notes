package com.view;

import com.entity.Order;
import com.entity.Teacher;
import com.service.TeachService;
import com.service.impl.TeachServiceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UiMain {
    private Scanner sc = new Scanner(System.in);
    private TeachService teachService = new TeachServiceImpl();
    private RentCar rc = new RentCar();
    public Teacher teacher = new Teacher();

    public static void main(String[] args) {
        new UiMain().init();
    }

    public void init() {
        System.out.println("--------------\t");
        System.out.println("|请先登录\t|");
        System.out.println("--------------\t");
        login();
    }
    public void login(){
        boolean flag = true;
        int num = 1;
        while (flag && num<3){
            System.out.print("请输入你的教师编号：");
            String tId = sc.next();
            teacher.settId(tId);
            System.out.print("请输入你的密码：");
            String tPassword = sc.next();
            teacher.settPassword(tPassword);
            if (teachService.teachCheck(teacher)){
                teacher = teachService.getTeach(teacher.gettId());
                flag = false;
            }else {
                System.out.println("你的输入错误，请重新输入！（" + (3-num) + "次机会）");
                num += 1;
            }
        }
        if (!flag){
            mainMenu();
        }
    }

    public void mainMenu() {
        boolean flag = true;
        while(flag) {
            System.out.println("---------外包租车系统--------\t");
            System.out.println("|1.租车\t\t\t\t|");
            System.out.println("|2.查看订单记录\t\t|");
            System.out.println("|3.退出系统\t\t\t|");
            System.out.println("--------------------------\t");
            System.out.print("请输入你的选择：");
            int select = sc.nextInt();
            if(select == 1) {
                rentCar();
            }else if(select == 2) {
                getOrders();
            }else if(select == 3) {
                flag = false;
            }else {
                System.out.println("输入不允许，请重新选择！");
            }
        }
    }

    public void rentCar(){
        rc.rent(teacher);
    }

    public void getOrders(){
        ArrayList<Order> orderlist = teachService.getOrders(teacher);
        if (orderlist != null) {
            Order order;
            int num = 1;
            Iterator<Order> it = orderlist.iterator();
            while (it.hasNext()) {
                order = it.next();
                System.out.println(num + "\t" + order.toString());
                num += 1;
            }
        }else {
            System.out.println("你暂时没有订单记录");
        }
    }
}

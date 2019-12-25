package com.view;

import java.util.*;

import com.entity.Car;
import com.entity.RentInfo;
import com.service.RentService;
import com.service.impl.RentServiceimpl;

/**
 * @author user
 *
 */
public class RentCar {
    private Scanner sc = new Scanner(System.in);
    private RentService rentService = new RentServiceimpl();
    public RentInfo ri = new RentInfo();
    public ArrayList<Car> carlist;

    public void rent() {
        boolean flag = true;
        while (flag) {
            System.out.println("（时间格式：yyyy-mm-dd）");
            System.out.print("请输入你想要租车的开始时间：");
            ri.setbDate(sc.next());
            System.out.print("请输入租车结束时间：");
            ri.setrDate(sc.next());
            System.out.print("请输入搭乘人数：");
            ri.setAccommodate(sc.nextInt());
            System.out.print("请输入行驶里程数：");
            ri.setDistance(sc.nextInt());
            carlist = rentService.findCar(ri);
            if (carlist != null){
                int count = 1;
                Car car;
                Iterator<Car> it = carlist.iterator();
                while (it.hasNext()){
                    car = it.next();
                    System.out.println(count + "\t" + car.toString());
                    count += 1;
                }
                flag = afterRentInfo(flag);
            }else {
                System.out.println("没有满足你要求的车辆");
                flag = false;
            }
        }
    }

    public boolean afterRentInfo(boolean flag){
        while (flag) {
            System.out.println("1、选择租车\t2、重新查询\t3、返回主菜单");
            System.out.print("请输入（1、2或3）：");
            int select = sc.nextInt();
            if (select == 1) {
                rentMethod();
            } else if (select == 2){
                return false;
            } else if (select == 3){
                flag = false;
            } else {
                System.out.println("不支持该选项！");
            }
        }
        return flag;
    }

    public void rentMethod() {
        System.out.print("请输入你想要选择的车辆：");
        int num = sc.nextInt();
        Car car = carlist.get(num);
        System.out.println("rentService.rent()");
    }
}

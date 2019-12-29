package com.view;

import java.util.*;

import com.entity.Order;
import com.entity.SearchInfo;
import com.entity.Teacher;
import com.service.RentService;
import com.service.impl.RentServiceImpl;

/**
 * @author ZX
 *
 */
public class RentCar {
    private Scanner sc = new Scanner(System.in);
    private RentService rentService = new RentServiceImpl();
    private SearchInfo si = new SearchInfo();
    private ArrayList<SearchInfo> searchInfos;
    private Teacher teacher;

    public void rent(Teacher teach) {
        teacher = teach;
        boolean flag = true;
        while (flag) {
            System.out.println("（时间格式：yyyy-mm-dd）");
            System.out.print("请输入你想要租车的开始时间：");
            si.setBeginDate(sc.next());
            System.out.print("请输入租车结束时间：");
            si.setEndDate(sc.next());
            System.out.print("请输入搭乘人数：");
            si.setCarCapacity(sc.nextInt());
            System.out.print("请输入行驶里程数：");
            si.setMaxDistance(sc.nextInt());
            searchInfos = rentService.findCar(si);
            Iterator<SearchInfo> it = searchInfos.iterator();
            if (it.hasNext()){
                int count = 1;
                SearchInfo searchInfo;
                while (it.hasNext()){
                    searchInfo = it.next();
                    System.out.println(count + "\t" + searchInfo.toString());
                    count += 1;
                }
                flag = afterRentInfo(flag);
            }else {
                System.out.println("没有满足你要求的车辆");
                flag = false;
            }
        }
    }

    private boolean afterRentInfo(boolean flag){
        while (flag) {
            System.out.println("1、选择租用\t2、重新选择\t3、返回主菜单");
            System.out.print("请输入（1、2或3）：");
            int select = sc.nextInt();
            if (select == 1) {
                rentMethod();
            } else if (select == 2){
                break;
            } else if (select == 3){
                flag = false;
            } else {
                System.out.println("不支持该选项！");
            }
        }
        return flag;
    }

    private void rentMethod() {
        System.out.print("请输入你想要选择的车辆序号：");
        int num = sc.nextInt();
        SearchInfo searchInfo = searchInfos.get(num);
        Order order = new Order();
        order.setCarId(searchInfo.getCarId());
        order.settId(teacher.gettId());
        order.setBeginDate(si.getBeginDate());
        order.setEndDate(si.getEndDate());
        order.setDistance(si.getMaxDistance());
        if (rentService.rent(order)) {
            System.out.println("恭喜租借成功\n");
        }else {
            System.out.println("租借失败\n");
        }
    }
}

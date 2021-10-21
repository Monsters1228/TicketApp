package jee.ticket.dao;

import jee.ticket.domain.Ticket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketDao {
    //使用静态变量，只保存一份副本
    private  static  List<Ticket> ticketList  = new ArrayList<Ticket>();;
    //静态变量， 票据ID号，全局唯一
    private static  volatile long TICKET_ID_SEQUENCE = 1000;
    //构造函数
    public  TicketDao(){
        //只初始化1次
        if(ticketList.size()==0) {
            //初始化数据
            for (int i = 0; i < 10; ++i) {
                Ticket ticket = new Ticket("中山领航科技公司", 5000 * i, "办公器材" + i,
                        "2020年新购置办公设备、电脑设备" + i, "银行汇票");

                ticket.setId(this.TICKET_ID_SEQUENCE);
                TICKET_ID_SEQUENCE++;
                ticket.setSubmitDate(new Date());
                ticketList.add(ticket);
            }
        }
    }
    //根据id查找ticket对象
    public Ticket findById(long id){
        for (Ticket ticket: ticketList) {
            if (ticket.getId() == id)
                return ticket;
        }
        return  null;
    }
    //查找所有的ticket对象
    public List findAll(){
        return  ticketList;
    }

    // 添加票据,使用同步加锁
    public synchronized void insert(Ticket ticket){
        //生成票据id
        TICKET_ID_SEQUENCE++;
        ticket.setId(TICKET_ID_SEQUENCE);
        ticketList.add(ticket);
        System.out.println(ticket+";" +ticketList.size());
    }
    //删除票据
    public void deleteById(long id) {
        for (Ticket ticket: ticketList) {
            if (ticket.getId() == id) {
                ticketList.remove(ticket);
                return;
            }
        }
    }
}

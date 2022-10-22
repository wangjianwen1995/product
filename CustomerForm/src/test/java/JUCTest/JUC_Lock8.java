package JUCTest;

import java.util.concurrent.TimeUnit;

/**
  大名鼎鼎 八锁现象

  1 标准访问 ,先打印短信还是邮件
      ----发送信息
      ----发送邮件
  2 停4秒在短信方法内,先打印短信还是邮件
     ----发送信息
     ----发送邮件
  3 新增普通方法sayHello,实现打印短信还是hello
     ----你好
     ----发送信息
     ----发送邮件
  4 现在有两部手机,先打印短信还是邮件
     ----发送邮件
     ----发送信息
  5 两个静态同步方法,1部手机,先打印短信还是邮件
     ----发送信息
     ----发送邮件
  6 两个静态同步方法,2部手机,先打印短信还是邮件
     ----发送信息
     ----发送邮件
  7 1个静态同步方法,1个普通同步方法,1部手机,先打印短信还是邮件
     ----发送邮件
     ----发送信息
  8 1个静态同步方法,1个普通同步方法,2部手机,先打印短信还是邮件
     ----发送邮件
     ----发送信息
 * key synchronized
 *          对于普通同步方法,锁是当前实例对象
 *          对于静态同步方法,锁是当前的class对象
 *          对于同步方法块,锁是synchronized括号里配置的对象
 *  同时需要掌握: 乐观锁、悲观锁、公平锁、非公平锁、可重入锁、读写锁、自旋锁 7把锁
 *
 *
 */
public class JUC_Lock8 {

    public static void main(String[] args) throws InterruptedException {
        Phone p1 = new Phone();
        Phone p2 = new Phone();

        new Thread(()->{
            p1.sendSMS();
        }
         ,"AA").start();

        Thread.sleep(100);

        new Thread(()->{
            p2.sendEmail();
        }
                ,"AA").start();
       // new Thread(p1::sayHello,"BB").start();
    }


}

class Phone{
    public   synchronized void sendSMS()  {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----发送信息");
    }
    public static synchronized void sendEmail(){
        System.out.println("----发送邮件");
    }
    public   void sayHello(){
        System.out.println("----你好");
    }
}
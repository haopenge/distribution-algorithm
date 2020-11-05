package com.husky.observer.gperadvice;

/**
 * Created by Liuph on 2019/3/17.
 */
public class ObserverTest {
    public static void main(String[] args) {
        GPer gper = GPer.getInstance();
        Teacher Liuph = new Teacher("Liuph");
        Teacher mic = new Teacher("Mic");


        //这为没有@Liuph老师
        Question question = new Question();
        question.setUserName("小明");
        question.setContent("观察者设计模式适用于哪些场景？");
        gper.addObserver(Liuph);
        gper.addObserver(mic);
        gper.publishQuestion(question);


    }

}

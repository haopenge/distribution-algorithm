package com.uu.pipline;

import java.util.Map;
import java.util.Objects;

/**
 * @desc 默认业务处理管道
 * @author liuph
 * @date 2021/04/02 15:48
 */
public class DefaultBusinessPipeline implements BusinessPipeline {

    private BusinessHandlerNode head = new BusinessHandlerNode();


    private BusinessHandlerNode tail;

    private BusinessHandlerContext context = null;


    public DefaultBusinessPipeline(BusinessHandlerContext context) {
        this.context = context;
        tail = head;
    }

    /**
     * 启动
     */
    @Override
    public void start() {
        head.getNext().exec(context);
    }


    @Override
    public void addFirst(BusinessHandler... handlers) {
        BusinessHandlerNode temp = head;
        for (BusinessHandler handler : handlers) {
            if(Objects.isNull(handler)){
                continue;
            }
            BusinessHandlerNode node = new BusinessHandlerNode();
            node.setHandler(handler);
            node.setNext(temp);

            temp = node;
        }
        head = temp;
    }

    @Override
    public void addLast(BusinessHandler... handlers) {
        BusinessHandlerNode temp = tail;
        for (BusinessHandler handler : handlers) {
            if(Objects.isNull(handler)){
                continue;
            }
            BusinessHandlerNode node = new BusinessHandlerNode();
            node.setHandler(handler);
            temp.setNext(node);

            temp = node;
        }

        tail = temp;
    }

    /**
     * 获取结果
     */
    @Override
    public Map getResult() {


        return null;
    }
}

package com.uu.pipline;

/**
 * @desc  业务执行节点
 * @author liuph
 * @date 2021/04/02 15:50
 */
public class BusinessHandlerNode {

    private BusinessHandler handler;

    private BusinessHandlerNode next = null;

    public void exec(BusinessHandlerContext context){
        boolean success = handler.handler(context);
        if(next != null){
            if(success){
                next.exec(context);
            }
        }
    }

    public BusinessHandlerNode getNext() {
        return next;
    }

    public void setNext(BusinessHandlerNode next) {
        this.next = next;
    }

    public void setHandler(BusinessHandler handler) {
        this.handler = handler;
    }

    public BusinessHandler getHandler() {
        return handler;
    }
}

package com.husky.observer.events;

import com.husky.observer.events.mouseevent.Mouse;
import com.husky.observer.events.mouseevent.MouseEventCallback;
import com.husky.observer.events.mouseevent.MouseEventType;

/**
 * Created by Liuph on 2019/3/17.
 */
public class MouseEventTest {
    public static void main(String[] args) {

        MouseEventCallback callback = new MouseEventCallback();

        Mouse mouse = new Mouse();

        //@谁？  @回调方法
        mouse.addLisenter(MouseEventType.ON_CLICK,callback);
        mouse.addLisenter(MouseEventType.ON_FOCUS,callback);

        mouse.click();

        mouse.focus();


    }
}

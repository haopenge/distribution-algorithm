package com.husky.decorator.passport;


import com.husky.decorator.passport.old.SigninService;
import com.husky.decorator.passport.upgrade.ISiginForThirdService;
import com.husky.decorator.passport.upgrade.SiginForThirdService;

/**
 * Created by Liuph on 2019/3/17.
 */
public class DecoratorTest {

    public static void main(String[] args) {

        //满足一个is-a
        ISiginForThirdService siginForThirdService = new SiginForThirdService(new SigninService());
        siginForThirdService.loginForQQ("sdfasfdasfsf");

    }


}

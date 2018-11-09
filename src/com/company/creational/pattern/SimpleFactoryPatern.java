package com.company.creational.pattern;

/*简单工厂模式*/
public class SimpleFactoryPatern {
    //以登录为例

    /*抽象产品Login*/
    public interface Login{
         Boolean Verify(String name ,String password);
    }

    /*具体产品DomainLogin*/
    public static class DomainLogin implements Login{
        @Override
        public Boolean Verify(String name, String password) {
            /*业务逻辑*/
            return true;

        }
    }

    /*具体产品PasswordLogin*/
    public static class PasswordLogin implements Login{
        @Override
        public Boolean Verify(String name, String password) {
            /*业务逻辑*/
            return true;
        }
    }

    /*工厂类LoginManager*/
    public static class LoginManager{
        public static Login factory(String type){
            if (type.equals("passCode")){
                return new DomainLogin();
            }else if(type.equals("password")){
                return new PasswordLogin();
            }else {
                throw new RuntimeException();
            }
        }
    }

     //测试实现
    public class Test{
        public void text(){
            String loginType = "password";
            String name = "name";
            String password = "password";
            Login login = LoginManager.factory(loginType);
            boolean isOk = login.Verify(name ,password);
            if(isOk){
                /*业务逻辑*/
            }else {
                /*业务逻辑*/
            }
        }
     }
}



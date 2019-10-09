package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 16:45 2019/9/10
 * @Version: $
 */
public class User {
    private String name;
    private int age;
    private String gender;
    private Date birthday;

    public User(String name, int age, String gender, Date birthday) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
    }
    public String getStrBir(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd hh:mm:ss");

        return sdf.format(new Date());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

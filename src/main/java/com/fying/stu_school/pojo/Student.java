package com.fying.stu_school.pojo;

import java.util.Date;
import java.util.Objects;

public class Student {
    private Integer id;
    private Integer ender;
    private String modifier;
    private String name;
    private String salt;
    private String password;
    private String avatar;
    private String tel;
    private Date birth;
    private Date modificationTime;

    //构造方法
    public Student() {
    }

    public Student(Integer id, Integer ender, String modifier, String name, String salt, String password, String avatar, String tel, Date birth, Date modificationTime) {
        this.id = id;
        this.ender = ender;
        this.modifier = modifier;
        this.name = name;
        this.salt = salt;
        this.password = password;
        this.avatar = avatar;
        this.tel = tel;
        this.birth = birth;
        this.modificationTime = modificationTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnder() {
        return ender;
    }

    public void setEnder(Integer ender) {
        this.ender = ender;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getmodificationTime() {
        return modificationTime;
    }

    public void setmodificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", ender=" + ender +
                ", modifier='" + modifier + '\'' +
                ", name='" + name + '\'' +
                ", salt='" + salt + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", tel='" + tel + '\'' +
                ", birth=" + birth +
                ", modificationTime=" + modificationTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId()) && Objects.equals(getEnder(), student.getEnder()) && Objects.equals(getModifier(), student.getModifier()) && Objects.equals(getName(), student.getName()) && Objects.equals(getSalt(), student.getSalt()) && Objects.equals(getPassword(), student.getPassword()) && Objects.equals(getAvatar(), student.getAvatar()) && Objects.equals(getTel(), student.getTel()) && Objects.equals(getBirth(), student.getBirth()) && Objects.equals(getmodificationTime(), student.getmodificationTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEnder(), getModifier(), getName(), getSalt(), getPassword(), getAvatar(), getTel(), getBirth(), getmodificationTime());
    }
}

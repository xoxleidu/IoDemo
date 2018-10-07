package com.dl;

import com.dl.pojo.User;

import java.io.*;

public class Demo {

    public static void write(){

        OutputStream os;
        DataOutputStream dos;

        ObjectOutputStream oos;

        {
            try {
                os = new FileOutputStream("f:\\1.txt");
                dos = new DataOutputStream(os);
                dos.write(1);
                dos.writeUTF("我的梦想");
                dos.close();
                os.close();

                /*User user = new User();
                user.setName("小包");
                user.setAge(20);*/
                //对象数组形式保存
                User[] users = {new User("小红",21),new User("小白",22),new User("小黑",23)};

                os = new FileOutputStream("f:\\obj.tmp");
                oos = new ObjectOutputStream(os);
                oos.write(2);
                oos.writeObject(users);
                oos.close();
                os.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void read() {

        InputStream is;

        BufferedInputStream bis;
        Reader rbis;
        StringBuilder sb;

        DataInputStream dis;

        ObjectInputStream ois;

        try {
            is = new FileInputStream("f:\\1.txt");
            bis = new BufferedInputStream(is);
            rbis = new InputStreamReader(bis);
            sb = new StringBuilder();
            char[] chars = new char[512];
            int len = -1;
            try {
                while ((len = rbis.read(chars)) != -1 ) {
                    sb.append(new String(chars,0,len));
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
            rbis.close();
            bis.close();
            is.close();
            System.out.println(sb);


            is = new FileInputStream("f:\\1.txt");
            dis = new DataInputStream(is);
            int ri = dis.read();
            String str = dis.readUTF();
            dis.close();
            is.close();
            System.out.println(ri);
            System.out.println(str);

            is = new FileInputStream("f:\\obj.tmp");
            ois = new ObjectInputStream(is);
            int roi = ois.read();

            //User user = (User) ois.readObject();

            //对象数组形式读取
            User[] users = (User[]) ois.readObject();

            System.out.println(roi);

            /*System.out.println(user.getName());
            System.out.println(user.getAge());*/

            for (User user:users
                 ) {
                System.out.println(user.getName());
                System.out.println(user.getAge());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static void string() {
        StringWriter sw = new StringWriter();
        sw.write("他们的梦想");

        StringReader sr = new StringReader(sw.toString());
        char[] chars = new char[128];
        int len = -1;
        try {
            while ((len = sr.read(chars)) != -1 ) {
                System.out.print(new String(chars,0,len));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        //write();
        read();
        //string();

    }

}

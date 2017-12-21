package fragmen.bwei.com.jdcase.bean;

/**
 * Created by kang on 2017/11/8.
 */

public class LoginBean extends Basebean{


    /**
     * data : {"age":null,"appkey":"2a01bf572b5940d7","appsecret":"D66C745BF625C60C3A92982CEDF4D495","createtime":"2017-11-08T14:29:59","email":null,"gender":null,"icon":null,"mobile":"15600589918","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","token":"230E98D7E015A76DD41E3777B3D85F17","uid":1839,"username":"15600589918"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : 2a01bf572b5940d7
         * appsecret : D66C745BF625C60C3A92982CEDF4D495
         * createtime : 2017-11-08T14:29:59
         * email : null
         * gender : null
         * icon : null
         * mobile : 15600589918
         * money : null
         * nickname : null
         * password : 8F669074CAF5513351A2DE5CC22AC04C
         * token : 230E98D7E015A76DD41E3777B3D85F17
         * uid : 1839
         * username : 15600589918
         */

        private Object age;
        private String appkey;
        private String appsecret;
        private String createtime;
        private Object email;
        private Object gender;
        private Object icon;
        private String mobile;
        private Object money;
        private Object nickname;
        private String password;
        private String token;
        private String uid;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public String getAppkey() {
            return appkey;
        }

        public void setAppkey(String appkey) {
            this.appkey = appkey;
        }

        public String getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(String appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getMoney() {
            return money;
        }

        public void setMoney(Object money) {
            this.money = money;
        }

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}

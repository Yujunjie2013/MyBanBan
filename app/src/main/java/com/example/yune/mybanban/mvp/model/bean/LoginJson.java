package com.example.yune.mybanban.mvp.model.bean;

/**
 * Created by Yune on 2016/11/9.
 */

public class LoginJson {

    @Override
    public String toString() {
        return "LoginJson{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * status : 0000
     * message : 请求成功
     * data : {"token":"f9884d6809f7d722fea85b82b352e2e7","companyUserInfo":{"userInfoOut":{"userId":100548,"userLevel":"1","userPhone":"18516146652","userPw":"4297f44b13955235245b2497399d7a93","userName":"cgh","userIdcard":null,"userSex":null,"userAge":null,"userMail":null,"userStatus":1,"namePreafix":"C","activeTime":"2016-07-08 14:37:33","nomalCompanyId":"402891db55bdf0190155bdf100ad0000","createTime":"2016-07-07 10:29:29","userSource":null,"findType":null,"photoUrl":"http://banban-picture.img-cn-shanghai.aliyuncs.com/base/sys-photo4.png@100w_100h.png"},"companyInfoOut":{"companyId":"402891db55bdf0190155bdf100ad0000","companyCodeId":"000121","companyName":"test","companyLevel":1,"companyAddress":null,"companyMail":null,"companyEmail":null,"companyPhone":"18516146652","companyBusiness":null,"companyIntroduction":null,"companyStatus":1,"picId":null,"createTime":"2016-07-06 10:02:16","photoUrl":null},"status":"4"}}
     */

    private String status;
    private String message;
    /**
     * token : f9884d6809f7d722fea85b82b352e2e7
     * companyUserInfo : {"userInfoOut":{"userId":100548,"userLevel":"1","userPhone":"18516146652","userPw":"4297f44b13955235245b2497399d7a93","userName":"cgh","userIdcard":null,"userSex":null,"userAge":null,"userMail":null,"userStatus":1,"namePreafix":"C","activeTime":"2016-07-08 14:37:33","nomalCompanyId":"402891db55bdf0190155bdf100ad0000","createTime":"2016-07-07 10:29:29","userSource":null,"findType":null,"photoUrl":"http://banban-picture.img-cn-shanghai.aliyuncs.com/base/sys-photo4.png@100w_100h.png"},"companyInfoOut":{"companyId":"402891db55bdf0190155bdf100ad0000","companyCodeId":"000121","companyName":"test","companyLevel":1,"companyAddress":null,"companyMail":null,"companyEmail":null,"companyPhone":"18516146652","companyBusiness":null,"companyIntroduction":null,"companyStatus":1,"picId":null,"createTime":"2016-07-06 10:02:16","photoUrl":null},"status":"4"}
     */

    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        @Override
        public String toString() {
            return "DataBean{" +
                    "token='" + token + '\'' +
                    ", companyUserInfo=" + companyUserInfo +
                    '}';
        }

        private String token;
        /**
         * userInfoOut : {"userId":100548,"userLevel":"1","userPhone":"18516146652","userPw":"4297f44b13955235245b2497399d7a93","userName":"cgh","userIdcard":null,"userSex":null,"userAge":null,"userMail":null,"userStatus":1,"namePreafix":"C","activeTime":"2016-07-08 14:37:33","nomalCompanyId":"402891db55bdf0190155bdf100ad0000","createTime":"2016-07-07 10:29:29","userSource":null,"findType":null,"photoUrl":"http://banban-picture.img-cn-shanghai.aliyuncs.com/base/sys-photo4.png@100w_100h.png"}
         * companyInfoOut : {"companyId":"402891db55bdf0190155bdf100ad0000","companyCodeId":"000121","companyName":"test","companyLevel":1,"companyAddress":null,"companyMail":null,"companyEmail":null,"companyPhone":"18516146652","companyBusiness":null,"companyIntroduction":null,"companyStatus":1,"picId":null,"createTime":"2016-07-06 10:02:16","photoUrl":null}
         * status : 4
         */

        private CompanyUserInfoBean companyUserInfo;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public CompanyUserInfoBean getCompanyUserInfo() {
            return companyUserInfo;
        }

        public void setCompanyUserInfo(CompanyUserInfoBean companyUserInfo) {
            this.companyUserInfo = companyUserInfo;
        }

        public static class CompanyUserInfoBean {
            @Override
            public String toString() {
                return "CompanyUserInfoBean{" +
                        "userInfoOut=" + userInfoOut +
                        ", companyInfoOut=" + companyInfoOut +
                        ", status='" + status + '\'' +
                        '}';
            }

            /**
             * userId : 100548
             * userLevel : 1
             * userPhone : 18516146652
             * userPw : 4297f44b13955235245b2497399d7a93
             * userName : cgh
             * userIdcard : null
             * userSex : null
             * userAge : null
             * userMail : null
             * userStatus : 1
             * namePreafix : C
             * activeTime : 2016-07-08 14:37:33
             * nomalCompanyId : 402891db55bdf0190155bdf100ad0000
             * createTime : 2016-07-07 10:29:29
             * userSource : null
             * findType : null
             * photoUrl : http://banban-picture.img-cn-shanghai.aliyuncs.com/base/sys-photo4.png@100w_100h.png
             */

            private UserInfoOutBean userInfoOut;
            /**
             * companyId : 402891db55bdf0190155bdf100ad0000
             * companyCodeId : 000121
             * companyName : test
             * companyLevel : 1
             * companyAddress : null
             * companyMail : null
             * companyEmail : null
             * companyPhone : 18516146652
             * companyBusiness : null
             * companyIntroduction : null
             * companyStatus : 1
             * picId : null
             * createTime : 2016-07-06 10:02:16
             * photoUrl : null
             */

            private CompanyInfoOutBean companyInfoOut;
            private String status;

            public UserInfoOutBean getUserInfoOut() {
                return userInfoOut;
            }

            public void setUserInfoOut(UserInfoOutBean userInfoOut) {
                this.userInfoOut = userInfoOut;
            }

            public CompanyInfoOutBean getCompanyInfoOut() {
                return companyInfoOut;
            }

            public void setCompanyInfoOut(CompanyInfoOutBean companyInfoOut) {
                this.companyInfoOut = companyInfoOut;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public static class UserInfoOutBean {

                @Override
                public String toString() {
                    return "UserInfoOutBean{" +
                            "userId=" + userId +
                            ", userLevel='" + userLevel + '\'' +
                            ", userPhone='" + userPhone + '\'' +
                            ", userPw='" + userPw + '\'' +
                            ", userName='" + userName + '\'' +
                            ", userIdcard=" + userIdcard +
                            ", userSex=" + userSex +
                            ", userAge=" + userAge +
                            ", userMail=" + userMail +
                            ", userStatus=" + userStatus +
                            ", namePreafix='" + namePreafix + '\'' +
                            ", activeTime='" + activeTime + '\'' +
                            ", nomalCompanyId='" + nomalCompanyId + '\'' +
                            ", createTime='" + createTime + '\'' +
                            ", userSource=" + userSource +
                            ", findType=" + findType +
                            ", photoUrl='" + photoUrl + '\'' +
                            '}';
                }

                private int userId;
                private String userLevel;
                private String userPhone;
                private String userPw;
                private String userName;
                private Object userIdcard;
                private Object userSex;
                private Object userAge;
                private Object userMail;
                private int userStatus;
                private String namePreafix;
                private String activeTime;
                private String nomalCompanyId;
                private String createTime;
                private Object userSource;
                private Object findType;
                private String photoUrl;

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public String getUserLevel() {
                    return userLevel;
                }

                public void setUserLevel(String userLevel) {
                    this.userLevel = userLevel;
                }

                public String getUserPhone() {
                    return userPhone;
                }

                public void setUserPhone(String userPhone) {
                    this.userPhone = userPhone;
                }

                public String getUserPw() {
                    return userPw;
                }

                public void setUserPw(String userPw) {
                    this.userPw = userPw;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public Object getUserIdcard() {
                    return userIdcard;
                }

                public void setUserIdcard(Object userIdcard) {
                    this.userIdcard = userIdcard;
                }

                public Object getUserSex() {
                    return userSex;
                }

                public void setUserSex(Object userSex) {
                    this.userSex = userSex;
                }

                public Object getUserAge() {
                    return userAge;
                }

                public void setUserAge(Object userAge) {
                    this.userAge = userAge;
                }

                public Object getUserMail() {
                    return userMail;
                }

                public void setUserMail(Object userMail) {
                    this.userMail = userMail;
                }

                public int getUserStatus() {
                    return userStatus;
                }

                public void setUserStatus(int userStatus) {
                    this.userStatus = userStatus;
                }

                public String getNamePreafix() {
                    return namePreafix;
                }

                public void setNamePreafix(String namePreafix) {
                    this.namePreafix = namePreafix;
                }

                public String getActiveTime() {
                    return activeTime;
                }

                public void setActiveTime(String activeTime) {
                    this.activeTime = activeTime;
                }

                public String getNomalCompanyId() {
                    return nomalCompanyId;
                }

                public void setNomalCompanyId(String nomalCompanyId) {
                    this.nomalCompanyId = nomalCompanyId;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public Object getUserSource() {
                    return userSource;
                }

                public void setUserSource(Object userSource) {
                    this.userSource = userSource;
                }

                public Object getFindType() {
                    return findType;
                }

                public void setFindType(Object findType) {
                    this.findType = findType;
                }

                public String getPhotoUrl() {
                    return photoUrl;
                }

                public void setPhotoUrl(String photoUrl) {
                    this.photoUrl = photoUrl;
                }
            }

            public static class CompanyInfoOutBean {
                private String companyId;
                private String companyCodeId;
                private String companyName;
                private int companyLevel;
                private Object companyAddress;
                private Object companyMail;
                private Object companyEmail;
                private String companyPhone;
                private Object companyBusiness;
                private Object companyIntroduction;
                private int companyStatus;
                private Object picId;
                private String createTime;
                private Object photoUrl;

                public String getCompanyId() {
                    return companyId;
                }

                public void setCompanyId(String companyId) {
                    this.companyId = companyId;
                }

                public String getCompanyCodeId() {
                    return companyCodeId;
                }

                public void setCompanyCodeId(String companyCodeId) {
                    this.companyCodeId = companyCodeId;
                }

                public String getCompanyName() {
                    return companyName;
                }

                public void setCompanyName(String companyName) {
                    this.companyName = companyName;
                }

                public int getCompanyLevel() {
                    return companyLevel;
                }

                public void setCompanyLevel(int companyLevel) {
                    this.companyLevel = companyLevel;
                }

                public Object getCompanyAddress() {
                    return companyAddress;
                }

                public void setCompanyAddress(Object companyAddress) {
                    this.companyAddress = companyAddress;
                }

                public Object getCompanyMail() {
                    return companyMail;
                }

                public void setCompanyMail(Object companyMail) {
                    this.companyMail = companyMail;
                }

                public Object getCompanyEmail() {
                    return companyEmail;
                }

                public void setCompanyEmail(Object companyEmail) {
                    this.companyEmail = companyEmail;
                }

                public String getCompanyPhone() {
                    return companyPhone;
                }

                public void setCompanyPhone(String companyPhone) {
                    this.companyPhone = companyPhone;
                }

                public Object getCompanyBusiness() {
                    return companyBusiness;
                }

                public void setCompanyBusiness(Object companyBusiness) {
                    this.companyBusiness = companyBusiness;
                }

                public Object getCompanyIntroduction() {
                    return companyIntroduction;
                }

                public void setCompanyIntroduction(Object companyIntroduction) {
                    this.companyIntroduction = companyIntroduction;
                }

                public int getCompanyStatus() {
                    return companyStatus;
                }

                public void setCompanyStatus(int companyStatus) {
                    this.companyStatus = companyStatus;
                }

                public Object getPicId() {
                    return picId;
                }

                public void setPicId(Object picId) {
                    this.picId = picId;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public Object getPhotoUrl() {
                    return photoUrl;
                }

                public void setPhotoUrl(Object photoUrl) {
                    this.photoUrl = photoUrl;
                }
            }
        }
    }

}

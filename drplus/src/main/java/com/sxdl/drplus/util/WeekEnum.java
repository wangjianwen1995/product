package com.sxdl.drplus.util;

public enum WeekEnum {



        SECONDS("1", "星期天", "Sunday "), MONDAY("2", "星期一", "Monday "), TUESDAY("3", "星期二", "Tuesday "), WEDNESDAY("4",

                "星期三", "Wednesday "), THURSDAY("5", "星期四",

                "Thursday "), FRIDAY("6", "星期五", "Friday "), SATURDAY("7", "星期六", "Saturday ");



        private String key;

        private String nameCn;

        private String nameEn;



        WeekEnum(String key, String nameCn, String nameEn) {

            this.key = key;

            this.nameCn = nameCn;

            this.nameEn = nameEn;

        }



        public static String matchNameCn(String code) {

            for (WeekEnum m : WeekEnum.values()) {

                if (m.getKey().equals(code)) {

                    return m.getNameCn();

                }

            }

            return "";

        }



        public static String matchNameEn(String code) {

            for (WeekEnum m : WeekEnum.values()) {

                if (m.getKey().equals(code)) {

                    return m.getNameEn();

                }

            }

            return "";

        }





        public String getKey() {

            return key;

        }



        public void setKey(String key) {

            this.key = key;

        }



        public String getNameCn() {

            return nameCn;

        }



        public void setNameCn(String nameCn) {

            this.nameCn = nameCn;

        }



        public String getNameEn() {

            return nameEn;

        }



        public void setNameEn(String nameEn) {

            this.nameEn = nameEn;

        }

}

package com.tnpy.common.Enum;

/**
 * @Description: TODO
 * @Author: LLS
 * @Date: 2019/1/3 13:50
 */
public class DirectoryEnum {
    public static  enum FileStoreLocation {
        UploadDocument("D:/TNFile/UploadDocument/", 1), EquipInfoPicture("D:/TNFile/EquipInfoPicture/", 2);
        // 成员变量
        private String name;
        private int index;
        // 构造方法
        private FileStoreLocation(String name, int index) {
            this.name = name;
            this.index = index;
        }
        // 普通方法
        public static String getName(int index) {
            for (DirectoryEnum.FileStoreLocation c : DirectoryEnum.FileStoreLocation.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }
        // get set 方法
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }
    }
}
